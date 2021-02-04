package com.java2007.xiazhaodong.hotel.controller.front;

import com.java2007.xiazhaodong.hotel.constant.ServletConstant;
import com.java2007.xiazhaodong.hotel.controller.BaseController;
import com.java2007.xiazhaodong.hotel.entity.CartItem;
import com.java2007.xiazhaodong.hotel.entity.Result;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.DinnerTable;
import com.java2007.xiazhaodong.hotel.pojo.Order;
import com.java2007.xiazhaodong.hotel.service.DinnerTableService;
import com.java2007.xiazhaodong.hotel.service.OrderService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 订单控制层
 * @Author AzureSky_X
 * @Date 2021/1/28 20:57
 * @Version 1.0
 */
@WebServlet("/order")
public class OrderController extends BaseController {
    private OrderService orderService = (OrderService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.OrderServiceImpl");
    private DinnerTableService dinnerTableService = (DinnerTableService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.DinnerTableServiceImpl");

    /**
     * 生成订单
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String generatorOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Integer tableId = (int) session.getAttribute("tableId");

        List<CartItem> cart = (List<CartItem>) session.getAttribute("front_cart");

        if(null == cart || cart.size() <= 0){
            return "您没有选择要吃的菜";
        }

        Long cartTotalPrice = (Long) session.getAttribute("cart_total_price");

        Result result = orderService.generatorOrder(cart, cartTotalPrice, tableId);
        //获取Result中传递的数据
        Map<String,Object> orderInfo = (Map<String, Object>) result.getData();

        session.setAttribute("orderId", orderInfo.get("orderId"));
        session.setAttribute("order_detail_list", orderInfo.get("orderDetailList"));
        session.setAttribute("order_total_price", orderInfo.get("total_price"));

        //清空餐车中的数据
        session.removeAttribute("front_cart");
        session.removeAttribute("cart_total_price");

        return ServletConstant.PRE_REDIRECT + "/front/detail/clientOrderList.jsp";


    }

    /**
     * 查询所有订单
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Order> orders=orderService.findAll();
        List<DinnerTable> tables = dinnerTableService.findAll();
        request.setAttribute("tables", tables);
        request.setAttribute("orders",orders);
        return ServletConstant.PRE_FORWARD+ "/backend/detail/order/order-list.jsp";

    }

}
