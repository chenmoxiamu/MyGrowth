package com.java2007.xiazhaodong.hotel.pojo;

import java.util.Date;

/**
 * 订单基类
 * @Author AzureSky_X
 * @Date 2021/1/28 17:08
 * @Version 1.0
 */
public class Order {
    /**
     * 订单id
     */
    private Long id;
    /**
     * 餐桌id
     */
    private Integer tableId;
    /**
     * 总价
     */
    private Long totalPrice;
    /**
     * 支付状态
     * 0：未支付
     * 1：已支付
     * 2：已取消
     */
    private Integer payStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建者
     */
    private int createUser;
    public Order() {
    }

    public Order(Long id, Integer tableId, Long totalPrice, Integer payStatus, Date createTime, Date updateTime, int createUser) {
        this.id = id;
        this.tableId = tableId;
        this.totalPrice = totalPrice;
        this.payStatus = payStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
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

    public int getCreateUser() {
        return createUser;
    }

    public void setCreateUser(int createUser) {
        this.createUser = createUser;
    }
}
