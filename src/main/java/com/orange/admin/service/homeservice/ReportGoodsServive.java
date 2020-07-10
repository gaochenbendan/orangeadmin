package com.orange.admin.service.homeservice;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.pojo.common.ReportGoods;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高晨
 */
@Service
public interface ReportGoodsServive {

    public void save(ReportGoods reportGoods);

    public List<ReportGoods> findByCustomer(Customer customer);

    public ReportGoods findByIdAndCustomer(Long id,Long customerId);

    public void deleteById(Long id);

    public Integer countByCustomer(Customer customer);

    public ReportGoods findById(Long id);

    public PageUtil<ReportGoods> findlist(PageUtil<ReportGoods> pageBean, ReportGoods reportGoods, List<Goods> goodsList);

    }
