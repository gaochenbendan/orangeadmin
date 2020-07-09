package com.orange.admin;

import com.orange.admin.dao.home.GoodsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminApplicationTests {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    void contextLoads() {



    }

}
