package com.orange.admin.api.admin;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.commons.utils.ValidataUtil2;
import com.orange.admin.pojo.admin.UserMessage;
import com.orange.admin.pojo.admin.bo.Result;
import com.orange.admin.pojo.admin.sc.CodeMsg;
import com.orange.admin.pojo.common.News;
import com.orange.admin.service.adminservice.NewsService;
import com.orange.admin.service.adminservice.OperaterLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理控制器
 */
@Controller
@RequestMapping("/admin/news")
public class NewsControl {


    @Autowired
    private NewsService newsService;

    @Autowired
    private OperaterLogService operaterLogService;

    @RequestMapping(value = "/list")
    public String list(Model model, News news, PageUtil<News> pageBean) {

        model.addAttribute("title", "新闻公告列表");
        model.addAttribute("newsTitle", news.getTitle());
        System.out.println("========================");
        model.addAttribute("pageBean",newsService.findList(pageBean,news));

        return "admin/news/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        return "admin/news/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(HttpServletRequest request,News news) {

        CodeMsg validate = ValidataUtil2.validate(news);
        if (validate.getCode() != CodeMsg.getSUCCESS().getCode()) {
            return Result.errot(validate);
        }

        try {
            newsService.save(news);
        } catch (Exception e) {
            return Result.errot(CodeMsg.NEWS_ADD_ERROR);
        }
        UserMessage user1 = (UserMessage) request.getSession().getAttribute("user");
        operaterLogService.add(user1.getUserName(), "新增新闻信息:ID-》【" + news.getId() + "】");
        return Result.success(true);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model, @RequestParam(required = true, name = "id") Long id) {

        model.addAttribute("news", newsService.findById(id));

        return "admin/news/edit";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(News news, HttpServletRequest request) {
//        验证
        CodeMsg validate = ValidataUtil2.validate(news);
        if (validate.getCode() != CodeMsg.getSUCCESS().getCode()) {
            return Result.errot(validate);
        }

        News byId = newsService.findById(news.getId());

        BeanUtils.copyProperties(news, byId, "id","createTime");

        try {

            newsService.save(byId);
            UserMessage user1 = (UserMessage) request.getSession().getAttribute("user");
            operaterLogService.add(user1.getUserName(), "编辑新闻信息:ID-》【" + byId.getId() + "】");
        } catch (Exception e) {
            return Result.errot(CodeMsg.NEWS_EDIT_ERROR);
        }


        return Result.success(true);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(HttpServletRequest request, @RequestParam(name = "id", required = true) Long id) {

        try {
            newsService.delete(id);
        } catch (Exception e) {
            return Result.errot(CodeMsg.NEWS_DELETE_ERROR);
        }
        UserMessage user1 = (UserMessage) request.getSession().getAttribute("user");
        operaterLogService.add(user1.getUserName(), "删除新闻信息:ID-》【" + id + "】");

        return Result.success(true);
    }


}
