package com.dao;

import com.entity.Emp;

import java.util.List;

public interface EmpDao {
    //查询所有
    public List<Emp> selectAll();
    //删除
    public int delete(int id);
    //查询id防止被修改
    public Emp select(int id);
    //修改
    public int update(Emp emp);
}
