package com.curry.web;

import com.curry.pojo.Cart;
import com.curry.pojo.CartItem;
import com.curry.pojo.Course;
import com.curry.service.CourseService;
import com.curry.service.impl.CourseServiceImpl;
import com.curry.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RUIWU
 * @create 2020-11-30 10:59
 */
public class CartServlet extends BaseServlet {

    private CourseService courseService = new CourseServiceImpl();

    //添加课程到选课列表
    protected void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        req.getSession().setAttribute("alreadyAdd","");

        Course course = courseService.queryCourseById(id);

        CartItem cartItem = new CartItem(course.getCourseId(), course.getCourseName(),
                course.getCourseTeacher(), course.getCourseCredit(), course.getCourseStuNum());


        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        int isSuccess = cart.addItem(cartItem);

        if (isSuccess == 1){
            req.getSession().setAttribute("lastCourse",course.getCourseName());
            resp.sendRedirect(req.getHeader("Referer"));
        }else {
            req.getSession().setAttribute("alreadyAdd",course.getCourseName());
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        //获得选课列表
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            //删除指定课程
            cart.delete(id);

            resp.sendRedirect(req.getHeader("referer"));
        }


    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得选课列表
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            //删除指定课程
            cart.clear();

            resp.sendRedirect(req.getHeader("referer"));
        }


    }
}
