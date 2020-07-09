package com.orange.admin.service.homeservice.Impl;

import com.orange.admin.dao.home.ReportGoodsDao;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.ReportGoods;
import com.orange.admin.service.homeservice.ReportGoodsServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高晨
 */
@Service
public class ReportGoodsServiveImpl implements ReportGoodsServive {

    @Autowired
    private ReportGoodsDao reportGoodsDao;

    @Override
    public void save(ReportGoods reportGoods) {
        reportGoodsDao.save(reportGoods);
    }

    @Override
    public List<ReportGoods> findByCustomer(Customer customer) {
        return reportGoodsDao.findByCustomer(customer);
    }

    @Override
    public ReportGoods findByIdAndCustomer(Long id, Long customerId) {
        return reportGoodsDao.findByGoods_IdAndCustomer_Id(id,customerId);
    }

    @Override
    public void deleteById(Long id) {
        reportGoodsDao.deleteById(id);
    }

    @Override
    public Integer countByCustomer(Customer customer) {
        return reportGoodsDao.countByCustomer(customer);
    }

    @Override
    public ReportGoods findById(Long id) {
        return reportGoodsDao.findById(id).orElse(null);
    }
}
