package com._520it.crm.web.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lanxw on 2017/7/12.
 */
public class BaseController {
    //SpringMVC的统一一样处理
    @ExceptionHandler(UnauthorizedException.class)
    public void handlerException(HandlerMethod method, HttpServletResponse response){
        try {
            if(method!=null){
                System.out.println("*********************************");
                ResponseBody rb = method.getMethodAnnotation(ResponseBody.class);
                //出现异常的时候,需要根据用户的请求类型,做不同的处理
                if(rb==null){
                    //  访问/employee没有权限的时候,重定向到noPermission.jsp页面
                        response.sendRedirect("/noPermission.jsp");
                }else{
                    //  访问/employee/save没有权限的时候,通过response响应JSON数据{"succsss":false,"msg":"您没有权限操作!",rows:[]}
                    response.setCharacterEncoding("utf-8");
                    response.getWriter().write("{\"success\":false,\"msg\":\"您没有权限操作!\",\"rows\":[]}");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
