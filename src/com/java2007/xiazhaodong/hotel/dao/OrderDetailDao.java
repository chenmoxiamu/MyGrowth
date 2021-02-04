package com.java2007.xiazhaodong.hotel.dao;

import com.java2007.xiazhaodong.hotel.pojo.Order;
import com.java2007.xiazhaodong.hotel.pojo.OrderDetail;

import java.sql.SQLException;
import java.util.List;

/**
 * 订单详情数据访问层接口
 * @Author AzureSky_X
 * @Date 2021/1/28 19:09
 * @Version 1.0
 */
public interface OrderDetailDao {
    /**
     * 保存订单详细信息到订单详情表
     * @param orderDetail  订单详细信息
     * @return
     * @throws SQLException
     */
    int save(OrderDetail orderDetail)throws SQLException;
    /**
     * 根据订单id查询
     * 的订单详情
     * @param id
     * @return
     * @throws SQLException
     */
    List<OrderDetail> findById(Long id) throws SQLException;
}
