package com.orange.admin.service.adminservice;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.common.News;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高晨
 */
@Service
public interface NewsService {

    News save(News news);

    News findById(Long id);

    PageUtil<News> findList(PageUtil<News> pageBean, News news);

    void delete(Long id);

    List<News> findList(int size);

}
