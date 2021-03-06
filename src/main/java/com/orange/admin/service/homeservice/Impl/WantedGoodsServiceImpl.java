package com.orange.admin.service.homeservice.Impl;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.dao.home.WantedGoodsDao;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.WantedGoods;
import com.orange.admin.service.homeservice.WantedGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    @Override
    public PageUtil<WantedGoods> findWantedGoodslist(PageUtil<WantedGoods> pageBean, WantedGoods wantedGoods) {
        Specification<WantedGoods> specification = new Specification<WantedGoods>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<WantedGoods> root,
                                         CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.like(root.get("name"), "%" + (wantedGoods.getName() == null ? "" : wantedGoods.getName()) + "%");
                if(wantedGoods.getCustomer() != null && wantedGoods.getCustomer().getId() != null){
                    Predicate equal1 = criteriaBuilder.equal(root.get("customer"), wantedGoods.getCustomer().getId());
                    predicate = criteriaBuilder.and(predicate,equal1);
                }
                return predicate;
            }
        };
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
        Page<WantedGoods> findAll = wantedGoodsDao.findAll(specification, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }

    @Override
    public Long cout() {
        return wantedGoodsDao.count();
    }


}
