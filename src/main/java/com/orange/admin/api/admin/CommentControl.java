package com.orange.admin.api.admin;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.admin.bo.Result;
import com.orange.admin.pojo.common.Comment;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
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
@RequestMapping("/admin/comment/")
public class CommentControl {

    @Autowired
    private GoodsService goodsService;



    @Autowired
    private CustomerService customerService;

    @Autowired
    private CommentService commentService;



    @RequestMapping("/list")
    public String list(Model model, PageUtil<Comment> pageUtil, Comment comment
    ) {
        if(comment.getCustomer() != null && comment.getCustomer().getSn() != null){
            Customer bySn = customerService.findBySn(comment.getCustomer().getSn());
            if(bySn != null){
                comment.setCustomer(bySn);
            }
        }
        List<Goods> goodsList = null;
        if(comment.getGoods() != null && comment.getGoods().getName() != null){
            goodsList = goodsService.findByName(comment.getGoods().getName());
        }

        model.addAttribute("title", "评论管理");
        model.addAttribute("content", comment.getContent());
        model.addAttribute("name", comment.getGoods() == null ? null : comment.getGoods().getName());
        model.addAttribute("sn", comment.getCustomer() == null ? null : comment.getCustomer().getSn());
        PageUtil<Comment> findlist = commentService.findlist(pageUtil, comment, goodsList);

        model.addAttribute("pageBean", findlist);
        return "admin/comment/list";
    }
    @RequestMapping(value="/delete",method= RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name="id",required=true)Long id){
        try {
            commentService.deleteById(id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return Result.success(true);
    }


}
