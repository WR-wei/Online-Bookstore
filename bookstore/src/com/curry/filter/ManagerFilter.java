package com.curry.filter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author RUIWU
 * @create 2020-12-01 13:27
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        Object user = httpServletRequest.getSession().getAttribute("user");

        if (user == null){
            httpServletRequest.getRequestDispatcher("../user/login.jsp").forward(request,response);
        }else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
