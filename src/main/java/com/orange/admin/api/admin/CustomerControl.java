package com.orange.admin.api.admin;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.admin.bo.Result;
import com.orange.admin.pojo.admin.sc.CodeMsg;
import com.orange.admin.pojo.common.Comment;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.service.adminservice.OperaterLogService;
import com.orange.admin.service.homeservice.CommentService;
import com.orange.admin.service.homeservice.CustomerService;
import com.orange.admin.service.homeservice.GoodsService;
import com.orange.admin.service.homeservice.WantedGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/customer")
public class CustomerControl {

    @Autowired
    private GoodsService goodsService;


    @Autowired
    private CustomerService customerService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private WantedGoodsService wantedGoodsService;

    @Autowired
    private OperaterLogService operaterLogService;

    @RequestMapping("/list")
    public String list(Model model, PageUtil<Customer> pageUtil, Customer customer
    ) {

        model.addAttribute("title", "学生列表");
        model.addAttribute("sn", customer.getSn());
        model.addAttribute("pageBean", customerService.findlist(pageUtil, customer));
        return "admin/customer/list";

    }


    @RequestMapping(value="/delete",method= RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name="id",required=true)Long id){

        Customer byId = customerService.findById(id);

        List<Comment> all2 = commentService.findBALL();
        for (Comment comment : all2) {
            if(comment.getCustomer().getId().equals(byId.getId()))
            {
                commentService.deleteById(comment.getId());
            }
        }

        List<Goods> all = goodsService.findAll();
        for (Goods goods : all) {
            if(goods.getCustomer().getId().equals(byId.getId()))
            {
                goodsService.deleteById(goods.getId());
            }
        }

        try {
            customerService.deleteById(id);
        } catch (Exception e) {
            return Result.errot(CodeMsg.GOOD_DELETE_ERROR);
        }
        return Result.success(true);
    }

    @RequestMapping(value="/update_status",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> upDown(@RequestParam(name="id",required=true)Long id ,@RequestParam(name="status",required=true)Integer status){
        Customer customer = customerService.findById(id);
        if(customer == null){
            return Result.errot(CodeMsg.ADMIN_FREEDZE_HEADERPIC_ERROR);
        }
        if(customer.getStatus() == status){
            return Result.errot(CodeMsg.ADMIN_FREEDZE_HEADERPIC_ERROR2);
        }
        if(status != Customer.STUDENT_STATUS_ENABLE && status != Customer.STUDENT_STATUS_UNABLE){
            return Result.errot(CodeMsg.ADMIN_FREEDZE_HEADERPIC_ERROR);
        }
        customer.setStatus(status);
        //进行更新数据库
        if(customerService.save(customer) ==null){
            return Result.errot(CodeMsg.ADMIN_FREEDZE_HEADERPIC_ERROR);
        }
        return Result.success(true);
    }


}
