package com.orange.admin.dao.home;

import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.pojo.common.ReportGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 高晨
 */
@Repository
public interface ReportGoodsDao extends JpaRepository<ReportGoods,Long>, JpaSpecificationExecutor<ReportGoods> {

    List<ReportGoods> findByCustomer(Customer customer);

    List<ReportGoods> findByGoods(Goods goods);

    ReportGoods findByIdAndCustomer_Id(Long id,Long customerId);

    ReportGoods findByGoods_IdAndCustomer_Id(Long id,Long customerId);

    Integer countByCustomer(Customer customer);

}
