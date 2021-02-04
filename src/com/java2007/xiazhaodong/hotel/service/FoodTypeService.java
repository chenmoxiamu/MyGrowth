package com.java2007.xiazhaodong.hotel.service;



import com.java2007.xiazhaodong.hotel.pojo.Food;
import com.java2007.xiazhaodong.hotel.pojo.FoodType;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/1/19 20:14
 * @Version 1.0
 */
public interface FoodTypeService {
    /**
     * 查询所有
     * @return
     */
    List<FoodType> findAll() throws SQLException;

    /**
     * 根据菜类别名称查询
     * @param keyword
     * @return
     */
    List<FoodType> findByTypeName(String keyword) throws SQLException;

    /**
     * 根据typeId删除
     * @param typeId
     * @return
     * @throws SQLException
     */
    int deleteByTypeId(Integer typeId) throws SQLException;

    /**
     * 增加
     * @param foodName
     * @return
     * @throws SQLException
     */
    int save(String foodName) throws SQLException;

    /**
     * 根据id查询
     * @param id
     * @return
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
     * 校验菜类别名是否存在
     *  0：不存在
     *  1：存在
     * @param newFoodTypeName
     * @return
     */
    int checkFoodTypeName(String newFoodTypeName);

    /**
     * 根据菜类别id查找菜品
     * @return
     * @throws SQLException
     */
    int findByFoodTypeId(int typeId) throws SQLException;
}
