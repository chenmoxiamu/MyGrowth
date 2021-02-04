package com.java2007.xiazhaodong.hotel.service;

import com.java2007.xiazhaodong.hotel.pojo.DinnerTable;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 餐桌服务层接口
 * @Author AzureSky_X
 * @Date 2021/1/27 15:41
 * @Version 1.0
 */
public interface DinnerTableService {
    /**
     * 根据餐桌状态查询餐桌信息
     * @param status
     * @return
     * @throws SQLException
     */
    List<DinnerTable> findByStatus(Integer status) throws SQLException;
    /**
     * 查询所有餐桌
     * @return
     * @throws SQLException
     */

    List<DinnerTable> findAll() throws SQLException;

    /**
     * 根据餐桌名模糊查询
     * @param tableName 餐桌名
     * @return
     * @throws SQLException
     */
    List<DinnerTable> findByName(String tableName) throws SQLException;


    /**
     * 根据id删除餐桌
     * @param id
     * @return
     * @throws SQLException
     */

    int deleteById(Integer id) throws SQLException;

    /**
     * 插入餐桌
     * @param dinnerTable
     * @return
     * @throws SQLException
     */
    int save(DinnerTable dinnerTable) throws SQLException;


    DinnerTable findById(int id) throws SQLException;


    /**
     *
     * 更新订单状态
     *  0：空闲   1：已预约
     * @param status 订单状态
     * @return
     * @throws SQLException
     */
    int updateTableStatus(String status, Integer id) throws SQLException;

    /**
     * 校验餐桌名是否存在
     *  0：不存在
     *  1：存在
     * @param newTableName
     * @return
     */
    int checkTableName(String newTableName);

}
