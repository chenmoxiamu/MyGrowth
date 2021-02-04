package com.java2007.xiazhaodong.hotel.pojo;

import java.util.Date;

/**
 * @Author AzureSky_X
 * @Date 2021/1/27 10:43
 * @Version 1.0
 */
public class Admin {
    /**
     * 用户id
     */
    private String adminId;
    /**
     *用户名
     */
    private String adminName;
    /**
     *密码
     */
    private String password;
    /**
     *用户状态
     * 0:未激活
     * 1:已激活
     * 2:已禁用
     */
    private Integer status;
    /**
     *手机号
     */
    private String phone;
    /**
     *邮箱
     */
    private String email;
    /**
     *用户角色权限
     */
    private String role;
    /**
     *账户创建时间
     */
    private Date adminCreateTime;
    /**
     *账户更新时间
     */
    private Date adminUpdateTime;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getAdminCreateTime() {
        return adminCreateTime;
    }

    public void setAdminCreateTime(Date adminCreateTime) {
        this.adminCreateTime = adminCreateTime;
    }

    public Date getAdminUpdateTime() {
        return adminUpdateTime;
    }

    public void setAdminUpdateTime(Date adminUpdateTime) {
        this.adminUpdateTime = adminUpdateTime;
    }

    public Admin() {}
}
