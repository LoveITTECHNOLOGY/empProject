package com.jsp;

import com.entity.Emp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "updatePostJsp", value = "/updatePostJsp")
public class updatePostJsp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //设置统一的编码格式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //接收参数
       Emp emp=(Emp) request.getAttribute("emp");
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8'>");
        printWriter.println("</head>");
        printWriter.println("<form action='/updatePost' method='post'>");
        printWriter.println("编号<input type='text' name='id' readonly value='"+emp.getId()+"'/></br>");
        printWriter.println("姓名<input type='text' name='name' value='"+emp.getName()+"'/></br>");
        printWriter.println("工资<input type='text' name='salary' value='"+emp.getSalary()+"'/></br>");
        printWriter.println("年龄<input type='text' name='age' value='"+emp.getAge()+"'/></br>");
        printWriter.println("<input type='submit' value='修改'/></br>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
