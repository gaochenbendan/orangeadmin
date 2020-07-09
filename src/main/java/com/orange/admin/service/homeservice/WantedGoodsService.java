package com.orange.admin.service.homeservice;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.WantedGoods;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高晨
 */
@Service
public interface WantedGoodsService {

    WantedGoods save(WantedGoods wantedGoods);

    List<WantedGoods> findAll(Customer customer);

    WantedGoods findById(Long id);

    void deleteById(Long id);

    public PageUtil<WantedGoods> findList(PageUtil<WantedGoods> pageUtil, WantedGoods wantedGoods);

    public PageUtil<WantedGoods> findWantedGoodslist(PageUtil<WantedGoods> pageBean,WantedGoods wantedGoods);




    }
