package com.java2007.xiazhaodong.hotel.dao;

import com.java2007.xiazhaodong.hotel.pojo.DinnerTable;
import com.java2007.xiazhaodong.hotel.pojo.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * 订单数据访问层接口
 * @Author AzureSky_X
 * @Date 2021/1/28 17:12
 * @Version 1.0
 */
public interface OrderDao {
    /**
     * 保存订单
     * @param order 订单数据
     * @return
     * @throws SQLException
     */
    int save(Order order)throws SQLException;

    /**
     * 更新订单状态
     * @param orderId   订单id
     * @param status  订单状态
     * @return
     * @throws SQLException
     */
    int updateOrderStatus(Long orderId,int status)throws SQLException;

    /**
     * 查询所有订单
     * @return
     * @throws SQLException
     */

    List<Order> findAll() throws SQLException;
}
