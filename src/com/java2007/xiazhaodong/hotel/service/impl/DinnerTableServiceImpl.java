package com.java2007.xiazhaodong.hotel.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.java2007.xiazhaodong.hotel.dao.DinnerTableDao;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.DinnerTable;
import com.java2007.xiazhaodong.hotel.service.DinnerTableService;
import com.java2007.xiazhaodong.hotel.utils.DbUtils;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/1/27 15:41
 * @Version 1.0
 */
public class DinnerTableServiceImpl implements DinnerTableService {
    DinnerTableDao dinnerTableDao= (DinnerTableDao) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.dao.impl.DinnerTableDaoImpl");
    /**
     * 根据餐桌状态查询餐桌信息
     * @param status
     * @return
     * @throws SQLException
     */
    @Override
    public List<DinnerTable> findByStatus(Integer status) throws SQLException {
        return dinnerTableDao.findByStatus(status);
    }
    /**
     * 查询所有餐桌
     * @return
     * @throws SQLException
     */
    @Override
    public List<DinnerTable> findAll() throws SQLException {
        return dinnerTableDao.findAll();
    }
    /**
     * 根据餐桌名模糊查询
     * @param keyword 搜索关键字
     * @return
     * @throws SQLException
     */
    @Override
    public List<DinnerTable> findByName(String keyword) throws SQLException {

        if (StringUtils.isEmpty(keyword)) {
            keyword = "";
        } else {
            keyword = keyword.trim();
        }
        return dinnerTableDao.findByName("%"+keyword+"%");
    }
    /**
     * 根据id删除餐桌
     * @param id
     * @return
     * @throws SQLException
     */

    @Override
    public int deleteById(Integer id) throws SQLException {
        try {
            DbUtils.begin();
            dinnerTableDao.deleteById(id);
            DbUtils.commit();
        } catch (SQLException e) {

            e.printStackTrace();
            DbUtils.rollback();
        }
        return 1;
    }
    /**
     * 插入餐桌
     * @param dinnerTable
     * @return
     * @throws SQLException
     */
    @Override
    public int save(DinnerTable dinnerTable) throws SQLException {
        try {
            DbUtils.begin();
            dinnerTableDao.save(dinnerTable);

            DbUtils.commit();
        } catch (SQLException e) {

            e.printStackTrace();
            DbUtils.rollback();
        }
        return 1;
    }

    @Override
    public DinnerTable findById(int id) throws SQLException {
        return null;
    }

    /**
     *
     * 更新订单状态
     *  0：空闲   1：已预订
     * @param status 订单状态
     * @return
     * @throws SQLException
     */

    @Override
    public int updateTableStatus(String status, Integer id) throws SQLException {
        try {
            DbUtils.begin();
            //根据当前餐桌的状态修改
            if (status.equals("1")){//点击退桌
                dinnerTableDao.updateTableStatus("0",id);
                //退订就插入空的时间
                dinnerTableDao.updateReservationTime(null,id);
            }else if (status.equals("0")){//点击预订
                dinnerTableDao.updateTableStatus("1",id);
                //预订就插入当前时间
                dinnerTableDao.updateReservationTime(new Date(),id);
            }

            DbUtils.commit();
        } catch (SQLException e) {

            e.printStackTrace();
            DbUtils.rollback();
        }
        return 1;
    }
    /**
     * 校验餐桌名是否存在
     *  0：不存在
     *  1：存在
     * @param newTableName
     * @return
     */
    @Override
    public int checkTableName(String newTableName) {
        int result=0;
        try {
            DbUtils.begin();
            DinnerTable dinnerTable=dinnerTableDao.findTableByName(newTableName);
            if (dinnerTable!=null){
                result=1;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return result;
    }
}
