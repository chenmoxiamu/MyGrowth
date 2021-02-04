package com.java2007.xiazhaodong.hotel.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决中文乱码问题
 * @Author AzureSky_X
 * @Date 2021/1/23 14:16
 * @Version 1.0
 */
@WebFilter("/*")
public class CharsetEncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri=request.getRequestURI();
        //如果是.html文件，.css文件，.js文件，直接放行
        if(uri == null || uri.endsWith(".html") || uri.endsWith(".css") || uri.endsWith(".js")) {
            chain.doFilter(req, resp);
            return;
        }
        //处理响应与请求的乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //放行
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
