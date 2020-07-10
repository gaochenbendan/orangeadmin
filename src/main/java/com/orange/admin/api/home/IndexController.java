package com.orange.admin.api.home;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.commons.utils.SessionUtil;
import com.orange.admin.commons.utils.ValidataUtil2;
import com.orange.admin.pojo.admin.bo.Result;
import com.orange.admin.pojo.admin.sc.CodeMsg;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.pojo.common.News;
import com.orange.admin.service.adminservice.GoodsCategoryService;
import com.orange.admin.service.adminservice.NewsService;
import com.orange.admin.service.adminservice.OperaterLogService;
import com.orange.admin.service.homeservice.CustomerService;
import com.orange.admin.service.homeservice.FriendLinkService;
import com.orange.admin.service.homeservice.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 高晨
 */
@Controller
@RequestMapping("/home/index")
public class IndexController {


    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OperaterLogService operaterLogService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private FriendLinkService friendLinkService;


    /**
     * 登录首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model, PageUtil<Goods> pageUtil,Goods goods) {
        pageUtil.setPageSize(12);
        goods.setStatus(Goods.GOODS_STATUS_UP);
        model.addAttribute("soldTotal",goodsService.coutSellOut());
        model.addAttribute("goodsList",goodsService.findList(pageUtil,goods));
        model.addAttribute("name",goods.getName());
        model.addAttribute("newsList",newsService.findList(6));

        return "home/index/index";

    }



    /**
     * 登录页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {

        return "home/index/login";

    }

    /**
     * 检查学号是否存在
     * @param sn
     * @return
     */
    @RequestMapping(value = "/check_sn", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> checksn(@RequestParam(name = "sn",required = true) String sn)
    {
        Customer bySn = customerService.findBySn(sn);

        return Result.success(bySn == null);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> register(Customer customer)
    {
        CodeMsg validate = ValidataUtil2.validate(customer);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode())
        {
            return Result.errot(validate);
        }
        if(customerService.findBySn(customer.getSn()) != null)
        {
            return Result.errot(CodeMsg.CUNSTOM_CN_ERROR);
        }

        if(customerService.save(customer) == null)
        {
            return Result.errot(CodeMsg.CUNSTOM_CN_ADD_ERROR);
        }

        operaterLogService.add("消费者日志", "用户注册:学号为【" +customer.getSn()+ "】");


        SessionUtil.set("CustomerL",customer);

        return Result.success(true);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public  String logout(HttpServletRequest request) {

        try {

            SessionUtil.set("CustomerL",null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:login";

    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> login(@RequestParam(name="sn",required=true)String sn,
                                 @RequestParam(name="password",required=true)String password){
        Customer bySn = customerService.findBySn(sn);

        if(bySn == null){
            return Result.errot(CodeMsg.HOME_STUDENT_REGISTER_SN_EXIST);
        }
        Customer save = customerService.save(bySn);
        if(save == null){
            return Result.errot(CodeMsg.HOME_STUDENT_SN_NO_EXIST);
        }
        //表示学号存在，验证密码是否正确
        if(!bySn.getPassword().equals(password)){
            return Result.errot(CodeMsg.HOME_STUDENT_PASSWORD_ERROR);
        }
        //验证用户状态是否被冻结
        if(bySn.getStatus() != Customer.STUDENT_STATUS_ENABLE){
            return Result.errot(CodeMsg.HOME_STUDENT_UNABLE);
        }
        //表示一切都符合，此时将用户信息放入session
        SessionUtil.set("CustomerL", bySn);

        operaterLogService.add("消费者日志", "用户登录:学号为【" +bySn.getSn()+ "】");

        return Result.success(true);
    }

    @RequestMapping("/news_detail")
    public  String newsDetail(Model model,@RequestParam(name = "id",required = true)Long id) {
        News byId = newsService.findById(id);
        model.addAttribute("newsdetail",newsService.findById(id));

        byId.setViewNumber(byId.getViewNumber()+1);

        newsService.save(byId);

        return "/home/index/new_detail";
    }
}
