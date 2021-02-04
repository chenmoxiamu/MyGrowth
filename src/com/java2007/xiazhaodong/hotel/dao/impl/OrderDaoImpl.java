package com.java2007.xiazhaodong.hotel.dao.impl;

import com.java2007.xiazhaodong.hotel.dao.OrderDao;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.Food;
import com.java2007.xiazhaodong.hotel.pojo.Order;
import com.java2007.xiazhaodong.hotel.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/1/28 17:16
 * @Version 1.0
 */
public class OrderDaoImpl implements OrderDao {
    QueryRunner queryRunner= new QueryRunner();
    /**
     * 保存订单
     * @param order 订单数据
     * @return
     * @throws SQLException
     */
    @Override
    public int save(Order order) throws SQLException {
        String sql = "INSERT INTO `t_order` " +
                " (`id`,`table_id`,`total_price`,`pay_status`,`create_time`,`update_time`,`create_user`) " +
                " VALUES (?,?,?,?,?,?,?)";

        return queryRunner.update(DbUtils.getConnection(),sql,order.getId(), order.getTableId(),
                order.getTotalPrice(),order.getPayStatus(), order.getCreateTime(), order.getUpdateTime(), order.getCreateUser());
    }

    /**
     * 更新订单状态
     * @param orderId   订单id
     * @param status  订单状态
     * @return
     * @throws SQLException
     */
    @Override
    public int updateOrderStatus(Long orderId, int status) throws SQLException {
        String sql = " UPDATE `t_order` SET `pay_status` = ? WHERE id = ?";
        return queryRunner.update(DbUtils.getConnection(),sql,status,orderId);
    }

    @Override
    public List<Order> findAll() throws SQLException {
        String sql="select id,table_id tableId,total_price totalPrice,pay_status payStatus, create_time createTime," +
                "update_time updateTime,create_user createUser from t_order ";
        return queryRunner.query(DbUtils.getConnection(),sql,new BeanListHandler<>(Order.class));
    }
}
