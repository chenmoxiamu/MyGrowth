package com.java2007.xiazhaodong.hotel.pojo;

import java.util.Date;

/**
 * 订单详情基类
 * @Author AzureSky_X
 * @Date 2021/1/27 21:33
 * @Version 1.0
 */
public class OrderDetail {
    /**
     * 订单详情id
     * 不自增，因为下单的人较多时可能会产生问题
     */
    private Long id;
    /**
     * 菜品id
     */
    private Integer foodId;
    /**
     * 菜品名
     */
    private String foodName;
    /**
     * 菜品单价
     */
    private Long price;
    /**
     * 菜品数量
     */
    private Integer num;
    /**
     * 菜品总价格
     */
    private Long totalPrice;
    /**
     * 订单创建时间
     */
    private Date createTime;
    /**
     * 订单更新时间
     */
    private Date updateTime;
    /**
     * 订单id
     */
    private Long orderId;

    public OrderDetail() {}

    public OrderDetail(Long id, Integer foodId, String foodName, Long price, Integer num, Long totalPrice, Date createTime, Date updateTime) {
        this.id = id;
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.num = num;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
