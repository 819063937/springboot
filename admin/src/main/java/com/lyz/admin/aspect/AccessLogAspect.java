package com.lyz.admin.aspect;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Component;

import com.lyz.admin.annotation.AccessLog;

/**
 * @description:
 * @author: lyz
 * @date: 2024/2/4 13:06
 */
@Component
@Aspect
public class AccessLogAspect {
    private static ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>(), new CustomizableThreadFactory("AccessLogAspect-pool-"));

    @Pointcut("@annotation(com.lyz.admin.annotation.AccessLog)")
    public void recordLog() {

    }

    @Around("recordLog()")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        AccessLog accessLog = method.getAnnotation(AccessLog.class);
        Object result = point.proceed(point.getArgs());
        return result;
    }
}
