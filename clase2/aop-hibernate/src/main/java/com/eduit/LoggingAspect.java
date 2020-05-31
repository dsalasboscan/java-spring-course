package com.eduit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  @Pointcut("execution(* com.eduit.repository.ProductoRepository.f*(..))")
  public void logRepositoryMethodFindCalls() {}


  @Before("logRepositoryMethodFindCalls()")
  public void beforeAdviceMethod(JoinPoint joinPoint) {
    System.out.println("*************************************************");

    System.out.println("Method Signature " + joinPoint.getSignature().getName());
  }
}
