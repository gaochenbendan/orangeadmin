package com.orange.admin.dao.admin;

import com.orange.admin.pojo.common.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 高晨
 */
@Repository
public interface GoodsCategoryDao extends JpaRepository<GoodsCategory, Long> {

    List<GoodsCategory> findByParentIsNull();

    List<GoodsCategory> findByParent(GoodsCategory parent);

    List<GoodsCategory> findByName(String name);



}
