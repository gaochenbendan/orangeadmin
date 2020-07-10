package com.orange.admin.api.admin;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.admin.bo.Result;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.pojo.common.ReportGoods;
import com.orange.admin.service.homeservice.CommentService;
import com.orange.admin.service.homeservice.CustomerService;
import com.orange.admin.service.homeservice.GoodsService;
import com.orange.admin.service.homeservice.ReportGoodsServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 高晨
 */
@Controller
@RequestMapping("/admin/reporter/")
public class ReporterControl {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ReportGoodsServive reportGoodsServive;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CommentService commentService;



    @RequestMapping("/list")
    public String list(Model model, PageUtil<ReportGoods> pageUtil, ReportGoods reportGoods
    ) {
        if(reportGoods.getCustomer() != null && reportGoods.getCustomer().getSn() != null){
            Customer bySn = customerService.findBySn(reportGoods.getCustomer().getSn());
            if(bySn != null){
                reportGoods .setCustomer(bySn);
            }
        }
        List<Goods> goodsList = null;
        if(reportGoods.getGoods() != null && reportGoods.getGoods().getName() != null){
            goodsList = goodsService.findByName(reportGoods.getGoods().getName());
        }

        model.addAttribute("title", "举报管理");
        model.addAttribute("content", reportGoods.getContent());
        model.addAttribute("name", reportGoods.getGoods() == null ? null : reportGoods.getGoods().getName());
        model.addAttribute("sn", reportGoods.getCustomer() == null ? null : reportGoods.getCustomer().getSn());
        PageUtil<ReportGoods> findlist = reportGoodsServive.findlist(pageUtil, reportGoods, goodsList);

        model.addAttribute("pageBean", findlist);
        return "admin/reporter/list";
    }
    @RequestMapping(value="/delete",method= RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name="id",required=true)Long id){
        try {
            reportGoodsServive.deleteById(id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return Result.success(true);
    }


}
