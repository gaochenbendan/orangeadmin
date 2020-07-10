package com.orange.admin.service.homeservice;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.pojo.common.bo.GoodsCount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {

    Goods save(Goods goods);

    PageUtil<Goods> findList(PageUtil<Goods> pageUtil ,Goods goods);

    PageUtil<Goods> findList(PageUtil<Goods> pageUtil,List<Long> cid);

    List<Goods> findByCustomer(Customer customer);

    Goods find(Long id,Long customerId);

    GoodsCount cout(Customer customer);

    Goods findById(Long id);

    int coutSellOut();

    PageUtil<Goods> findlist(PageUtil<Goods> pageBean,Goods goods);

    void deleteById(Long id);

    List<Goods> findAll();

    List<Goods> findByName(String name);

    int cout();

}
