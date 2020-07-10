package com.orange.admin.api.admin;

import com.orange.admin.commons.utils.ValidataUtil2;
import com.orange.admin.pojo.admin.bo.Result;
import com.orange.admin.pojo.admin.sc.CodeMsg;
import com.orange.admin.pojo.common.SiteSetting;
import com.orange.admin.service.adminservice.OperaterLogService;
import com.orange.admin.service.adminservice.SiteSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin/site_setting")
@Controller
public class SiteSettingController {

    @Autowired
    private SiteSettingService siteSettingService;
    @Autowired
    private OperaterLogService operaterLogService;

    @RequestMapping(value="/setting",method= RequestMethod.GET)
    public String setting(Model model){
        model.addAttribute("siteSetting", siteSettingService.findById(1L));
        return "admin/site_setting/setting";
    }

    @RequestMapping(value="/save_setting",method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> setting(SiteSetting siteSetting){
        //用统一验证实体方法验证是否合法
        CodeMsg validate = ValidataUtil2.validate(siteSetting);
        if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
            return Result.errot(validate);
        }
        //到这说明一切符合条件，进行数据库新增
        //判断是否是首次提交
        if(siteSetting.getId() != null){
            //表示不是首次提交
            SiteSetting find = siteSettingService.findById(1L);
            siteSetting.setCreateTime(find.getCreateTime());
        }
        if(siteSettingService.save(siteSetting) == null){
            return Result.errot(CodeMsg.ADMIN_SITESETTING_EDIT_ERROR);
        }

        return Result.success(true);
    }



}
