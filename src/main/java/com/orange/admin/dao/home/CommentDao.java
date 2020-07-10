package com.orange.admin.dao.home;

import com.orange.admin.pojo.common.Comment;
import com.orange.admin.pojo.common.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 高晨
 */
@Repository
public interface CommentDao extends JpaRepository<Comment,Long>, JpaSpecificationExecutor<Comment> {

    Comment findByGoods_IdAndCustomer_Id(Long goodsId,Long customerId);

    List<Comment> findByGoods(Goods goods);



}
