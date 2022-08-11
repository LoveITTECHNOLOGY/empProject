package com.dao.impl;

import com.dao.EmpDao;
import com.entity.Emp;
import com.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    //创建一个私有查询对象
    private QueryRunner queryRunner=new QueryRunner();
    @Override
    public List<Emp> selectAll() {
        try {
            DbUtils.begin();
            List<Emp> empList=queryRunner.query(DbUtils.getConnection(),"select * from emp;",
                     new BeanListHandler<Emp>(Emp.class));
            DbUtils.commit();
            return empList;
        } catch (SQLException e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(int id) {
        try {
            DbUtils.begin();
            int result=queryRunner.update(DbUtils.getConnection(),"delete from emp where id=?;",id);
            DbUtils.commit();
            return result;
        } catch (SQLException e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Emp select(int id) {
        try {
            DbUtils.begin();
            Emp emp=  queryRunner.query(DbUtils.getConnection(),"select * from emp where id=?;",
                      new BeanHandler<Emp>(Emp.class),id);
            DbUtils.commit();
            return emp;
        } catch (SQLException e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Emp emp) {
        try {
            DbUtils.begin();
            int result=  queryRunner.update(DbUtils.getConnection(),"update emp set name=?,salary=?,age=? where id=?;"
              ,emp.getName(),emp.getSalary(),emp.getAge(),emp.getId());
            DbUtils.commit();
            return result;
        } catch (SQLException e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return 0;
    }
}
