package com.java2007.xiazhaodong.hotel.dao.impl;

import com.java2007.xiazhaodong.hotel.dao.OrderDetailDao;
import com.java2007.xiazhaodong.hotel.pojo.OrderDetail;
import com.java2007.xiazhaodong.hotel.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/1/28 19:13
 * @Version 1.0
 */
public class OrderDetailDaoImpl implements OrderDetailDao {
    QueryRunner queryRunner=new QueryRunner();
    /**
     * 保存订单详细信息到订单详情表
     * @param orderDetail  订单详细信息
     * @return
     * @throws SQLException
     */
    @Override
    public int save(OrderDetail orderDetail) throws SQLException {
        //插入要啥别名啊，想啥呢
        String sql = "INSERT INTO `t_order_detail` " +
                " (`id`,`food_id`,`food_name`,`price`,`num`,`total_price`,`create_time`,`update_time`, order_id) " +
                " VALUES (?,?,?,?,?,?,?,?,?)";
        return queryRunner.update(DbUtils.getConnection(),sql, orderDetail.getId(),
                orderDetail.getFoodId(), orderDetail.getFoodName(), orderDetail.getPrice(),
                orderDetail.getNum(), orderDetail.getTotalPrice(), orderDetail.getCreateTime(),
                orderDetail.getUpdateTime(), orderDetail.getOrderId());
    }

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public List<OrderDetail> findById(Long id) throws SQLException {
        String sql="select id ,food_id foodId,food_name foodName ,price ,num,total_price totalPrice ,create_time createTime," +
                "update_time updateTime,order_id orderId from t_order_detail where order_id=?";
        return queryRunner.query(DbUtils.getConnection(),sql,new BeanListHandler<>(OrderDetail.class),id);
    }


}
