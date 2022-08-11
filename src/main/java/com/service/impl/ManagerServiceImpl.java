package com.service.impl;

import com.dao.ManagerDao;
import com.dao.impl.ManagerDaoImpl;
import com.entity.Manager;
import com.service.ManagerService;
import com.utils.DbUtils;

public class ManagerServiceImpl implements ManagerService {
    //调用逻辑
    public ManagerDao managerDao=new ManagerDaoImpl();
    @Override
    public Manager login(String username, String password) {
        //定义一个空结果
        Manager result=null;
        Manager manager=managerDao.select(username);
        try {
            DbUtils.begin();
            if(manager!=null){
                if(manager.getPassword().equals(password)){
                    result=manager;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
