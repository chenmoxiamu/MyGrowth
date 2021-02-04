package com.java2007.xiazhaodong.hotel.service;


import com.java2007.xiazhaodong.hotel.entity.CartItem;

import java.sql.SQLException;
import java.util.List;

/**
 * 餐车接口
 * @Author AzureSky_X
 * @Date 2021/1/27 21:29
 * @Version 1.0
 */
public interface CartService {
    /**
     * 加入餐车
     * @param foodId 菜品id
     * @param num   增加的数量
     * @param cart 原来的餐车
     * @return
     * @throws SQLException
     */
    List<CartItem> add(int foodId, int num, List<CartItem> cart)throws SQLException;
}
