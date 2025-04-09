package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* org.example.service.OrderService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("准备执行: " + joinPoint.getSignature().getName() + " 方法");
        System.out.println("参数: ");
        for (Object arg : joinPoint.getArgs()) {
            System.out.println("  " + arg);
        }
    }

    @AfterReturning(pointcut = "execution(* org.example.service.OrderService.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("方法执行完成: " + joinPoint.getSignature().getName());
        System.out.println("返回值: " + result);
    }
}