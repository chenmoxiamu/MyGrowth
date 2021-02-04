package com.java2007.xiazhaodong.hotel.controller.backend;

import com.java2007.xiazhaodong.hotel.constant.ServletConstant;
import com.java2007.xiazhaodong.hotel.controller.BaseController;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.DinnerTable;
import com.java2007.xiazhaodong.hotel.pojo.Order;
import com.java2007.xiazhaodong.hotel.pojo.OrderDetail;
import com.java2007.xiazhaodong.hotel.service.DinnerTableService;
import com.java2007.xiazhaodong.hotel.service.OrderDetailService;
import com.java2007.xiazhaodong.hotel.service.OrderService;
import com.java2007.xiazhaodong.hotel.service.impl.OrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/2/1 17:00
 * @Version 1.0
 */
@WebServlet("/orderdetail")
public class OrderDetailController extends BaseController {
    OrderDetailService orderDetailService= (OrderDetailService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.OrderDetailServiceImpl");
    OrderService orderService= (OrderService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.OrderServiceImpl"  );
    DinnerTableService dinnerTableService = (DinnerTableService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.DinnerTableServiceImpl");
    /**
     * 查询所有订单
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findOrderAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Order> orders = orderService.findAll();

        request.setAttribute("orders",orders);

        //餐桌查询
        List<DinnerTable> tables = dinnerTableService.findAll();

        request.setAttribute("tables",tables);
        return ServletConstant.PRE_FORWARD+"/backend/detail/order/order-list.jsp";
    }

    /**
     * 根据orderId查询订单详情
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findOrderDetailAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String idStr = request.getParameter("orderId");

        Long orderId = Long.valueOf(idStr);

        List<OrderDetail> orderDetails = orderDetailService.findById(orderId);

        request.setAttribute("orderDetails",orderDetails);

        //餐桌查询
        List<DinnerTable> tables = dinnerTableService.findAll();

        request.setAttribute("tables",tables);
        return ServletConstant.PRE_FORWARD+"/backend/detail/order/order-detail.jsp";
    }
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

        return ServletConstant.PRE_REDIRECT + "/orderdetail?method=findOrderAll";

    }


}
