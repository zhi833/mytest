package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;


import java.util.List;

/**
 * 产品 数据访问接口
 */
public interface ProductDao {
    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from product")
    @Results({
            @Result(column = "departureTime", property = "departureTime",jdbcType = JdbcType.TIMESTAMP)
    })
    List<Product> getList();


    /**
     * 新建操作
     * @param product
     * @return
     */
    @Insert("insert into product values (product_seq.nextval,#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    int add(Product product);

    /**
     * 修改操作
     * @param product
     * @return
     */
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    int update(Product product);


    /**
     * 根据主键查询产品信息
     * @param id
     * @return
     */
    @Select("select * from product where id=#{id}")
    Product getById(Long id);


    /**
     * 通过编号删除产品信息
     * 注：在真实开发环境中，一般不删除数据，而修改状态的值为禁用
     * @param id
     * @return
     */
    @Delete("delete from product where id=#{id}")
    int deleteById(Integer id);


    /**
     * 分页查询
     * @param start
     * @param end
     * @return
     */
    @Select("select t.* from (select rownum rn,p.* from product p where rownum<=#{end}) t where t.rn>=#{start}")
    List<Product> pageList(@Param("start") int start, @Param("end") int end);


    /**
     * 获取总数
     * @return
     */
    @Select("select count(1) from product")
    int getCount();

}

