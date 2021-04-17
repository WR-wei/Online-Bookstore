package com.curry.web;

import com.curry.pojo.User;
import com.curry.service.UserService;
import com.curry.service.impl.UserServiceImpl;
import com.curry.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author RUIWU
 * @create 2020-11-25 14:38
 */
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过BeanUtils获取对象
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //获取用户输入的验证码
        String code = req.getParameter("code");

        //获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //检查用户名是否存在
        if (token != null && token.equals(code)) {

            userService.registUser(user);
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);

        } else {
            // 把回显信息，保存到Request域中
            req.setAttribute("msg", "验证码错误！！");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过BeanUtils获取对象
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        if (userService.login(user) == null) {

            req.setAttribute("errorMsg", "用户名或者密码不正确！");
            req.setAttribute("username", user.getUsername());

            System.out.println("用户名或者密码不正确！");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }

        req.getSession().setAttribute("user", user);

        req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得当前的session会话
        HttpSession session = req.getSession();

        //销毁session
        session.invalidate();

        //重定向到首页
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取需要删除的用户ID
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        int isSuccess = userService.deleteUser(id);

        if (isSuccess == -1) {
            System.out.println("删除失败！");
        }

        //重定向到当前页
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有的用户信息
        List usersMsg = userService.queryAllUsers();

        //将用户信息保存到request域中
        req.setAttribute("usersMsg", usersMsg);

        //请求转发
        req.getRequestDispatcher("/pages/manager/select_manager.jsp").forward(req, resp);

    }

    //判断用户名是否可用！
    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        boolean existUsername = userService.existsUsername(username);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existUsername", existUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);

    }
}
