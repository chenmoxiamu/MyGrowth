package com.java2007.xiazhaodong.hotel.controller.backend;

import com.java2007.xiazhaodong.hotel.constant.ServletConstant;
import com.java2007.xiazhaodong.hotel.controller.BaseController;
import com.java2007.xiazhaodong.hotel.factory.BeanFactory;
import com.java2007.xiazhaodong.hotel.pojo.Admin;
import com.java2007.xiazhaodong.hotel.service.AdminService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 用户控制层
 * @Author AzureSky_X
 * @Date 2021/1/27 14:17
 * @Version 1.0
 */
@WebServlet("/admin")
public class AdminController extends BaseController {
    private AdminService adminService= (AdminService) BeanFactory.getBean("com.java2007.xiazhaodong.hotel.service.impl.AdminServiceImpl");

    /**
     * 登录功能
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            //接收用户输入的参数
            String adminName=request.getParameter("adminName");
            String password = request.getParameter("password");

            Admin admin = adminService.login(adminName, password);
            //将用户的登录信息存入session
            request.getSession().setAttribute("loginAdmin",admin);
            Admin admin1= (Admin) request.getSession().getAttribute("loginAdmin");
            String role=admin1.getRole();
            if (role.equals("0")){
                return ServletConstant.PRE_REDIRECT+"/backend/index.jsp";
            }else {
                return ServletConstant.PRE_REDIRECT+"front?method=findTableByStatus";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("loginFailMsg",e.getMessage());
            return ServletConstant.PRE_FORWARD+"/backend/login.jsp";
        }

    }

    /**
     *登出
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //销毁session
        request.getSession().invalidate();

        return ServletConstant.PRE_REDIRECT+"/backend/login.jsp";
    }
}
