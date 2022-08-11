package com.service;

import com.entity.Manager;

public interface ManagerService {
    //登录
    public Manager login(String username,String password);
}
