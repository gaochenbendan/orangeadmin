package com.orange.admin.service.homeservice;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.pojo.common.bo.GoodsCount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {

    /**
     * 保存数据
     *
     * @return
     */
    public Goods save(Goods goods);

    /**
     * 查找
     *
     * @return
     */
    public PageUtil<Goods> findList(PageUtil<Goods> pageUtil ,Goods goods);
    public PageUtil<Goods> findList(PageUtil<Goods> pageUtil,List<Long> cid);

    /**
     * 通过消费者查找
     *
     * @return
     */
    public List<Goods> findByCustomer(Customer customer);

    public Goods find(Long id,Long customerId);

    public GoodsCount cout(Customer customer);

    public Goods findById(Long id);

    public int coutSellOut();


    public PageUtil<Goods> findlist(PageUtil<Goods> pageBean,Goods goods);

}
