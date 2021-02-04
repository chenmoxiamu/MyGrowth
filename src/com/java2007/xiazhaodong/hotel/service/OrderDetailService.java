package com.java2007.xiazhaodong.hotel.service;

import com.java2007.xiazhaodong.hotel.pojo.OrderDetail;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/2/1 16:46
 * @Version 1.0
 */
public interface OrderDetailService {
    /**
     * 根据订单id查询
     * 的订单详情
     * @param id
     * @return
     * @throws SQLException
     */
    List<OrderDetail> findById(Long id) throws SQLException;
}
