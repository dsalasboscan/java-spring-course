package com.eduit.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.eduit.repository.ProductRepository.f*(..))")
    public void logRepositoryMethodFindCalls() {}

    @Pointcut("@annotation(com.eduit.config.aop.PerformanceCheckAble)")
    public void logPerformanceClassWithAnnotation() {}

    @Before("logRepositoryMethodFindCalls()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        System.out.println("");
        System.out.println("*************************************************");

        System.out.println("Method Signature " + joinPoint.getSignature().getName());
    }

    @Around("logPerformanceClassWithAnnotation()")
    public Object aroundAnnotationAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("");
        long start = System.currentTimeMillis();

        System.out.println("Printing save parameter " + Arrays.toString(proceedingJoinPoint.getArgs()));

        Object response = proceedingJoinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println("Saving in database " + proceedingJoinPoint.getSignature().getName() + " executed in " + executionTime + "ms");

        return response;
    }


}
