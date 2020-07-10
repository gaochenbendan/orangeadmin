package com.orange.admin.api.admin;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.commons.utils.ValidataUtil2;
import com.orange.admin.pojo.admin.bo.Result;
import com.orange.admin.pojo.admin.sc.CodeMsg;
import com.orange.admin.pojo.common.FriendLink;
import com.orange.admin.service.homeservice.FriendLinkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 高晨
 */
@RequestMapping("/admin/friend_link")
@Controller
public class FriendLinkController {


    @Autowired
    private FriendLinkService friendLinkService;


    @RequestMapping(value="/list")
    public String list(Model model, FriendLink friendLink, PageUtil<FriendLink> pageBean){
        model.addAttribute("title", "友情链接列表");
        model.addAttribute("name", friendLink.getName());
        model.addAttribute("pageBean", friendLinkService.findList(pageBean,friendLink));
        return "admin/friend_link/list";
    }

    @RequestMapping(value="/add",method= RequestMethod.GET)
    public String add(Model model){
        return "admin/friend_link/add";
    }

    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> add(FriendLink friendLink){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidataUtil2.validate(friendLink);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.errot(validate);
        }
        //到这说明一切符合条件，进行数据库新增
        if(friendLinkService.save(friendLink) == null){
            return Result.errot(CodeMsg.FRIENDLINK_ADD_ERROR);
        }

        return Result.success(true);
    }

    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public String edit(Model model,@RequestParam(name="id",required=true)Long id){
        model.addAttribute("friendLink", friendLinkService.findById(id));
        return "admin/friend_link/edit";
    }

    @RequestMapping(value="/edit",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> edit(FriendLink friendLink){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidataUtil2.validate(friendLink);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.errot(validate);
        }
        //到这说明一切符合条件，进行数据库保存
        FriendLink findById = friendLinkService.findById(friendLink.getId());
        //讲提交的友情链接信息指定字段复制到已存在的user对象中,该方法会覆盖新字段内容
        BeanUtils.copyProperties(friendLink, findById, "id","createTime","updateTime");
        if(friendLinkService.save(findById) == null){
            return Result.errot(CodeMsg.FRIENDLINK_EDIT_ERROR);
        }

        return Result.success(true);
    }

    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam(name="ids",required=true)String ids){
        String[] split = ids.split(",");
        for(String id : split){
            friendLinkService.deleteById(Long.valueOf(id));
        }
        return Result.success(true);
    }

}
