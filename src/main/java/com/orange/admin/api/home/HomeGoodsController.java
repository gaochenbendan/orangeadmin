package com.orange.admin.api.home;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.pojo.common.GoodsCategory;
import com.orange.admin.service.adminservice.GoodsCategoryService;
import com.orange.admin.service.homeservice.CommentService;
import com.orange.admin.service.homeservice.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * 前台管理控制器
 *
 * @author 高晨
 */
@RequestMapping("/home/goods")
@Controller
public class HomeGoodsController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CommentService commentService;


    @RequestMapping(value="/detail")
    public String detail(@RequestParam(name="id",required=true)Long id, Model model){
        Goods goods = goodsService.findById(id);
        if(goods == null){
            model.addAttribute("msg", "物品不存在！");
            return "error/404";
        }
        model.addAttribute("goods", goods);
        model.addAttribute("soldTotal",goodsService.coutSellOut());
        model.addAttribute("commentList",commentService.findByGoods(goods));
        //更新商品浏览量
        goods.setViewNumber(goods.getViewNumber() + 1);
        goodsService.save(goods);
        return "home/goods/detail";
    }


    @RequestMapping("/list")
    public String list(@RequestParam(name = "cid",required = true)Long cid, Model model, PageUtil<Goods> pageUtil) {
        GoodsCategory goodsCategory = goodsCategoryService.finfById(cid);
        if(goodsCategory == null)
        {
            model.addAttribute("msg","物品分类不存在");
            return "error/404";
        }

        ArrayList<Long> ids = new ArrayList<>();
        ids.add(goodsCategory.getId());
        if(goodsCategory.getParent() == null)
        {
            List<GoodsCategory> children = goodsCategoryService.findChilren(goodsCategory);
            for (GoodsCategory child : children) {
                ids.add(child.getId());
            }

        }

        model.addAttribute("goodsList",goodsService.findList(pageUtil,ids));
        model.addAttribute("gc",goodsCategory);


        return "home/goods/list";

    }

}
