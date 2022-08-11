package com.controller;

import com.entity.Manager;
import com.service.ManagerService;
import com.service.impl.ManagerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "managerController", value = "/managerController")
public class managerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //设置统一的编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf8");
        //收参
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String verify=request.getParameter("verify");
        //获取验证码
        String codes=(String) request.getSession().getAttribute("verify");
        if(!verify.isEmpty()&&verify.equalsIgnoreCase(codes)){
            //调用业务逻辑
            ManagerService managerService=new ManagerServiceImpl();
            Manager manager= managerService.login(username,password);
            if (manager != null) {
                HttpSession session=request.getSession();
                session.setAttribute("manager",manager);
                response.sendRedirect(request.getContextPath()+"/empShow");
            }else{
                response.sendRedirect(request.getContextPath()+"/manager.html");
            }
        }else{
            response.sendRedirect(request.getContextPath()+"/manager.html");
        }

    }
}
