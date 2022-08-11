package com.Filter;

import com.entity.Manager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/empShow")
public class checkFilter  implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //接收参数
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
       Manager manager=(Manager) request.getSession().getAttribute("manager");
       if(manager!=null){
           filterChain.doFilter(request,response);
       }else{
           response.sendRedirect(request.getContextPath()+"/manager.html");
       }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
