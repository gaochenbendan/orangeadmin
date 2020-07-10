package com.orange.admin.service.homeservice;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.common.FriendLink;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendLinkService {

    FriendLink findById(Long id);

    void  deleteById(Long id);

    FriendLink save(FriendLink friendLink);

    PageUtil<FriendLink> findList(PageUtil<FriendLink> pageBean, FriendLink friendLink);

    List<FriendLink> findALL();

    }
