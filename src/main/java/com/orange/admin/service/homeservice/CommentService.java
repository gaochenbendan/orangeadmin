package com.orange.admin.service.homeservice;

import com.orange.admin.commons.utils.PageUtil;
import com.orange.admin.pojo.common.Comment;
import com.orange.admin.pojo.common.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    public Comment save(Comment comment);

    public void deleteById(Long id);

    public  Comment saveById(Long id);

    public List<Comment> findByGoods(Goods goods);

    public List<Comment> findBALL();

    public PageUtil<Comment> findlist(PageUtil<Comment> pageBean, Comment comment, List<Goods> goodsList);

    Long cout();

}
