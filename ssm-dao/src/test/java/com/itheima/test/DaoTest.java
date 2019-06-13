package com.itheima.test;


import com.itheima.dao.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class DaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testDao(){
        System.out.println(productDao.getList().size());
    }
}
