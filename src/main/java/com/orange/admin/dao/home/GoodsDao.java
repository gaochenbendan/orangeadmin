package com.orange.admin.dao.home;

import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 高晨
 */
@Repository
public interface GoodsDao extends JpaRepository<Goods, Long>, JpaSpecificationExecutor<Goods> {

    @Query(value = "select * from goods u where u.customer_id = ?1 order by u.create_time desc ",nativeQuery = true)
    List<Goods> findByCustome(Long id);

    Goods findByIdAndCustomer_Id(Long id, Long customerId);

    Integer countByCustomerAndStatus(Customer customer, Integer statue);

    Integer countByCustomer(Customer customer);

    @Query(value="SELECT * from goods where goods_category_id IN :cids and `status` = 1 ORDER BY create_time desc,flag desc,recommend desc limit :offset,:pageSize",nativeQuery=true)
    List<Goods> findList(@Param("cids")List<Long> cids, @Param("offset")Integer offset, @Param("pageSize")Integer pageSize);

    Integer countByStatus(Integer status);

    @Query(value="SELECT count(*) from goods where goods_category_id IN :cids and `status` = 1 ",nativeQuery=true)
    Long getTotalCount(@Param("cids")List<Long> cids);


    int countByStatus(int status);

    List<Goods> findByName(String name);


}
