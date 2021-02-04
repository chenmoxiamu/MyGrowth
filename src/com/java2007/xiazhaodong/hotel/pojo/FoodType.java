package com.java2007.xiazhaodong.hotel.pojo;

/**
 * 菜系类别实体类
 * @Author AzureSky_X
 * @Date 2021/1/19 17:17
 * @Version 1.0
 */
public class FoodType {
    private Integer typeId;
    private String typeName;

    public FoodType() {
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
