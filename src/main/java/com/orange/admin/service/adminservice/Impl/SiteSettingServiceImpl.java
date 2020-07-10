package com.orange.admin.service.adminservice.Impl;

import com.orange.admin.dao.admin.SiteSettingDao;
import com.orange.admin.pojo.common.SiteSetting;
import com.orange.admin.service.adminservice.SiteSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteSettingServiceImpl implements SiteSettingService {

    @Autowired
    private SiteSettingDao siteSettingDao;


    @Override
    public SiteSetting save(SiteSetting siteSetting) {
        return siteSettingDao.save(siteSetting);
    }

    @Override
    public SiteSetting findById(Long id) {
        return siteSettingDao.findById(id).orElse(null);
    }
}
