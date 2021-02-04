package com.java2007.xiazhaodong.hotel.dao;

import com.java2007.xiazhaodong.hotel.pojo.DinnerTable;
import com.java2007.xiazhaodong.hotel.pojo.FoodType;


import java.sql.SQLException;
import java.util.List;

/**
 * 菜类别持久层接口
 * @Author AzureSky_X
 * @Date 2021/1/19 17:22
 * @Version 1.0
 */
public interface FoodTypeDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<FoodType> findAll() throws SQLException;

    /**
     * 根据菜类别名称模糊查询
     * @param typeName
     * @return
     */
    List<FoodType> findByTypeName(String typeName) throws SQLException;


    /**
     * 根据typeId删除
     * @param typeId
     * @return
     * @throws SQLException
     */
    int deleteByTypeId(Integer typeId) throws SQLException;


    /**
     * 增加
     * @param typeName
     */
    int save(String typeName) throws SQLException;

    /**
     * 根据ID查询
     * @param id
     * @return
     * @throws SQLException
     */
    FoodType findByTypeId(int id) throws SQLException;

    /**
     * 更新
     * @param foodType
     * @return
     * @throws SQLException
     */
    int update(FoodType foodType) throws SQLException;
    /**
     * 检测菜类别名是否存在
     * @param newFoodTypeName 菜类别名
     * @return 菜类别对象
     */
    FoodType findFoodTypeByName(String newFoodTypeName) throws SQLException;



}

