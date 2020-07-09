package com.orange.admin.service.homeservice.Impl;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.dao.home.CustomerDao;
import com.orange.admin.pojo.common.Customer;
import com.orange.admin.service.homeservice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * @author 高晨
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer findBySn(String sn) {
        return customerDao.findBySn(sn);
    }

    @Override
    public Customer findById(Long id) {
        return customerDao.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public PageUtil<Customer> findlist(PageUtil<Customer> pageBean, Customer customer) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        exampleMatcher = exampleMatcher.withMatcher("sn", ExampleMatcher.GenericPropertyMatchers.contains());
        exampleMatcher = exampleMatcher.withIgnorePaths("status");
        Example<Customer> example = Example.of(customer, exampleMatcher);
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
        Page<Customer> findAll = customerDao.findAll(example, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }

    @Override
    public void deleteById(Long id) {
        customerDao.deleteById(id);
    }
}
