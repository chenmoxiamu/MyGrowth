package com.java2007.xiazhaodong.hotel.controller;

import com.java2007.xiazhaodong.hotel.constant.ServletConstant;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 基础的Controller
 * 其它Controller通过继承此类达到代码优化的目的
 * @Author AzureSky_X
 * @Date 2021/1/22 16:58
 * @Version 1.0
 */

public class BaseController extends HttpServlet {
    //无论什么方式的请求都会由service方法处理
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) res;

        try {
            //获取方法对应的字符串
            String methodStr = request.getParameter(ServletConstant.METHOD);
            //得到class对象
            Class clazz=this.getClass();
            //通过Method对象获clazz的所有方法
            Method method=clazz.getMethod(methodStr,HttpServletRequest.class,HttpServletResponse.class);
            //根据传入的字符串调取对应的方法
            Object object=method.invoke(this,request,response);

            if (object!=null){
                if (object instanceof String){
                    String result= (String) object;
                    String url=null;
                    //判断是转发还是重定向，还是直接响应字符串
                    if (result.startsWith(ServletConstant.PRE_FORWARD)){
                        //转发：forward
                        //substring包头不包尾
                        url=result.substring(result.indexOf(ServletConstant.TAG)+1);
                        request.getRequestDispatcher(url).forward(request,response);

                    }else if(result.startsWith(ServletConstant.PRE_REDIRECT)){
                        //重定向: redirect:
                        url = result.substring(result.indexOf(ServletConstant.TAG) + 1);
                        response.sendRedirect(request.getContextPath() + url);
                    } else {
                        //其他: 直接响应字符串
                        response.getWriter().write(result);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(ServletConstant.COMMON_ERROR_MESSAGE);
        }


    }
}