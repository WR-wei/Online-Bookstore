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
import java.util.List;
import java.util.Map;
/**
 * @author RUIWU
 * @create 2020-11-25 18:09
 */
public class CourseServlet extends BaseServlet {
    CourseService courseService = new CourseServiceImpl();

    /**
     * 显示全部课程
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Course> courses = courseService.queryCourses();

        req.setAttribute("course", courses);

        req.getRequestDispatcher("/pages/manager/course_manager.jsp").forward(req, resp);
    }

    /**
     * 删除课程
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String str = req.getParameter("value");

        courseService.deleteCourseById(WebUtils.parseInt(str));

        page(req,resp);
    }

    /**
     * 添加图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map value = req.getParameterMap();

        Course course = WebUtils.copyParamToBean(value,new Course());

        courseService.addCourse(course);

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);

        int pageTotalCount = WebUtils.parseInt(req.getParameter("pageTotalCount"),0);

        if (pageTotalCount % pageNo == 0){
            pageNo++;
        }


//        req.getRequestDispatcher("pages/manager/course_manager.jsp").forward(req,resp);
            resp.sendRedirect(req.getContextPath()+"/courseServlet?action=page&pageNo="+pageNo);
    }

    /**
     * 修改课程信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map value = req.getParameterMap();

        Course cour = new Course();

        cour.setCourseId(WebUtils.parseInt(req.getParameter("courseId")));

        Course course = WebUtils.copyParamToBean(value,cour);

        courseService.updateCourse(course);

        page(req,resp);
    }

    /**
     * 分页功能
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
        page.setUrl("courseServlet?action=page");

        //3、保存Page对象到Request域中
        req.setAttribute("page",page);

        //4、请求转发到pages/manager/course_manager.jsp页面
        req.getRequestDispatcher("pages/manager/course_manager.jsp").forward(req,resp);

    }

}










