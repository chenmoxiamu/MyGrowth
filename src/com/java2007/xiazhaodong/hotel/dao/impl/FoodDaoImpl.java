package com.java2007.xiazhaodong.hotel.dao.impl;

import com.java2007.xiazhaodong.hotel.dao.FoodDao;
import com.java2007.xiazhaodong.hotel.pojo.Food;

import com.java2007.xiazhaodong.hotel.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/1/23 16:31
 * @Version 1.0
 */
public class FoodDaoImpl implements FoodDao {
    QueryRunner queryRunner=new QueryRunner();
    /**
     * 插入菜品
     * @param food
     * @return
     * @throws SQLException
     */
    @Override
    public int save(Food food) throws SQLException {
        String sql="INSERT INTO t_food (`type_id`,`food_name`,`price`,`vip_price`,`image`,`food_desc`) VALUES (?,?,?,?,?,?)";
        return queryRunner.update(DbUtils.getConnection(),sql,food.getTypeId(), food.getFoodName(),food.getPrice(),
                food.getVipPrice(), food.getImage(), food.getFoodDesc());

    }

    /**
     * 根据id查询菜品
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Food findById(int id) throws SQLException {
        String sql ="SELECT `food_id` foodId, `type_id` typeId, `food_name` foodName,`price`,`vip_price` vipPrice,`image`,`food_desc` foodDesc FROM `t_food` WHERE food_id = ?";
        return  queryRunner.query(DbUtils.getConnection(),sql,new BeanHandler<>(Food.class),id);
    }

    /**
     * 分页
     * @param start  起始页
     * @param pageSize 页大小
     * @return
     * @throws SQLException
     */
    @Override
    public List<Food> findByPage(Integer start, Integer pageSize,Food food) throws SQLException {
        List<Object> params = new ArrayList<>();

        StringBuffer sql = new StringBuffer("SELECT `food_id` foodId, `type_id` typeId, `food_name` foodName," +
                "`price`,`vip_price` vipPrice,`image`,`food_desc` foodDesc FROM t_food where 1=1");
        if(food.getTypeId() != null) {
            sql.append(" AND type_id = ? ");
            params.add(food.getTypeId());
        }
        if(null != food.getFoodName()) {
            sql.append(" AND food_name LIKE ? ");
            params.add("%" + food.getFoodName() + "%");
        }
        sql.append(" limit ?,?");
        params.add(start);
        params.add(pageSize);

        //System.out.println("sql: " + sql.toString());
        //System.out.println("参数: " + params);

        return queryRunner.query(DbUtils.getConnection(),sql.toString(), new BeanListHandler<>(Food.class), params.toArray());
    }

    /**
     * 获取总条数
     * @return
     * @throws SQLException
     */
    @Override
    public Long getCount(Food food) throws SQLException {
        List<Object> params=new ArrayList<>();
        //count(1) 统计的是第一个字段的行数，为null的行数不统计
        StringBuffer sql=new StringBuffer("select count(1) from t_food where 1=1");


        if(food.getTypeId() != null) {
            sql.append(" AND type_id = ? ");
            params.add(food.getTypeId());
        }
        if(null != food.getFoodName()) {
            sql.append(" AND food_name LIKE ? ");
            params.add("%" + food.getFoodName() + "%");
        }
        //ScalarHandler：将结果第一行的某一列放到某个对象
        return queryRunner.query(DbUtils.getConnection(),sql.toString(),new ScalarHandler<Long>() ,params.toArray());
    }
    /**
     * 查询所有菜品
     * @return
     * @throws SQLException
     */
    @Override
    public List<Food> findAll() throws SQLException {
        String sql="SELECT `food_id` foodId, `type_id` typeId, `food_name` foodName,\" +\n" +
                "                \"`price`,`vip_price` vipPrice,`image`,`food_desc` foodDesc FROM t_food ";
        return queryRunner.query(DbUtils.getConnection(),sql,new BeanListHandler<>(Food.class));
    }

    @Override
    public List<Food> findByName(String foodName) throws SQLException {
        String sql="SELECT `food_id` foodId, `type_id` typeId, `food_name` foodName,`price`,`vip_price` vipPrice,`image`,`food_desc` foodDesc FROM t_food where food_name LIKE ?";
        return queryRunner.query(DbUtils.getConnection(),sql,new BeanListHandler<>(Food.class),foodName);
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        String sql="delete from t_food where food_id=?";
        return queryRunner.update(DbUtils.getConnection(),sql,id);
    }
    /**
     * 更新
     * @param food
     * @return
     * @throws SQLException
     */
    @Override
    public int update(Food food) throws SQLException {

        String sql = "UPDATE t_food SET food_name = ?,price = ?,vip_price = ?,image = ?,food_desc = ?,type_id = ? WHERE food_id = ?";
        return queryRunner.update(DbUtils.getConnection(),sql,food.getFoodName(),food.getPrice(),food.getVipPrice(),food.getImage(),food.getFoodDesc(),food.getTypeId(),food.getFoodId());
    }
    /**
     * 根据菜类别id查找菜品
     * @return
     * @throws SQLException
     */
    @Override
    public Food findByFoodTypeId(int typeId) throws SQLException {
        String sql ="SELECT `food_id` foodId, `type_id` typeId, `food_name` foodName,`price`,`vip_price` vipPrice,`image`,`food_desc` foodDesc FROM t_food where type_id=?  ";

        return queryRunner.query(DbUtils.getConnection(),sql,new BeanHandler<>(Food.class),typeId);
    }

}





