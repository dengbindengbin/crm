package com._520it.crm.util;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.SystemLog;
import com._520it.crm.service.ISystemLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 1 on 2017/7/13.
 */
public class LogAspect {

    @Autowired
    ISystemLogService systemLogService;
     public void writlog(JoinPoint joinPoint) throws JsonProcessingException {
         //创建SystemLog  对象，并未该对象设置属性
         SystemLog log = new SystemLog();
         log.setOpTime(new Date());
         log.setOpUser((Employee) SecurityUtils.getSubject().getPrincipal());
         String function = joinPoint.getTarget().getClass().getName() + ":" + joinPoint.getSignature().getName();
         log.setFunction(function);
         //创建该对象是为将对象转换成字符串
         System.out.println("***************************************");
         ObjectMapper mapper = new ObjectMapper();
         try {
             String paramsStr = mapper.writeValueAsString(joinPoint.getArgs());
             log.setParams(paramsStr);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
         HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
         log.setOpIp(request.getRemoteAddr());
         System.out.println("***************************************");
         systemLogService.insert(log);
         System.out.println("小朋友，你好啊");


     }
}
