package com.controller;

import com.entity.Emp;
import com.service.EmpService;
import com.service.impl.EmpServiceImpl;

import javax.naming.InsufficientResourcesException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updatePost", value = "/updatePost")
public class updatePost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置统一的编码格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
           //收参
        Integer id=Integer.valueOf(request.getParameter("id"));
        String name=String.valueOf(request.getParameter("name"));
        Double salary=Double.valueOf(request.getParameter("salary"));
        Integer age=Integer.valueOf(request.getParameter("age"));
        //实例化
        Emp emp=new Emp(id,name,salary,age);
        //调用业务逻辑
        EmpService empService=new EmpServiceImpl();
        empService.modify(emp);
        //跳转到用户控制页面
        response.sendRedirect("/empShow");
    }
}
