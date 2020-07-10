package com.orange.admin.service.homeservice.Impl;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.dao.home.CommentDao;
import com.orange.admin.pojo.common.Comment;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.service.homeservice.CommentService;
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

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        commentDao.deleteById(id);
    }

    @Override
    public Comment saveById(Long id) {
        return commentDao.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findByGoods(Goods goods) {
        return commentDao.findByGoods(goods);
    }

    @Override
    public List<Comment> findBALL() {
        return commentDao.findAll();
    }

    @Override
    public PageUtil<Comment> findlist(PageUtil<Comment> pageBean, Comment comment, List<Goods> goodsList) {
        Specification<Comment> specification = new Specification<Comment>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Comment> root,
                                         CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.like(root.get("content"), "%" + (comment.getContent() == null ? "" : comment.getContent()) + "%");
                if(comment.getCustomer() != null && comment.getCustomer().getId() != null){
                    Predicate equal1 = criteriaBuilder.equal(root.get("customer"), comment.getCustomer().getId());
                    predicate = criteriaBuilder.and(predicate,equal1);
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
        Page<Comment> findAll = commentDao.findAll(specification, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }

    @Override
    public Long cout() {
        return commentDao.count();
    }


}
