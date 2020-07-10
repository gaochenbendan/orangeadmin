package com.orange.admin.dao.admin;

import com.orange.admin.pojo.common.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDao extends JpaRepository<News,Long> {
}
