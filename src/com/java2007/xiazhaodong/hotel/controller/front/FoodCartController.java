package com.java2007.xiazhaodong.hotel.controller.front;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.java2007.xiazhaodong.hotel.constant.ServletConstant;
import com.java2007.xiazhaodong.hotel.controller.BaseController;
import com.java2007.xiazhaodong.hotel.entity.CartItem;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.service.CartService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 餐车控制层
 * @Author AzureSky_X
 * @Date 2021/1/27 21:27
 * @Version 1.0
 */
@WebServlet("/foodcart")
public class FoodCartController extends BaseController {
    private CartService cartService= (CartService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.CartServiceImpl");

    /**
     * 结账后删除餐车内的菜品
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String deleteByFoodId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session=request.getSession();
        List<CartItem> cart= (List<CartItem>) session.getAttribute("front_cart");
        if (cart==null || cart.size()<= 0){
            return "购物车或菜品不存在";
        }
        String foodIdStr = request.getParameter("foodId");
        int foodId=Integer.parseInt(foodIdStr);
        for (CartItem cartItem : cart) {
            if (cartItem.getFoodId().intValue() == foodId){
                cart.remove(cartItem);
                break;
            }
        }

        //计算总价
        Long cartTotalPrice=0L;
        for (CartItem cartItem :
                cart) {
            cartTotalPrice += cartItem.getTotalPrice();
        }
        session.setAttribute("front_cart",cart);
        session.setAttribute("cart_totle_price",cartTotalPrice);
        Map<String ,Object> map=new HashMap<>();
        map.put("tprice",cartTotalPrice);
        map.put("success",true);
        String json= JSON.toJSONString(map);
        return  json;

    }

    /**
     * 放入餐车
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session=request.getSession();
        //接收参数
        String foodIdStr=request.getParameter("foodId");
        String numStr=request.getParameter("num");

        if (!StringUtils.isEmpty(foodIdStr)&&!StringUtils.isEmpty(numStr)){
            List<CartItem> cart = (List<CartItem>) session.getAttribute("front_cart");
            //没有餐车就创建，有就直接使用
            if (null==cart){
                cart=new ArrayList<>();

            }
            //String to int
            int foodId=Integer.parseInt(foodIdStr);
            int num = Integer.parseInt(numStr);

            cart = cartService.add(foodId, num, cart);
            session.setAttribute("front_cart",cart);
            //计算总价
            Long cartTotalPrice=0L;
            for (CartItem cartItem:cart){
                cartTotalPrice+=cartItem.getTotalPrice();
            }
            session.setAttribute("cart_total_price",cartTotalPrice);
            return ServletConstant.PRE_FORWARD+"/front/detail/clientCart.jsp";


        }else{
            return "想吃菜就别捣蛋";
        }



    }

    }
