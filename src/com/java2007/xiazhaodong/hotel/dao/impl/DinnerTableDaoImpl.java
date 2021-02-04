package com.java2007.xiazhaodong.hotel.dao.impl;

import com.java2007.xiazhaodong.hotel.dao.DinnerTableDao;
import com.java2007.xiazhaodong.hotel.pojo.DinnerTable;
import com.java2007.xiazhaodong.hotel.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @Author AzureSky_X
 * @Date 2021/1/27 16:00
 * @Version 1.0
 */
public class DinnerTableDaoImpl implements DinnerTableDao {
    QueryRunner queryRunner=new QueryRunner();
    /**
     * 根据餐桌状态查询餐桌
     * @param status
     * @return
     * @throws SQLException
     */
    @Override
    public List<DinnerTable> findByStatus(Integer status) throws SQLException {
        String sql = "SELECT `id`,`table_name` tableName,`status`,`reservation_time` reservationTime,`create_time` createTime,`update_time` updateTime,`create_user` createUser FROM `t_dinner_table` WHERE `status` = ?";
        return queryRunner.query(DbUtils.getConnection(),sql,new BeanListHandler<>(DinnerTable.class),status);
    }
    /**
     * 查询所有餐桌
     * @return
     * @throws SQLException
     */
    @Override
    public List<DinnerTable> findAll() throws SQLException {
        String sql="select id,table_name tableName,status,reservation_time reservationTime ,update_time updateTime  from t_dinner_table";

        return queryRunner.query(DbUtils.getConnection(),sql,new BeanListHandler<>(DinnerTable.class));

    }
    /**
     * 根据餐桌名模糊查询餐桌信息
     * @param tableName 餐桌名
     * @return
     * @throws SQLException
     */
    @Override
    public List<DinnerTable> findByName(String tableName) throws SQLException {
        String sql ="select id,table_name tableName,status,reservation_time reservationTime ,create_time createTime,update_time updateTime  from t_dinner_table where table_name LIKE ? ";

        return queryRunner.query(DbUtils.getConnection(),sql,new BeanListHandler<>(DinnerTable.class),tableName);
    }

    /**
     * 根据id删除餐桌
     * @param id
     * @return
     * @throws SQLException
     */

    @Override
    public int deleteById(Integer id) throws SQLException {
        String sql="delete from t_dinner_table where id=?";
        return queryRunner.update(DbUtils.getConnection(),sql,id);
    }
    /**
     * 插入餐桌
     * 只要插入table_name新桌的名字
     * @param dinnerTable
     * @return
     * @throws SQLException
     */
    @Override
    public int save(DinnerTable dinnerTable) throws SQLException {
        String sql ="insert into  t_dinner_table (table_name,status,create_time,update_time,create_user )values(?,?,?,?,?)";
        return queryRunner.update(DbUtils.getConnection(),sql,dinnerTable.getTableName(),dinnerTable.getStatus(),
            dinnerTable.getCreateTime(),dinnerTable.getUpdateTime(),dinnerTable.getCreateUser()
        );
    }

    /**
     * 根据id查找餐桌
     * 似乎没用，暂时不写
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public DinnerTable findById(int id) throws SQLException {
        return null;
    }
    /**
     *
     * 更新订单状态
     * @param status 订单状态
     * @return
     * @throws SQLException
     */
    @Override
    public int updateTableStatus(String status,Integer id) throws SQLException {
        String sql ="update t_dinner_table set status=?  where id=? ";
        return queryRunner.update(DbUtils.getConnection(),sql,status,id);
    }
    /**
     * 更新餐桌预订时间
     * @param reservationTime   预订时间
     * @return
     * @throws SQLException
     */
    @Override
    public int updateReservationTime(Date reservationTime,int  id) throws SQLException {
        String sql="update t_dinner_table set reservation_time=? where id=?";
        return queryRunner.update(DbUtils.getConnection(),sql,reservationTime,id);
    }
    /**
     * 检测餐桌名是否存在
     * 不能用模糊查询
     * @param newTableName 餐桌名
     * @return 餐桌对象
     */
    @Override
    public DinnerTable findTableByName(String newTableName) throws SQLException {
        String sql ="select id,table_name tableName,status,reservation_time reservationTime ,create_time createTime,update_time updateTime  from t_dinner_table where table_name = ? ";

        return queryRunner.query(DbUtils.getConnection(),sql,new BeanHandler<>(DinnerTable.class),newTableName);
    }


}
