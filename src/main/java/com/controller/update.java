package com.controller;

import com.entity.Emp;
import com.service.EmpService;
import com.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "update", value = "/update")
public class update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置统一的编码格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
           //获取id
        Integer id=Integer.valueOf(request.getParameter("id"));
        //调用业务逻辑 查询修改的id防止被修改
        EmpService empService=new EmpServiceImpl();
        Emp emp=(Emp) empService.showID(id);
        //传值
        request.setAttribute("emp",emp);
        //发送到要修改的页面
       request.getRequestDispatcher("/updatePostJsp").forward(request,response);
    }
}
