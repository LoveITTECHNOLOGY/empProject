package com.validate;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "verify", value = "/verify")
public class verify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //create a validate code
        ValidateCode validateCode=new ValidateCode(300,10,4,30);
        //获取验证码
        String verify=validateCode.getCode();
        System.out.println(verify);
        HttpSession session=request.getSession();
        session.setAttribute("verify",verify);


        //写入输出流
        validateCode.write(response.getOutputStream());
    }
}
