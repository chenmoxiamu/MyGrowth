package com.java2007.xiazhaodong.hotel.service;

import com.java2007.xiazhaodong.hotel.pojo.Admin;

import java.sql.SQLException;

/**
 * @Author AzureSky_X
 * @Date 2021/1/27 11:10
 * @Version 1.0
 */
public interface AdminService {
    /**
     * 登录
     * @param adminName  用户名
     * @param password
     * @return
     * @throws SQLException
     */
    Admin login(String adminName,String password)throws SQLException;
}
