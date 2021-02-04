package com.java2007.xiazhaodong.hotel.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.java2007.xiazhaodong.hotel.dao.FoodDao;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.Food;
import com.java2007.xiazhaodong.hotel.entity.PageBean;
import com.java2007.xiazhaodong.hotel.service.FoodService;
import com.java2007.xiazhaodong.hotel.utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/1/23 16:44
 * @Version 1.0
 */
public class FoodServiceImpl implements FoodService {
    private FoodDao foodDao = (FoodDao) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.dao.impl.FoodDaoImpl");

    /**
     * 插入菜品业务
     * @param food
     * @return
     * @throws SQLException
     */
    @Override
    public int save(Food food) throws SQLException {
        try {
            DbUtils.begin();
            //价格单位由分转化成元
            food.setPrice(food.getPrice()*100);
            food.setVipPrice(food.getVipPrice()*100);
            foodDao.save(food);
            DbUtils.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback();
            return 0;
        }
        return 1;
    }

    /**
     * 根据ID查询菜品数据
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Food findById(int id) throws SQLException {
        return foodDao.findById(id);
    }

    /**
     * 分页
     * @param pageNo 当前页
     * @param pageSize 页大小：每页几条数据
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Food> findByPage(Integer pageNo, Integer pageSize,Food food) throws SQLException {
        //约束pageNo和pageSize
        if (pageNo<0){
            pageNo=1;
        }
        //查询菜品数据
        List<Food> list=foodDao.findByPage((pageNo-1)*pageSize,pageSize,food);
        //查询菜品数量
        Long count =foodDao.getCount(food);
        PageBean<Food> pageBean=new PageBean<>();
        //当前页
        pageBean.setPageNo(pageNo);
        //页面展示数据
        pageBean.setList(list);
        //总条数
        pageBean.setTotalCount(count);
        //总页数
        pageBean.setTotalPages();
        return pageBean;

    }
    /**
     * 查询所有菜品
     * @return
     * @throws SQLException
     */
    @Override
    public List<Food> findAll() throws SQLException {
        return foodDao.findAll();
    }

    @Override
    public List<Food> findByName(String keyword) throws SQLException {
        if (StringUtils.isEmpty(keyword)) {
            keyword = "";
        } else {
            keyword = keyword.trim();
        }
        return foodDao.findByName("%"+keyword+"%");

    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        try {
            DbUtils.begin();
            foodDao.deleteById(id);
            DbUtils.commit();
        } catch (SQLException e) {

            e.printStackTrace();
            DbUtils.rollback();
        }
        return 1;
    }
    /**
     * 更新
     * @param food
     * @return
     * @throws SQLException
     */
    @Override
    public int update(Food food) throws SQLException {
        try {
            //开启事务
            DbUtils.begin();

            foodDao.update(food);

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

}
