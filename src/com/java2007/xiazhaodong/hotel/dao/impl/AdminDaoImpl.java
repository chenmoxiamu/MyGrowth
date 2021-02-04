package com.java2007.xiazhaodong.hotel.dao.impl;

import com.java2007.xiazhaodong.hotel.dao.AdminDao;
import com.java2007.xiazhaodong.hotel.pojo.Admin;
import com.java2007.xiazhaodong.hotel.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Author AzureSky_X
 * @Date 2021/1/27 10:54
 * @Version 1.0
 */
public class AdminDaoImpl  implements AdminDao {
    QueryRunner queryRunner=new QueryRunner();
    /**
     * 根据用户名查询用户信息
     * @param adminName
     * @return
     * @throws SQLException
     */
    @Override
    public Admin findByAdminName(String adminName) throws SQLException {
        String sql = "SELECT `admin_id` adminId,`admin_name` adminName,`password`,`status`,`phone`,`email`,`role`,`admin_create_time` adminCreateTime,`admin_update_time` adminUpdateTime FROM `t_admin` WHERE `admin_name` = ?";
        return queryRunner.query(DbUtils.getConnection(),sql,new BeanHandler<>(Admin.class),adminName);
    }
}
