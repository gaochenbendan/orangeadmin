package com.orange.admin.service.homeservice.Impl;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.dao.home.ReportGoodsDao;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.pojo.common.ReportGoods;
import com.orange.admin.service.homeservice.ReportGoodsServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Override
    public PageUtil<ReportGoods> findlist(PageUtil<ReportGoods> pageBean, ReportGoods reportGoods, List<Goods> goodsList) {
        Specification<ReportGoods> specification = new Specification<ReportGoods>() {

            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<ReportGoods> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.like(root.get("content"), "%" + (reportGoods.getContent() == null ? "" : reportGoods.getContent()) + "%");
                if(reportGoods.getCustomer() != null && reportGoods.getCustomer().getId() != null){
                    Predicate eqal1 = criteriaBuilder.equal(root.get("customer"), reportGoods.getCustomer().getId());
                    predicate = criteriaBuilder.and(predicate,eqal1);
                }
                if(goodsList != null && goodsList.size() >0 ){
                    CriteriaBuilder.In<Object> in = criteriaBuilder.in(root.get("goods"));
                    in.value(goodsList);
                    predicate = criteriaBuilder.and(predicate,in);
                }
                return predicate;
            }
        };
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
        Page<ReportGoods> findAll = reportGoodsDao.findAll(specification, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }
}
