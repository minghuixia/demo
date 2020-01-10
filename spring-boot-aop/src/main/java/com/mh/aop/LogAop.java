package com.mh.aop;

import cn.hutool.json.JSONUtil;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.aop
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/7 15:22
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Aspect
@Component
@Slf4j
public class LogAop {
    private static final String START_TIME = "request-start";

    /**
     * 切入点
     */
    @Pointcut("execution(public * com.mh.controllers.*Controller.*(..))")
    public void log() {
    }

    /**
     * 前置操作
     *
     * @param joinPoint 切入点
     */
    @Before("log()")
    public void beforeLog(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(servletRequestAttributes).getRequest();

        log.info("【请求 URL】：{}", request.getRequestURL());
        log.info("【请求 IP】：{}", request.getRemoteAddr());
        log.info("【请求类名】：{}，【请求方法名】：{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());

        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info("【请求参数】：{}，", JSONUtil.toJsonStr(parameterMap));
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
    }

    /**
     * 环绕操作
     *
     * @param joinPoint 切入点
     */
    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        log.info("【返回值】：{}", JSONUtil.toJsonStr(result));
        return result;
    }

    /**
     * 后置操作
     *
     */
    @AfterReturning("log()")
    public void afterReturningLog() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("【请求耗时】：{}毫秒", end - start);

        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        log.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}",
                userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);
    }

}
