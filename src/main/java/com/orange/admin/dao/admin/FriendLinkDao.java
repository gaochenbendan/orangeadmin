package com.orange.admin.dao.admin;

import com.orange.admin.pojo.common.FriendLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendLinkDao extends JpaRepository<FriendLink,Long> {
}
