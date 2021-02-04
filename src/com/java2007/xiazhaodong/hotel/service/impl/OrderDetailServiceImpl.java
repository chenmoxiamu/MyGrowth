package com.java2007.xiazhaodong.hotel.service.impl;

import com.java2007.xiazhaodong.hotel.dao.OrderDao;
import com.java2007.xiazhaodong.hotel.dao.OrderDetailDao;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.OrderDetail;
import com.java2007.xiazhaodong.hotel.service.OrderDetailService;
import com.java2007.xiazhaodong.hotel.service.OrderService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/2/1 16:47
 * @Version 1.0
 */
public class OrderDetailServiceImpl  implements OrderDetailService {
    OrderDetailDao orderDetailDao= (OrderDetailDao) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.dao.impl.OrderDetailDaoImpl");
    /**
     * 根据订单id查询
     * 的订单详情
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public List<OrderDetail> findById(Long id) throws SQLException {

        return orderDetailDao.findById(id);
    }
}
