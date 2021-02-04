package com.java2007.xiazhaodong.hotel.service.impl;


import com.alibaba.druid.util.StringUtils;
import com.java2007.xiazhaodong.hotel.dao.FoodDao;
import com.java2007.xiazhaodong.hotel.dao.FoodTypeDao;
import com.java2007.xiazhaodong.hotel.pojo.Food;
import com.java2007.xiazhaodong.hotel.pojo.FoodType;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.service.FoodTypeService;
import com.java2007.xiazhaodong.hotel.utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/1/19 20:20
 * @Version 1.0
 */
public class FoodTypeServiceImpl implements FoodTypeService {
    //原先直接创建对象，写死了
    //private FoodTypeDao foodTypeDao=new FoodTypeDaoImpl();

    //现在改由工厂创建对象

    //private FoodTypeDao foodTypeDao =
    //        (FoodTypeDao) BeanFactory.getInstance("foodtypeDao",FoodTypeServiceImpl.class);
    private FoodTypeDao foodTypeDao =
            (FoodTypeDao) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.dao.impl.FoodTypeDaoImpl");
    private FoodDao foodDao= (FoodDao) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.dao.impl.FoodDaoImpl");
    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<FoodType> findAll() throws SQLException {
        return foodTypeDao.findAll();
    }

    /**
     * 根据菜类别名称查询
     *
     * @param keyword
     * @return
     */
    @Override
    public List<FoodType> findByTypeName(String keyword) throws SQLException {

        if (StringUtils.isEmpty(keyword)) {
            keyword = "";
        } else {
            keyword = keyword.trim();
        }

        //keyword 肯定有值的   ""或者 ："湘菜"
        return foodTypeDao.findByTypeName("%" + keyword + "%");

    }

    /**
     * 根据typeId删除
     *
     * @param typeId
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteByTypeId(Integer typeId) throws SQLException {

        try {
            //开启事务
            DbUtils.begin();

            foodTypeDao.deleteByTypeId(typeId);

            //提交事务
            DbUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            DbUtils.rollback();
            return 0;
        }

        return 1;
    }

    /**
     * 增加
     * @param foodName
     * @return
     * @throws SQLException
     */
    @Override
    public int save(String foodName) throws SQLException {

        try {
            //开启事务
            DbUtils.begin();

            foodTypeDao.save(foodName.trim());

            //提交事务
            DbUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            DbUtils.rollback();
            return 0;
        }

        return 1;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public FoodType findByTypeId(int id) throws SQLException {

        return foodTypeDao.findByTypeId(id);
    }

    /**
     * 更新
     *
     * @param foodType
     * @return
     * @throws SQLException
     */
    @Override
    public int update(FoodType foodType) throws SQLException {
        try {
            //开启事务
            DbUtils.begin();

            foodTypeDao.update(foodType);

            //提交事务
            DbUtils.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            DbUtils.rollback();
            return 0;
        }

        return 1;
    }
    /**
     * 校验菜类别名是否存在
     *  0：不存在
     *  1：存在
     * @param newFoodTypeName
     * @return
     */
    @Override
    public int checkFoodTypeName(String newFoodTypeName) {
        int result=0;
        try {
            DbUtils.begin();
            FoodType foodType=foodTypeDao.findFoodTypeByName(newFoodTypeName);
            if (foodType!=null){
                result=1;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return result;
    }
    /**
     * 根据菜类别id查找菜品
     * @return
     * @throws SQLException
     */
    @Override
    public int findByFoodTypeId(int typeId) throws SQLException {
        int result=0;
        if (foodDao.findByFoodTypeId(typeId)!=null){
            result=1;
        }

        return result;
    }


}
