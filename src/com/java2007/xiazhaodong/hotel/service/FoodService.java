package com.java2007.xiazhaodong.hotel.service;

import com.java2007.xiazhaodong.hotel.pojo.Food;
import com.java2007.xiazhaodong.hotel.entity.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/1/23 16:41
 * @Version 1.0
 */
public interface FoodService {
    /**
     * 插入菜品业务
     * @param food
     * @return
     * @throws SQLException
     */
    int save(Food food) throws SQLException;

    /**
     * 根据id查询菜品数据
     * @param id
     * @return
     * @throws SQLException
     */
    Food findById(int id )throws SQLException;

    /**
     * 分页
     * @param pageNo 当前页
     * @param pageSize 页大小：每页几条数据
     * @return
     * @throws SQLException
     */
    PageBean<Food> findByPage(Integer pageNo, Integer pageSize,Food food)throws SQLException;
    /**
     * 查询所有菜品
     * @return
     * @throws SQLException
     */
    List<Food> findAll() throws SQLException;

    /**
     * 根据菜品名模糊查询
     * @param foodName 菜品名
     * @return
     * @throws SQLException
     */
    List<Food> findByName(String foodName) throws SQLException;

    /**
     * 根据id删除餐桌
     * @param id
     * @return
     * @throws SQLException
     */

    int deleteById(Integer id) throws SQLException;

    /**
     * 更新
     * @param food
     * @return
     * @throws SQLException
     */
    int update(Food food) throws SQLException;




}
