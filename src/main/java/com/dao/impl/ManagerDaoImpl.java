package com.dao.impl;

import com.dao.ManagerDao;
import com.entity.Manager;
import com.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ManagerDaoImpl implements ManagerDao {
    //定义一个查询模块
    private QueryRunner queryRunner=new QueryRunner();
    @Override
    public Manager select(String username) {
        try {
            DbUtils.begin();
            Manager manager=  queryRunner.query(DbUtils.getConnection(),"select * from empmanager where username=?;",
                      new BeanHandler<Manager>(Manager.class),username);
            DbUtils.commit();
            return  manager;
        } catch (SQLException e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return null;
    }
}
