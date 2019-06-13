package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * 查询列表
     * @return
     */
    @Override
    public List<Product> getList() {
        return productDao.getList();
    }


    /**
     * 新建操作
     * @param product
     * @return
     */
    @Override
    public int add(Product product) {
        return productDao.add(product);
    }


    /**
     * 修改操作
     * @param product
     * @return
     */
    @Override
    public int update(Product product) {
        return productDao.update(product);
    }


    /**
     * 通过id修改
     * @param id
     * @return
     */
    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    /**
     * g根据id删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {

        return productDao.deleteById(id);
    }

    @Override
    public PageBean<Product> pageList(int page, int size) {

        //开始的行号
        int start=(page-1)*size+1;
        //结束的行号
        int end=page*size;

        //获取查询结果
      List<Product> products =  productDao.pageList(start,end);
        //获取总记录数
        int total = productDao.getCount();
        //返回的分页结果
        PageBean<Product> pageInfo = new PageBean<Product>();
        pageInfo.setBeanList(products);
        pageInfo.setTotalCount(total);


        //设置每页记录数
        pageInfo.setPageSize(size);
        //设置页码
        pageInfo.setPageCode(page);
        //页码显示中需要用到


      return pageInfo;
    }


}
