package com.java2007.xiazhaodong.hotel.pojo;

import java.sql.Date;

/**
 * 菜品实体类
 * @Author AzureSky_X
 * @Date 2021/1/22 19:58
 * @Version 1.0
 */
public class Food {
    //菜品id
    private Integer foodId;
    //菜类别id
    private Integer typeId;
    //菜名
    private String foodName;
    //菜品价格
    private Long    price;
    //会员菜品价格
    private Long vipPrice;
    //菜品图片
    private String image;
    //菜品描述
    private String  foodDesc;
    //菜品创建时间
    private Date    food_create_time;
    //菜品更新时间
    private Date    food_update_time;
    //创建者
    private Integer admin_id;

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Long vipPrice) {
        this.vipPrice = vipPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public Date getFood_create_time() {
        return food_create_time;
    }

    public void setFood_create_time(Date food_create_time) {
        this.food_create_time = food_create_time;
    }

    public Date getFood_update_time() {
        return food_update_time;
    }

    public void setFood_update_time(Date food_update_time) {
        this.food_update_time = food_update_time;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }
}
