package com.orange.admin.service.adminservice;

import com.orange.admin.pojo.common.SiteSetting;
import org.springframework.stereotype.Service;

@Service
public interface SiteSettingService {

    SiteSetting save(SiteSetting siteSetting);

    SiteSetting findById(Long id);


}
