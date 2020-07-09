package com.orange.admin.api.home;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.common.WantedGoods;
import com.orange.admin.service.homeservice.WantedGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home/wangted_goods")
public class WantedGoodsController {

    @Autowired
    private WantedGoodsService wantedGoodsService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model, PageUtil<WantedGoods> pageUtil,WantedGoods wantedGoods)
    {

        model.addAttribute("pageBean",wantedGoodsService.findList(pageUtil,wantedGoods));

        return "/home/wanted_goods/list";
    }


}
