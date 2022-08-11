package com.controller;

import com.service.EmpService;
import com.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delete", value = "/delete")
public class delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取参数id
        Integer id=Integer.valueOf(request.getParameter("id"));
        //调用业务逻辑
        EmpService empService=new EmpServiceImpl();
        empService.removeEmp(id);
        response.sendRedirect("/empShow");
    }
}
