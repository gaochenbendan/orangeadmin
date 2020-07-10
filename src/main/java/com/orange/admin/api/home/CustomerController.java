package com.orange.admin.api.home;

import com.orange.admin.commons.utils.SessionUtil;
import com.orange.admin.commons.utils.ValidataUtil2;
import com.orange.admin.pojo.admin.bo.Result;
import com.orange.admin.pojo.admin.sc.CodeMsg;
import com.orange.admin.pojo.common.*;
import com.orange.admin.service.adminservice.GoodsCategoryService;
import com.orange.admin.service.adminservice.OperaterLogService;
import com.orange.admin.service.homeservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/home/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private OperaterLogService operaterLogService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private WantedGoodsService wantedGoodsService;

    @Autowired
    private ReportGoodsServive reportGoodsServive;

    @Autowired
    private CommentService commentService;



    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model)
    {
        Customer loginedCustomer = SessionUtil.getLoginedCustomer();
        model.addAttribute("soldTotal",goodsService.coutSellOut());
        model.addAttribute("goodsList",goodsService.findByCustomer(loginedCustomer));
        model.addAttribute("goodscount",goodsService.cout(loginedCustomer));
        model.addAttribute("wantedGoodsList",wantedGoodsService.findAll(loginedCustomer));
        model.addAttribute("reportGoodsList",reportGoodsServive.findByCustomer(loginedCustomer));

        return "/home/customer/index";
    }

    @RequestMapping(value="/edit_pwd",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> editPwd(@RequestParam(name="oldPwd",required=true)String oldPwd,
                                   @RequestParam(name="newPwd",required=true)String newPwd) {
        Customer loginedCustomer = SessionUtil.getLoginedCustomer();
        if(!loginedCustomer.getPassword().equals(oldPwd)){
            return Result.errot(CodeMsg.EDIT_PWD_ERRROT);
        }
        loginedCustomer.setPassword(newPwd);
        if(customerService.save(loginedCustomer) == null){
            return Result.errot(CodeMsg.EDIT_PWD_ERRROT);
        }
        SessionUtil.set("CustomerL", loginedCustomer);
        return Result.success(true);

    }
    @RequestMapping(value = "edit_info",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> editIndf(Customer customer)
    {
        Customer loginedCustomer = SessionUtil.getLoginedCustomer();

        assert loginedCustomer != null;
        loginedCustomer.setAcademy(customer.getAcademy());
        loginedCustomer.setNickname(customer.getNickname());
        loginedCustomer.setGrade(customer.getGrade());
        loginedCustomer.setMobile(customer.getMobile());
        loginedCustomer.setQq(customer.getQq());
        loginedCustomer.setSchool(customer.getSchool());

        if(customerService.save(loginedCustomer) == null)
        {
            return Result.errot(CodeMsg.VALIDATE_ERROR);
        }
        operaterLogService.add("消费者日志", "修改了自己的信息:学号为【" +loginedCustomer.getId()+ "】");
        return Result.success(true);
    }

    @RequestMapping(value="/update_head_pic",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> updateHeadPic(@RequestParam(name="headPic",required=true)String headPic) {

        Customer loginedCustomer = SessionUtil.getLoginedCustomer();
        assert loginedCustomer != null;
        loginedCustomer.setHeadPic(headPic);

        if(customerService.save(loginedCustomer) == null)
        {
            return Result.errot(CodeMsg.HOME_STUDENT_ADD_HEADERPIC_ERROR);
        }

        return Result.success(true);
    }

    @RequestMapping(value = "/publish",method = RequestMethod.GET)
    public String publish()
    {
        return "home/customer/publish";
    }

    @RequestMapping(value = "/publish_wanted",method = RequestMethod.GET)
    public String publishWanted()
    {
        return "home/customer/publish_wanted";
    }

    @RequestMapping(value = "/publish_wanted",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> publishWanted(WantedGoods wantedGoods)
    {
        CodeMsg validate = ValidataUtil2.validate(wantedGoods);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode())
        {
            return Result.errot(validate);
        }

        Customer loginedCustomer = SessionUtil.getLoginedCustomer();
        wantedGoods.setCustomer(loginedCustomer);

        if(wantedGoodsService.save(wantedGoods) == null)
        {
            return Result.errot(CodeMsg.HOME_GOOD_PUSH_ADD_ERROR);
        }

        return Result.success(true);


    }

   

    @RequestMapping(value = "edit_wanted_goods",method = RequestMethod.GET)
    public String editWantedGoods(@RequestParam(name = "id",required = true)Long id, Model model)
    {

        WantedGoods byId = wantedGoodsService.findById(id);
        if(byId == null)
        {
            return "/error/404";
        }

        model.addAttribute("wantedGood",byId);

        return "/home/customer/edit_wanted";
    }

    @RequestMapping(value = "report_goods",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> reportGoods(ReportGoods reportGoods){
        CodeMsg validate = ValidataUtil2.validate(reportGoods);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode())
        {
            return Result.errot(validate);
        }

        if(reportGoods.getGoods() == null || reportGoods.getGoods().getId() == null)
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_REPORT_ERROR);
        }
        Customer loginedCustomer = SessionUtil.getLoginedCustomer();

        ReportGoods byIdAndCustomer = reportGoodsServive.findByIdAndCustomer(reportGoods.getGoods().getId(), loginedCustomer.getId());
        if(byIdAndCustomer != null)
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_REPORTED_ERROR);
        }
        reportGoods.setCustomer(loginedCustomer);

        try {
            reportGoodsServive.save(reportGoods);
        }catch (Exception e)
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_REPORT_ERROR);
        }

        return Result.success(true);
    }

    @RequestMapping(value = "edit_wanted_goods",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> editWantedGoods( WantedGoods wantedGoods)
    {
        CodeMsg validate = ValidataUtil2.validate(wantedGoods);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode())
        {
            return Result.errot(validate);
        }

        if(wantedGoods.getId() == null )
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_ERROR);
        }
        Customer loginedCustomer = SessionUtil.getLoginedCustomer();


        WantedGoods byId = wantedGoodsService.findById(wantedGoods.getId());
        if(byId == null)
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_ERROR);
        }


        assert loginedCustomer != null;
        if(!byId.getCustomer().getId().equals(loginedCustomer.getId()))
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_ERROR);
        }

        byId.setContent(wantedGoods.getContent());
        byId.setName(wantedGoods.getName());
        byId.setTradePlace(wantedGoods.getTradePlace());
        byId.setSellPrice(wantedGoods.getSellPrice());



        if(wantedGoodsService.save(byId) == null)
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_EDIT_ERROR);
        }

        return Result.success(true);
    }


    @RequestMapping(value = "/publish",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> publish(Goods goods) {

        CodeMsg validate = ValidataUtil2.validate(goods);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode())
        {
            return Result.errot(validate);
        }
        if(goods.getGoodsCategory() == null || goods.getGoodsCategory().getId() == null || goods.getGoodsCategory().getId().longValue() == -1){
            return Result.errot(CodeMsg.HOME_GOOD_PUSH_ERROR);
        }

        Customer loginedCustomer = SessionUtil.getLoginedCustomer();
        goods.setCustomer(loginedCustomer);

        if(goodsService.save(goods) == null)
        {
            return Result.errot(CodeMsg.HOME_GOOD_PUSH_ADD_ERROR);
        }

        return Result.success(true);
    }

    @RequestMapping(value = "edit_goods",method = RequestMethod.GET)
    public String editGoods(@RequestParam(name = "id",required = true)Long id,Model model)
    {
        Customer loginedCustomer = SessionUtil.getLoginedCustomer();

        assert loginedCustomer != null;
        Goods goods = goodsService.find(id, loginedCustomer.getId());

        if(goods == null)
        {
            return "/error/404";
        }
        model.addAttribute("goods",goods);


        return "/home/customer/edit_goods";
    }


    @RequestMapping(value = "/edit_goods",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> editGoods(Goods goods) {

        CodeMsg validate = ValidataUtil2.validate(goods);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode())
        {
            return Result.errot(validate);
        }
        if(goods.getGoodsCategory() == null || goods.getGoodsCategory().getId() == null || goods.getGoodsCategory().getId() == -1){
            return Result.errot(CodeMsg.HOME_GOOD_PUSH_EDIT_ADD_ERROR);
        }

        
        Customer loginedCustomer = SessionUtil.getLoginedCustomer();

        Goods exitGoods = goodsService.find(goods.getId(), loginedCustomer.getId());
        if(exitGoods == null)
        {
            return Result.errot(CodeMsg.HOME_GOOD_PUSH_EDIT_ERROR);
        }

        exitGoods.setContent(goods.getContent());
        exitGoods.setName(goods.getName());
        exitGoods.setBuyPrice(goods.getBuyPrice());
        exitGoods.setSellPrice(goods.getSellPrice());
        exitGoods.setPhoto(goods.getPhoto());
        exitGoods.setGoodsCategory(goods.getGoodsCategory());
        exitGoods.setUpdateTime(new Date());


        if(goodsService.save(exitGoods) == null)
        {
            return Result.errot(CodeMsg.HOME_GOOD_PUSH_ADD_ERROR);
        }


        return Result.success(true);
    }


    @RequestMapping(value = "/update_flag",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> updateFlag(
            @RequestParam(name = "id",required = true) Long id,
            @RequestParam(name = "flag",required = true)Integer flag
    ) {

        Customer loginedCustomer = SessionUtil.getLoginedCustomer();
        Goods goods = goodsService.find(id, loginedCustomer.getId());
        goods.setFlag(flag);
        if(goodsService.save(goods) == null)
        {
            return Result.errot(CodeMsg.HOME_GOOD_PUSH_ADD_ERROR);
        }

        return Result.success(true);
    }

    @RequestMapping(value = "/delete_wanted",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> deleteWanted(
            @RequestParam(name = "id",required = true) Long id
    ) {
        WantedGoods byId = wantedGoodsService.findById(id);
        if(byId == null)
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_DELETE_ERROR);
        }
        Customer loginedCustomer = SessionUtil.getLoginedCustomer();
        assert loginedCustomer != null;
        if(!byId.getCustomer().getId().equals(loginedCustomer.getId()))
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_DELETE_ERROR);
        }
        try {
            wantedGoodsService.deleteById(id);
        }catch (Exception e)
        {
            e.printStackTrace();
            return Result.errot(CodeMsg.WANGTED_GOOD_DELETE_ERROR);

        }

        return Result.success(true);
    }

    @RequestMapping(value = "/delete_report",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> deleteReport(
            @RequestParam(name = "id",required = true) Long id
    ) {
        ReportGoods byId = reportGoodsServive.findById(id);
        if(byId == null)
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_DELETE_ERROR);
        }
        Customer loginedCustomer = SessionUtil.getLoginedCustomer();
        assert loginedCustomer != null;
        if(!byId.getCustomer().getId().equals(loginedCustomer.getId()))
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_REPORTED_DELETE_ERROR);
        }
        try {
            reportGoodsServive.deleteById(id);
        }catch (Exception e)
        {
            e.printStackTrace();
            return Result.errot(CodeMsg.WANGTED_GOOD_REPORTED_DELETE_ERROR);

        }

        return Result.success(true);
    }


    @RequestMapping(value = "/update_status",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> updateStatus(
            @RequestParam(name = "id",required = true) Long id,
            @RequestParam(name = "status",required = true) Integer status
    ) {

        Customer loginedCustomer = SessionUtil.getLoginedCustomer();
        Goods goods = goodsService.find(id, loginedCustomer.getId());
        goods.setStatus(status);
        if(goodsService.save(goods) == null)
        {
            return Result.errot(CodeMsg.HOME_GOOD_PUSH_ADD_ERROR);
        }

        return Result.success(true);
    }

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> comment(Comment comment){
        CodeMsg validate = ValidataUtil2.validate(comment);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode())
        {
            return Result.errot(validate);
        }

        if(comment.getGoods() == null || comment.getGoods().getId() == null)
        {
            System.out.println("-----------------1");
            return Result.errot(CodeMsg.WANGTED_GOOD_COMMENT_ERROR);
        }

        Customer loginedCustomer = SessionUtil.getLoginedCustomer();

        Goods byId = goodsService.findById(comment.getGoods().getId());
        if(byId == null)
        {
            System.out.println("-----------------2");
            return Result.errot(CodeMsg.WANGTED_GOOD_COMMENT_ERROR);
        }
        comment.setCustomer(loginedCustomer);

        try {
            commentService.save(comment);
        }catch (Exception e)
        {
            return Result.errot(CodeMsg.WANGTED_GOOD_COMMENT_ADD_ERROR);
        }

        return Result.success(true);
    }



}
