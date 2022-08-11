package com.service.impl;

import com.dao.EmpDao;
import com.dao.impl.EmpDaoImpl;
import com.entity.Emp;
import com.service.EmpService;
import com.utils.DbUtils;

import java.util.List;

public class EmpServiceImpl  implements EmpService {
    //调用逻辑
    public EmpDao empDao=new EmpDaoImpl();
    @Override
    public List<Emp> showAllEmp() {
        List<Emp> emps=null;
        try {
            DbUtils.begin();
            List<Emp> empList=empDao.selectAll();
            if(empList!=null){
                emps=empList;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public int removeEmp(int id) {
        int result=0;
        try {
            DbUtils.begin();
            result=empDao.delete(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Emp showID(int id) {
        Emp emp=null;
        try {
            DbUtils.begin();
            emp=empDao.select(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public int modify(Emp emp) {
        int modify=0;
        try {
            DbUtils.begin();
            modify=empDao.update(emp);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return modify;
    }
}
