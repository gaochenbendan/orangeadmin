package com.orange.admin.service.homeservice.Impl;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.dao.home.GoodsDao;
import com.orange.admin.dao.home.ReportGoodsDao;
import com.orange.admin.dao.home.WantedGoodsDao;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.pojo.common.bo.GoodsCount;
import com.orange.admin.service.homeservice.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private WantedGoodsDao wantedGoodsDao;

    @Autowired
    private ReportGoodsDao reportGoodsDao;

    @Override
    public Goods save(Goods goods) {
        return goodsDao.save(goods);
    }

    @Override
    public PageUtil<Goods> findList(PageUtil<Goods> pageUtil, Goods goods) {
        ExampleMatcher withMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        ExampleMatcher sort1 = withMatcher.withIgnorePaths("flag","recommend","viewNumber");
        Example<Goods> example = Example.of(goods, sort1);
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime","recommend","flag","viewNumber");
        Pageable pageable = PageRequest.of(pageUtil.getCurrentPage()-1, pageUtil.getPageSize(),sort);
        Page<Goods> findAll = goodsDao.findAll(example, pageable);
        System.out.println("=============");
        System.out.println(findAll.getContent().toString());
        System.out.println("=============");
        pageUtil.setContent(findAll.getContent());
        pageUtil.setTotal(findAll.getTotalElements());
        pageUtil.setTotalPage(findAll.getTotalPages());

        return pageUtil;
    }

    @Override
    public PageUtil<Goods> findList(PageUtil<Goods> pageUtil, List<Long> cid) {
        List<Goods> list = goodsDao.findList(cid, pageUtil.getOffset(), pageUtil.getPageSize());
        pageUtil.setContent(list);
        pageUtil.setTotal(goodsDao.getTotalCount(cid));
        pageUtil.setTotalPage(Integer.parseInt(pageUtil.getTotal() / pageUtil.getPageSize()+""));
        long totalPage = pageUtil.getTotal() % pageUtil.getPageSize();
        if(totalPage != 0){
            pageUtil.setTotalPage(pageUtil.getTotalPage() + 1);
        }
        return pageUtil;
    }


    @Override
    public List<Goods> findByCustomer(Customer customer) {


        return goodsDao.findByCustome(customer.getId());
    }

    @Override
    public Goods find(Long id, Long customerId) {
        return goodsDao.findByIdAndCustomer_Id(id,customerId);
    }

    @Override
    public GoodsCount cout(Customer customer) {


        GoodsCount goodsCount = new GoodsCount();
        goodsCount.setAllCount(goodsDao.countByCustomer(customer));
        goodsCount.setSelloutCount(goodsDao.countByCustomerAndStatus(customer,3));
        goodsCount.setSellupCount(goodsDao.countByCustomerAndStatus(customer,1));
        goodsCount.setSellDownCount(goodsDao.countByCustomerAndStatus(customer,2));
        goodsCount.setWantedCount(wantedGoodsDao.countByCustomer(customer));
        goodsCount.setReportCount(reportGoodsDao.countByCustomer(customer));

        return goodsCount;
    }

    @Override
    public Goods findById(Long id) {
        return goodsDao.findById(id).orElse(null);
    }

    @Override
    public int coutSellOut() {
        return goodsDao.countByStatus(Goods.GOODS_STATUS_SOLD);
    }



    @Override
    public PageUtil<Goods> findlist(PageUtil<Goods> pageBean, Goods goods) {

        Specification<Goods> goodsSpecification = new Specification<Goods>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.like(root.get("name"), "%" + (goods.getName() == null ? "" : goods.getName()) + "%");
                if(goods.getCustomer() != null && goods.getCustomer().getId() != null){
                    Predicate equal1 = criteriaBuilder.equal(root.get("customer"), goods.getCustomer().getId());
                    predicate = criteriaBuilder.and(predicate,equal1);
                }
                if(goods.getStatus() != -1){
                    Predicate equal2 = criteriaBuilder.equal(root.get("status"), goods.getStatus());
                    predicate = criteriaBuilder.and(predicate,equal2);
                }
                if(goods.getGoodsCategory() != null && goods.getGoodsCategory().getId() != null){
                    Predicate equal2 = criteriaBuilder.equal(root.get("goodsCategory"), goods.getGoodsCategory().getId());
                    predicate = criteriaBuilder.and(predicate,equal2);
                }
                return predicate;
            }
        };
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime","recommend","flag","viewNumber");
        PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
        Page<Goods> findAll = goodsDao.findAll(goodsSpecification, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());


        return pageBean;
    }
}
