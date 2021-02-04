package com.java2007.xiazhaodong.hotel.service.impl;

import com.java2007.xiazhaodong.hotel.dao.OrderDao;
import com.java2007.xiazhaodong.hotel.dao.OrderDetailDao;
import com.java2007.xiazhaodong.hotel.entity.CartItem;
import com.java2007.xiazhaodong.hotel.entity.Result;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.Order;
import com.java2007.xiazhaodong.hotel.pojo.OrderDetail;
import com.java2007.xiazhaodong.hotel.service.OrderService;
import com.java2007.xiazhaodong.hotel.utils.DbUtils;

import java.sql.SQLException;
import java.util.*;

/**
 * 订单业务实现类
 * @Author AzureSky_X
 * @Date 2021/1/28 19:06
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = (OrderDao) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.dao.impl.OrderDaoImpl");
    private OrderDetailDao orderDetailDao = (OrderDetailDao) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.dao.impl.OrderDetailDaoImpl");

    /**
     * 创建订单
     * @param cart     餐车数据
     * @param cartTotalPrice  餐车中菜品总价
     * @param tableId  餐桌id
     * @return
     */
    @Override
    public Result generatorOrder(List<CartItem> cart, Long cartTotalPrice, Integer tableId) {


        try {
            DbUtils.begin();
            //生成订单数据
            Order order=new Order();
            //订单编号为当前系统时间的毫秒值
            order.setId(System.currentTimeMillis());
            order.setTableId(tableId);//没有
            //订单总价
            order.setTotalPrice(cartTotalPrice);
            //支付状态 0：未支付 1：已支付 2：已取消
            order.setPayStatus(0);
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            //订单创建者，需要先登录
            order.setCreateUser(1);


            //保存订单
            orderDao.save(order);
            Thread.sleep(20);

            //获取List<CartItem> -->  每个CartItem就是OrderDetail
            //保存订单详情
            List<OrderDetail> orderDetailList = new ArrayList<>();

            for (CartItem cartItem : cart) {
                OrderDetail orderDetail = cartItem;
                orderDetail.setId(System.currentTimeMillis());
                orderDetail.setOrderId(order.getId());
                Thread.sleep(20);
                orderDetailDao.save(orderDetail);
                //订单详情列表
                orderDetailList.add(orderDetail);
            }

            DbUtils.commit();

            Map<String, Object> orderInfo = new HashMap<>();
            orderInfo.put("orderId", order.getId());
            orderInfo.put("total_price", order.getTotalPrice());
            orderInfo.put("orderDetailList", orderDetailList);

            return Result.ok("订单创建成功", orderInfo);
        } catch (Exception e) {
            e.printStackTrace();
            DbUtils.rollback();
            return Result.fail("创建订单失败");
        }



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
        return orderDao.updateOrderStatus(orderId, status);
    }

    @Override
    public List<Order> findAll() throws SQLException {
        return orderDao.findAll();
    }
}
