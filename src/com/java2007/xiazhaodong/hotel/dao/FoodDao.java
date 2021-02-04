package com.java2007.xiazhaodong.hotel.dao;

import com.java2007.xiazhaodong.hotel.pojo.DinnerTable;
import com.java2007.xiazhaodong.hotel.pojo.Food;

import java.sql.SQLException;
import java.util.List;

/**
 * 菜品接口
 * @Author AzureSky_X
 * @Date 2021/1/23 16:29
 * @Version 1.0
 */
public interface FoodDao {
    /**
     * 插入菜品
     * @param food
     * @return
     * @throws SQLException
     */
    int save(Food food) throws SQLException;

    /**
     * 根据id查询菜品
     * @param id
     * @return
     * @throws SQLException
     */
    Food findById(int id )throws SQLException;


    /**
     * 分页
     * @param start  起始页
     * @param pageSize 页大小
     * @return
     * @throws SQLException
     */
    List<Food> findByPage (Integer start, Integer pageSize,Food food)throws  SQLException;

    /**
     * 获取总条数
     * @return
     * @throws SQLException
     */
    Long getCount(Food food)throws  SQLException;


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


    /**
     * 根据菜类别id查找菜品
     * @return
     * @throws SQLException
     */
    Food  findByFoodTypeId(int typeId) throws SQLException;
}
