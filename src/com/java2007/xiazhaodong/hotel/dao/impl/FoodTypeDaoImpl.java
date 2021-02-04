package com.java2007.xiazhaodong.hotel.dao.impl;


import com.java2007.xiazhaodong.hotel.dao.FoodTypeDao;
import com.java2007.xiazhaodong.hotel.pojo.FoodType;
import com.java2007.xiazhaodong.hotel.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/1/19 17:27
 * @Version 1.0
 */
public class FoodTypeDaoImpl implements FoodTypeDao {
    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<FoodType> findAll() throws SQLException {

        QueryRunner runner = new QueryRunner();
        String sql = "SELECT type_id typeId, type_name typeName FROM t_food_type";
        return runner.query(DbUtils.getConnection(),sql, new BeanListHandler<>(FoodType.class));
    }

    /**
     * 根据菜类别名称模糊查询
     *
     * @param typeName
     * @return
     */
    @Override
    public List<FoodType> findByTypeName(String typeName) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "SELECT type_id typeId, type_name typeName FROM t_food_type WHERE type_name LIKE ?";
        return runner.query(DbUtils.getConnection(),sql, new BeanListHandler<>(FoodType.class), typeName);
    }

    /**
     * 根据typeId删除
     *
     * @param typeId
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteByTypeId(Integer typeId) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "DELETE FROM t_food_type WHERE type_id = ?";
        return runner.update(DbUtils.getConnection(), sql, typeId);
    }

    /**
     * 增加
     *
     * @param typeName
     */
    @Override
    public int save(String typeName) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "INSERT INTO t_food_type (type_name) VALUES (?)";
        return runner.update(DbUtils.getConnection(), sql, typeName);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public FoodType findByTypeId(int id) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "SELECT type_id typeId, type_name typeName FROM t_food_type WHERE type_id = ?";
        return runner.query(DbUtils.getConnection(),sql, new BeanHandler<>(FoodType.class), id);
    }

    /**
     * 更新
     *
     * @param foodType
     * @return
     * @throws SQLException
     */
    @Override
    public int update(FoodType foodType) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "UPDATE t_food_type SET type_name = ? WHERE type_id = ?";
        return runner.update(DbUtils.getConnection(), sql, foodType.getTypeName(), foodType.getTypeId());
    }
    /**
     * 检测菜类别名是否存在
     * 不能使用模糊查询
     * @param newFoodTypeName 菜类别名
     * @return 菜类别对象
     */
    @Override
    public FoodType findFoodTypeByName(String newFoodTypeName) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "SELECT type_id typeId, type_name typeName FROM t_food_type WHERE type_name = ?";
        return runner.query(DbUtils.getConnection(),sql, new BeanHandler<>(FoodType.class), newFoodTypeName);
    }

}
