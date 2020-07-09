package com.orange.admin.dao.home;

import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.WantedGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 高晨
 */
@Repository
public interface WantedGoodsDao extends JpaRepository<WantedGoods,Long> {

    List<WantedGoods> findByCustomer(Customer customer);
    List<WantedGoods> findByCustomerAndId(Customer customer,Long id);

    Integer countByCustomer(Customer customer);



}
