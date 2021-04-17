package com.curry.web;

import com.curry.pojo.Course;
import com.curry.pojo.Page;
import com.curry.service.CourseService;
import com.curry.service.impl.CourseServiceImpl;
import com.curry.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RUIWU
 * @create 2020-11-27 14:17
 */
public class ClientServlet extends BaseServlet {

    CourseService courseService = new CourseServiceImpl();

    /**
     * 获取分页信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2、调用BookService.page(pageNo,pageSize):返回Page对象
        Page<Course> page = courseService.page(pageNo,pageSize);
        page.setUrl("clientServlet?action=page");

        //3、保存Page对象到Request域中
        req.setAttribute("page",page);

        //4、请求转发到pages/client/index.jsp页面
        req.getRequestDispatcher("pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByCredit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取请求的参数pageNo、pageSize、min、max
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        double min = WebUtils.parseDouble(req.getParameter("min"), 0);
        double max = WebUtils.parseDouble(req.getParameter("max"), Double.MAX_VALUE);


        //2、调用BookService.pageByCredit(pageNo,pageSize,max,min):返回Page对象
        Page<Course> page = courseService.pageByCredit(pageNo,pageSize,max,min);

        StringBuilder sb = new StringBuilder("clientServlet?action=pageByCredit");

        if (req.getParameter("min") != null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());

        //3、保存Page对象到Request域中
        req.setAttribute("page",page);

        //4、请求转发到pages/client/index.jsp页面
        req.getRequestDispatcher("pages/client/index.jsp").forward(req,resp);
    }
}
