package com.orange.admin.dao.admin;

import com.orange.admin.pojo.common.SiteSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteSettingDao extends JpaRepository<SiteSetting, Long> {
}
