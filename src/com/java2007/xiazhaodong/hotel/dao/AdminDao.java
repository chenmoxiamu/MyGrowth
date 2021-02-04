package com.java2007.xiazhaodong.hotel.dao;

import com.java2007.xiazhaodong.hotel.pojo.Admin;

import java.sql.SQLException;

/**
 * @Author AzureSky_X
 * @Date 2021/1/27 10:52
 * @Version 1.0
 */
public interface AdminDao {
    /**
     * 根据用户名查询用户信息
     * @param adminName
     * @return
     * @throws SQLException
     */
    Admin findByAdminName(String adminName)throws SQLException;
}
