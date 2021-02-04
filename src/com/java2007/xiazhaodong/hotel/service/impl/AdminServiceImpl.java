package com.java2007.xiazhaodong.hotel.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.java2007.xiazhaodong.hotel.dao.AdminDao;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.Admin;
import com.java2007.xiazhaodong.hotel.service.AdminService;
import com.java2007.xiazhaodong.hotel.utils.MD5Utils;

import java.sql.SQLException;

/**
 * @Author AzureSky_X
 * @Date 2021/1/27 11:11
 * @Version 1.0
 */
public class AdminServiceImpl  implements AdminService {
    AdminDao adminDao= (AdminDao) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.dao.impl.AdminDaoImpl");
    /**
     * 登录
     * @param adminName  用户名
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public Admin login(String adminName, String password) throws SQLException {
        try {
            if (StringUtils.isEmpty(adminName)||StringUtils.isEmpty(password)){
                throw new RuntimeException("用户名与密码不能为空");
            }
            //根据用户名查询用户信息并去除用户输入的用户名中存在的空格
            Admin admin=adminDao.findByAdminName(adminName.trim());
            if (admin==null){
                throw new RuntimeException("用户名或密码不正确");
            }
            //dbPwd：加密的密码
            String dbPwd = admin.getPassword();
            //password:明文密码
            if (dbPwd.equals(MD5Utils.md5(password))){
                return admin;
            }else {
                throw new RuntimeException("用户名或密码不正确");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("用户名或密码不正确");
        }


    }
}
