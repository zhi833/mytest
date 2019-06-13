package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;

public interface OrdersService {


    /**
     * 查询所有订单
     * @return
     */
    List<Orders> list();


    /**
     *添加订单
     * @param orders
     * @return
     */
    int add(Orders orders);
}
