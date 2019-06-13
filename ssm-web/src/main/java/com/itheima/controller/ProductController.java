package com.itheima.controller;


import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 商品列表显示
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model){
        //调用业务查询
        List<Product> products = productService.getList();

        System.out.println(products.toString());

        //塞给页面
        model.addAttribute("products",products);
        return "product-list";
    }


    /**
     *
     * @param page 当前页码
     * @param size 每页显示记录条数
     * @param model
     * @return
     */
    @RequestMapping("/pageList")
    public String pageList(@RequestParam(value = "page",required = false,defaultValue = "1") int page,
                           @RequestParam(value = "size",required = false,defaultValue = "10") int size,
                           Model model){
        //调用业务查询
        PageBean<Product> pageInfo = productService.pageList(page,size);

        //塞给页面
        model.addAttribute("pageInfo",pageInfo);
        return "product-list";
    }





    /**
     * 新增页面跳转
     */
    @RequestMapping("/initAdd")
    public String initAdd(){
        //为什么独立出一个请求的方法:
        //方便以后的权限控制,如果登录的用户没有 添加 的权限,就会进入拦截里,如果只是在页面做页面之间的跳转则不利于后期的权限控制
        return "product-add";
    }


    /**
     * 增加操作
     * @param product
     * @return
     */
    @RequestMapping("/add")
    public String add(Product product) {

        //增加数据
        int count = productService.add(product);

        return "redirect:/product/list";
    }


    /**
     * 修改产品
     * @param product
     * @return
     */
    @RequestMapping("/update")
    public String update(Product product){
        int count =productService.update(product);

        return "redirect:/product/list";
    }


    /**
     * 修改产品 回显
     * 通过编号查询产品信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/initUpdate")
    public String initUpdate(Long id , Model model){

        Product product = productService.getById(id);

        model.addAttribute("product",product);

        return "product-update";
    }


    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        int count =productService.deleteById(id);

        return "redirect:/product/list";
    }

}
