package com.java2007.xiazhaodong.hotel.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限验证
 * @Author AzureSky_X
 * @Date 2021/2/1 8:51
 * @Version 1.0
 */
@WebFilter(urlPatterns = "/backend/index.jsp,/front/index.jsp", initParams = {
        @WebInitParam(name = "pages", value = "/backend/login.jsp,/backend/login,/backend/register.jsp,/backend/register,/backend/index.jsp,/index")
})
public class AuthorizationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.判断session是否有用户数据?
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //释放登录页面
        if(request.getRequestURI().endsWith("/backend/login.jsp")) {
            chain.doFilter(request, response);
            return;
        }

        Object loginAdmin = request.getSession().getAttribute("loginAdmin");
        if(null == loginAdmin) {
            //3.没有，就放行。重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/backend/login.jsp");
            return;
        }

        //2.有：就放行
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
