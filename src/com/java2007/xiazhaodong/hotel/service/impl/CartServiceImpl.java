package com.java2007.xiazhaodong.hotel.service.impl;

import com.java2007.xiazhaodong.hotel.dao.FoodDao;
import com.java2007.xiazhaodong.hotel.dao.impl.FoodDaoImpl;

import com.java2007.xiazhaodong.hotel.entity.CartItem;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.Food;
import com.java2007.xiazhaodong.hotel.service.CartService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 餐车业务层接口
 * @Author AzureSky_X
 * @Date 2021/1/27 21:30
 * @Version 1.0
 */
public class CartServiceImpl implements CartService {
    private FoodDao foodDao= (FoodDao) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.dao.impl.FoodDaoImpl");
    /**
     * 加入餐车
     * @param foodId 菜品id
     * @param num   增加的数量
     * @param cart 原来的餐车
     * @return
     * @throws SQLException
     */
    @Override
    public List<CartItem> add(int foodId, int num, List<CartItem> cart) throws SQLException {
     
        //约束数量
        if (num<=0){
            throw new RuntimeException("数量必须是正整数");
        }
        //判断加入的菜品是否在餐车中已存在
        for(CartItem cartItem:cart){
            if (cartItem.getFoodId().intValue()==foodId){
                //存在就更新数量、价格、更新时间
                cartItem.setNum(cartItem.getNum()+num);
                if (cartItem.getNum()<=0){
                    //数量<=0，就不该出现在餐车里
                    cart.remove(cartItem);
                }
                //总价=更新后的价格*菜品单价
                cartItem.setTotalPrice(cartItem.getNum()*cartItem.getPrice());
                cartItem.setUpdateTime(new Date());
                return cart;

            }
        }
        //菜品在餐车中不存在
        Food food = foodDao.findById(foodId);
        //将菜品添加进新的餐车项中
        CartItem cartItem=new CartItem();
        cartItem.setFoodId(foodId);
        cartItem.setNum(num);
        cartItem.setFoodName(food.getFoodName());
        cartItem.setPrice(food.getPrice());
        cartItem.setTotalPrice(cartItem.getPrice() * cartItem.getNum());
        cartItem.setCreateTime(new Date());
        cartItem.setUpdateTime(new Date());
        //将餐车项加入餐车
        cart.add(cartItem);


        return cart;
    }
}
