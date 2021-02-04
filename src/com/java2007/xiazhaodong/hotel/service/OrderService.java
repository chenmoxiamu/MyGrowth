package com.java2007.xiazhaodong.hotel.service;

import com.java2007.xiazhaodong.hotel.entity.CartItem;
import com.java2007.xiazhaodong.hotel.entity.Result;
import com.java2007.xiazhaodong.hotel.pojo.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * 订单服务层接口
 * @Author AzureSky_X
 * @Date 2021/1/28 17:45
 * @Version 1.0
 */
public interface OrderService {

    /**
     * 创建订单
     * @param cart     餐车数据
     * @param cartTotalPrice  餐车中菜品总价
     * @param tableId  餐桌id
     * @return
     */
    Result generatorOrder(List<CartItem> cart,Long cartTotalPrice,Integer tableId);

    /**
     * 更新订单状态
     * @param orderId   订单id
     * @param status  订单状态
     * @return
     * @throws SQLException
     */
    int updateOrderStatus(Long orderId ,int status )throws SQLException;


    /**
     * 查询所有订单
     * @return
     * @throws SQLException
     */

    List<Order> findAll() throws SQLException;

}
