package com.system.config;

import java.util.Arrays;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import com.system.service.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pojo.system.SysLog;
import pojo.system.SysUser;

@Aspect
@Component
public class WebLogAspect {

    @Autowired
    SysLogService sysLogService;

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    //切入点
    @Pointcut("execution(public * com.*.controller..*.*(..))")//sys的controller
    public void controllerLog() {
    }

    @Before("controllerLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) throws JsonProcessingException {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 记录下请求内容
        logger.info("################URL : " + request.getRequestURL().toString());
        logger.info("################HTTP_METHOD : " + request.getMethod());
        logger.info("################IP : " + request.getRemoteAddr());
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象

        //获取当前用户信息
        SysUser sysUser = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ObjectMapper json = new ObjectMapper();
        //插入日志到数据库
        SysLog sysLog = new SysLog();
        sysLog.setGmtCreate(new Date());
        sysLog.setUserNo(sysUser.getUserNo().longValue());
        sysLog.setRealName(sysUser.getReal_name());
        sysLog.setIp(request.getRemoteAddr());      //ip地址
        sysLog.setOperation("");
        sysLog.setMethod(request.getMethod());      //提交方式
        sysLog.setPath(request.getServletPath());   //访问路径
        sysLog.setContent(json.writeValueAsString(request.getParameterMap()));      //参数名称和参数名称的值
        sysLogService.insertLogInfo(sysLog);
    }
}
