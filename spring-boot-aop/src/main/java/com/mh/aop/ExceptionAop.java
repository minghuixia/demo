package com.mh.aop;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.mh.aop
 * @description:
 * @author: Minghui.Xia
 * @date: Created in 2020/1/7 16:08
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: Minghui.Xia
 */
@Aspect
@Component
@Slf4j
public class ExceptionAop {

    /**
     * 捕获异常切入点
     */
    @Pointcut("execution(public * com.mh.services.*Service.*(..))")
    public void exceptionPointcut() {
    }

    /**
     * 前置操作
     * @param point 切入点
     */
    @Before("exceptionPointcut()")
    public void exceptionBefore(JoinPoint point){

    }

    /**
     * 环绕操作
     *
     * @param point 切入点
     */
    @Around("exceptionPointcut()")
    public Object exceptionAround(ProceedingJoinPoint point) {
        log.info("【请求类名】：{}，【请求方法名】：{}",
                point.getSignature().getDeclaringTypeName(),
                point.getSignature().getName());
        log.info("【请求参数】：{}", JSONUtil.toJsonStr(point.getArgs()));
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            log.error("【环绕操作捕获异常】：", throwable);
        }finally {
            log.info("【返回值】：{}", JSONUtil.toJsonStr(result));
        }
        return result;
    }
}
