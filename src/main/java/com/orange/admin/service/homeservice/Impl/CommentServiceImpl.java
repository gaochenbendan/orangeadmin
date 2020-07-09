package com.orange.admin.service.homeservice.Impl;

import com.orange.admin.dao.home.CommentDao;
import com.orange.admin.pojo.common.Comment;
import com.orange.admin.pojo.common.Goods;
import com.orange.admin.service.homeservice.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
