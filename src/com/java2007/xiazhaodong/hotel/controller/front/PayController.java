package com.java2007.xiazhaodong.hotel.controller.front;

import com.java2007.xiazhaodong.hotel.constant.ServletConstant;
import com.java2007.xiazhaodong.hotel.controller.BaseController;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 支付控制层
 * @Author AzureSky_X
 * @Date 2021/1/28 21:07
 * @Version 1.0
 */
public class PayController extends BaseController {
    private OrderService orderService = (OrderService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.OrderServiceImpl");

    /**
     * 支付
     * 修改在支付状态，之后要清空订单信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String payMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接收参数
        String orderIdStr = request.getParameter("orderId");
        //线下付钱
        String moneyStr = request.getParameter("money");

        Long orderId=Long.parseLong(orderIdStr);
        //修改订单状态为已支付
        orderService.updateOrderStatus(orderId,1);
        //结账完了，session中相关的订单数据应该清除
        request.getSession().removeAttribute("tableId");
        request.getSession().removeAttribute("orderId");
        request.getSession().removeAttribute("orderDetailList");
        request.getSession().removeAttribute("total_price");

        return ServletConstant.PRE_REDIRECT + "/front?method=findTableByStatus";

    }

    }
