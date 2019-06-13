package com.itheima.controller;


import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.OrdersService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    /**
     * 订单列表
     * @param model
     * @return
     */

    @RequestMapping("/list")
    public String list(Model model){

        //调用业务查询
        List<Orders> orders= ordersService.list();

        model.addAttribute("orders",orders);
        //返回给页面
        return "order-list";
    }


    @Autowired
    private ProductService productService;



    /***
     * 增加订单页面跳转
     * @return
     */
    @RequestMapping(value="initAdd" ,method = RequestMethod.GET)
    public String initAdd(Model model){

        //查询所有产品的信息,页面需要提供产品下拉列表,所以需要注入ProductService来实现查询所有的产品
        List<Product> pList = productService.getList();
        model.addAttribute("pList",pList);
        return "order-add";
    }

    /**
     * 保存操作
     * @param orders
     * @return
     */
    @RequestMapping(value = "/add" ,method= RequestMethod.POST)
    public String add(Orders orders){

        //添加业务订单
        int count = ordersService.add(orders);

        return "redirect:/orders/list";
    }

}
