package com.itheima.service;

import com.itheima.domain.Product;
import com.itheima.util.PageBean;

import java.util.List;

public interface ProductService {
    /**
     * 获取所有产品
     * @return
     */
    List<Product> getList();


    /**
     * 新建操作
     * @param product
     * @return
     */
    int add(Product product);


    /**
     * 更新产品
     * @param product
     * @return
     */
    int update(Product product);


    /**
     * 根据产品 的主键查询
     * @param id
     * @return
     */
    Product getById(Long id);




    /**
     * 删除操作
     * @param id
     */
    int deleteById(Integer id);


    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    PageBean<Product> pageList(int page, int size);
}
