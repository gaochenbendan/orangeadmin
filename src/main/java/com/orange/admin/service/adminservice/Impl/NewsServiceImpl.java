package com.orange.admin.service.adminservice.Impl;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.dao.admin.NewsDao;
import com.orange.admin.pojo.common.News;
import com.orange.admin.service.adminservice.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;


    @Override
    public News save(News news) {
        return newsDao.save(news);
    }

    @Override
    public News findById(Long id) {
        return newsDao.findById(id).orElse(null);
    }

    @Override
    public PageUtil<News> findList(PageUtil<News> pageBean, News news) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        exampleMatcher = exampleMatcher.withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains());
        exampleMatcher = exampleMatcher.withIgnorePaths("sort","viewNumber");
        Example<News> example = Example.of(news, exampleMatcher);
        Sort sort = Sort.by(Sort.Direction.ASC, "sort");
        PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
        Page<News> findAll = newsDao.findAll(example, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }

    @Override
    public void delete(Long id) {
        newsDao.deleteById(id);
    }

    @Override
    public List<News> findList(int size) {
        News news = new News();
        PageUtil<News> pageBean = new PageUtil<News>();
        pageBean.setPageSize(size);
        return findList(pageBean, news).getContent();
    }
}
