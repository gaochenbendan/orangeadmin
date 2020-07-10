package com.orange.admin.service.homeservice.Impl;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.dao.admin.FriendLinkDao;
import com.orange.admin.pojo.common.FriendLink;
import com.orange.admin.service.homeservice.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendLinkServiceImpl implements FriendLinkService {

    @Autowired
    private FriendLinkDao friendLinkDao;

    @Override
    public FriendLink findById(Long id) {
        return friendLinkDao.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        friendLinkDao.deleteById(id);
    }

    @Override
    public FriendLink save(FriendLink friendLink) {
        return friendLinkDao.save(friendLink);
    }

    @Override
    public PageUtil<FriendLink> findList(PageUtil<FriendLink> pageBean, FriendLink friendLink) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        exampleMatcher = exampleMatcher.withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        exampleMatcher = exampleMatcher.withIgnorePaths("sort");
        Example<FriendLink> example = Example.of(friendLink, exampleMatcher);
        Sort sort = Sort.by(Sort.Direction.ASC, "sort");
        PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
        Page<FriendLink> findAll = friendLinkDao.findAll(example, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }

    @Override
    public List<FriendLink> findALL() {
        return friendLinkDao.findAll();
    }
}
