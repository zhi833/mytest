package com.itheima.domain;

import com.itheima.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 产品 实体
 */
public class Product {
    private Integer id; // 主键
    private String productNum;// 产品的编号
    private String productName;// 产品名称
    private String cityName;// 出发城市
    /**
     * 解决的是前端提交过来的是字符串，而用的是Date类型，类型转换
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;// 出发时间
    private Double productPrice;// 产品价格
    private String productDesc;// 描述
    private int productStatus;// 产品 的状态 0：关闭，1：开启

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    /**
     * 出发时间的格式化
     * 页面中的调用：去除get, 首字小写
     * @return
     */
    public String getDepartureTimeStr() {
        if(null != departureTime){
            return DateUtil.date2Str(departureTime,DateUtil.ymdHm);
        }
        return "";
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }
}
