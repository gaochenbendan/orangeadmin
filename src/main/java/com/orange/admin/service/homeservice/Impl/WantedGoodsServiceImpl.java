package com.orange.admin.service.homeservice.Impl;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.dao.home.WantedGoodsDao;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.WantedGoods;
import com.orange.admin.service.homeservice.WantedGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 高晨
 */
@Service
public class WantedGoodsServiceImpl implements WantedGoodsService {

    @Autowired
    private WantedGoodsDao wantedGoodsDao;

    @Override
    public WantedGoods save(WantedGoods wantedGoods) {
        return wantedGoodsDao.save(wantedGoods);
    }

    @Override
    public List<WantedGoods> findAll(Customer customer) {
        return wantedGoodsDao.findByCustomer(customer);
    }

    @Override
    public WantedGoods findById(Long id) {
        return wantedGoodsDao.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        wantedGoodsDao.deleteById(id);
    }

    @Override
    public PageUtil<WantedGoods> findList(PageUtil<WantedGoods> pageUtil,WantedGoods wantedGoods) {
        ExampleMatcher withMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        ExampleMatcher sort1 = withMatcher.withIgnorePaths("viewNumber");
        Example<WantedGoods> example = Example.of(wantedGoods, sort1);
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime","viewNumber");
        Pageable pageable = PageRequest.of(pageUtil.getCurrentPage()-1, pageUtil.getPageSize(),sort);
        Page<WantedGoods> findAll = wantedGoodsDao.findAll(example, pageable);
        System.out.println("=============");
        System.out.println(findAll.getContent().toString());
        System.out.println("=============");
        pageUtil.setContent(findAll.getContent());
        pageUtil.setTotal(findAll.getTotalElements());
        pageUtil.setTotalPage(findAll.getTotalPages());
        return pageUtil;
    }


}
