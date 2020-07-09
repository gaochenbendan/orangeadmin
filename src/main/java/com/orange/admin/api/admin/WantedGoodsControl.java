package com.orange.admin.api.admin;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.admin.bo.Result;
import com.orange.admin.pojo.admin.sc.CodeMsg;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.WantedGoods;
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

@Controller
@RequestMapping("/admin/wanted_goods")
public class WantedGoodsControl {

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
    public String list(Model model, PageUtil<WantedGoods> pageUtil, WantedGoods wantedGoods
    ) {
        if(wantedGoods.getCustomer() != null && wantedGoods.getCustomer().getSn() != null){
            Customer customer = customerService.findBySn(wantedGoods.getCustomer().getSn());
            if(customer != null){
                wantedGoods.setCustomer(customer);
            }
        }
        model.addAttribute("title", "求购物品列表");
        model.addAttribute("name", wantedGoods.getName());
        model.addAttribute("sn", wantedGoods.getCustomer() == null ? null : wantedGoods.getCustomer().getSn());
        model.addAttribute("pageBean", wantedGoodsService.findWantedGoodslist(pageUtil, wantedGoods));
        return "admin/wanted_goods/list";

    }


    @RequestMapping(value="/delete",method= RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name="id",required=true)Long id){


        try {
            wantedGoodsService.deleteById(id);
        } catch (Exception e) {
            return Result.errot(CodeMsg.GOOD_DELETE_ERROR);
        }
        return Result.success(true);
    }


}
