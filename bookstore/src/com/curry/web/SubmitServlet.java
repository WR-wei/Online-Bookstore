package com.curry.web;

import com.curry.pojo.Cart;
import com.curry.pojo.CartItem;
import com.curry.pojo.Course;
import com.curry.service.CourseService;
import com.curry.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author RUIWU
 * @create 2020-12-01 21:28
 */
public class SubmitServlet extends BaseServlet {

    //提交选课结果
    protected void submit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart myCourse = (Cart) req.getSession().getAttribute("cart");
        Map<Integer, CartItem> map = myCourse.getItems();

        req.getSession().setAttribute("myCourse",myCourse);

        CourseService courseService = new CourseServiceImpl();

        //修改选课人数
        CartItem cartItem;
        Course course;
        int courseStuNum;
        for (Map.Entry<Integer, CartItem> entry : map.entrySet()) {
            cartItem = entry.getValue();
            course = courseService.queryCourseById(cartItem.getId());
            courseStuNum = course.getCourseStuNum();
            course.setCourseStuNum(++courseStuNum);
            courseService.updateCourse(course);
        }

        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
    }

    //查看选课结果
    protected void showCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect(req.getContextPath()+"/pages/course/course.jsp");

    }
}
