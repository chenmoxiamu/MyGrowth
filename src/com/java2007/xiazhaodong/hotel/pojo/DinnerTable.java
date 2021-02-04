package com.java2007.xiazhaodong.hotel.pojo;

import java.util.Date;

/**
 * 餐桌基类
 * @Author AzureSky_X
 * @Date 2021/1/27 15:47
 * @Version 1.0
 */
public class DinnerTable {
    /**
     * 餐桌id
     */
    private Integer id;
    /**
     *餐桌名
     */
    private String tableName;
    /**
     *餐桌状态
     */
    private String status;
    /**
     *预订时间
     */
    private Date reservationTime;
    /**
     *餐桌创建时间
     */
    private Date createTime;
    /**
     *餐桌更新时间
     */
    private Date updateTime;
    /**
     *餐桌创建者
     */
    private Integer createUser;

    public DinnerTable(Integer id, String tableName, String status, Date reservationTime, Date createTime, Date updateTime, Integer createUser) {
        this.id = id;
        this.tableName = tableName;
        this.status = status;
        this.reservationTime = reservationTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
    }

    public DinnerTable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
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

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }
}
