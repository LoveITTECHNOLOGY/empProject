package com.dao;

import com.entity.Manager;

public interface ManagerDao {
    //单个查询
    public Manager select(String username);
}
