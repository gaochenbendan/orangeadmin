package com.orange.admin.Interceptor.home;

import com.orange.admin.commons.utils.StringUtil;
import com.orange.admin.pojo.common.SiteSetting;
import com.orange.admin.service.adminservice.GoodsCategoryService;
import com.orange.admin.service.adminservice.SiteSettingService;
import com.orange.admin.service.homeservice.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前台全局拦截器
 *
 * @author 高晨
 */
@Component
public class HomeGlobeInterceptor implements HandlerInterceptor {

    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Autowired
    private FriendLinkService friendLinkService;

    @Autowired
    private SiteSettingService siteSettingService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        StringBuffer requestURL = request.getRequestURL();


        if(!StringUtil.isAjax(request)){
            //若不是ajax请求，则将菜单信息放入页面模板变量
            request.setAttribute("goodsCategorys",goodsCategoryService.findAll());
            request.setAttribute("frindLinkList",friendLinkService.findALL());
            SiteSetting byId = siteSettingService.findById(1L);
            if(byId!=null)
            {
                request.setAttribute("sitename2",byId.getSiteName());
                request.setAttribute("log1",byId.getLogo1());
                request.setAttribute("log2",byId.getLogo2());
                request.setAttribute("weixin",byId.getQrcode());
                request.setAttribute("right",byId.getAllRights());
            }

        }



        return true;
    }
}
