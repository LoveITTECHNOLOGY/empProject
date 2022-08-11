package com.service;

import com.entity.Emp;

import java.util.List;

public interface EmpService {
    //显示全部信息
    public List<Emp> showAllEmp();
    //去除emp
    public int removeEmp(int id);
    //显示id
    public Emp showID(int id);
    //修改
    public int modify(Emp emp);
}
