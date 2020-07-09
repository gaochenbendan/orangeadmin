package com.orange.admin.api.admin;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.admin.bo.Result;
import com.orange.admin.pojo.admin.sc.CodeMsg;
import com.orange.admin.pojo.common.Comment;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.pojo.common.GoodsCategory;
import com.orange.admin.service.adminservice.GoodsCategoryService;
import com.orange.admin.service.adminservice.OperaterLogService;
import com.orange.admin.service.homeservice.CommentService;
import com.orange.admin.service.homeservice.CustomerService;
import com.orange.admin.service.homeservice.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/goods/")
public class AdminGoodsControl {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private OperaterLogService operaterLogService;
    @RequestMapping("/list")
    public String list(Model model, PageUtil<Goods> pageUtil, Goods goods
    ) {
        if(goods.getCustomer() != null && goods.getCustomer().getSn() != null){
            Customer bySn = customerService.findBySn(goods.getCustomer().getSn());
            if(bySn != null){
                goods.setCustomer(bySn);
            }
        }
        if(goods.getGoodsCategory() != null && goods.getGoodsCategory().getName() != null){
            List<GoodsCategory> goodsCategorys = goodsCategoryService.findByName(goods.getGoodsCategory().getName());
            if(goodsCategorys != null && goodsCategorys.size() > 0){
                goods.setGoodsCategory(goodsCategorys.get(0));
            }
        }


        goods.setStatus(-1);
        model.addAttribute("title", "商品管理");
        model.addAttribute("name", goods.getName());
        PageUtil<Goods> list = goodsService.findlist(pageUtil, goods);
        model.addAttribute("goodsCategoryName", goods.getGoodsCategory() == null ? null : goods.getGoodsCategory().getName());
        model.addAttribute("pageBean",list);
        model.addAttribute("sn", goods.getCustomer() == null ? null : goods.getCustomer().getSn());
        return "/admin/goods/list";

    }

    @RequestMapping("/up_down")
    @ResponseBody
    public Result<Boolean> upDown(@RequestParam(name = "id",required = true)Long id,
                                   @RequestParam(name = "status",required = true)Integer status)
    {

        Goods byId = goodsService.findById(id);
        if(byId == null)
        {
            return Result.errot(CodeMsg.GOOD_UPDOWN_ERROR);
        }

        if(byId.getStatus() != Goods.GOODS_STATUS_UP && byId.getStatus() != Goods.GOODS_STATUS_DOWN && byId.getStatus() != Goods.GOODS_STATUS_SOLD )
        {
            return Result.errot(CodeMsg.GOOD_UPDOWN_ERROR);
        }
        if(byId.getStatus() == status)
        {
            return Result.errot(CodeMsg.GOOD_UPDOWN_ERROR2);
        }
            byId.setStatus(status);
        if(goodsService.save(byId) == null)
        {
            return Result.errot(CodeMsg.GOOD_UPDOWN_ERROR);
        }


        return Result.success(true);
    }
    @RequestMapping("/recommend")
    @ResponseBody
    public Result<Boolean> recommend(@RequestParam(name = "id",required = true)Long id,
                                  @RequestParam(name = "recommend",required = true)Integer recommend)
    {
        Goods goods = goodsService.findById(id);
        if(goods == null){
            return Result.errot(CodeMsg.GOOD_RECOMMEND_ERROR);
        }
        if(goods.getRecommend() == recommend){
            return Result.errot(CodeMsg.GOOD_RECOMMEND_ERROR2);
        }
        if(recommend != Goods.GOODS_RECOMMEND_OFF && recommend != Goods.GOODS_RECOMMEND_ON){
            return Result.errot(CodeMsg.GOOD_RECOMMEND_ERROR);
        }
        if(goods.getStatus() == Goods.GOODS_STATUS_SOLD){
            return Result.errot(CodeMsg.GOOD_RECOMMEND_ERROR);
        }
        goods.setRecommend(recommend);;
        //进行更新数据库
        if(goodsService.save(goods) ==null){
            return Result.errot(CodeMsg.GOOD_RECOMMEND_ERROR);
        }
        return Result.success(true);

    }
    @RequestMapping(value="/delete",method= RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name="id",required=true)Long id){

        List<Comment> all = commentService.findBALL();
        Goods byId = goodsService.findById(id);
        for (Comment comment : all) {
            if(byId.getId().equals(comment.getGoods().getId()))
            {
                try {
                    commentService.deleteById(comment.getId());
                }catch (Exception e)
                {
                    return Result.errot(CodeMsg.GOOD_DELETE_ERROR2);
                }
            }

        }


        try {
            goodsService.deleteById(id);
        } catch (Exception e) {
            return Result.errot(CodeMsg.GOOD_DELETE_ERROR);
        }
        return Result.success(true);
    }


}
