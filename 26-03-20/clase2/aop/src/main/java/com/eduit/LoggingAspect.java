package com.eduit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

  private final long UMBRAL_TOLERANCIA = 1000;

  @Pointcut("@annotation(com.eduit.PerformanceCheckAble)")
  public void logPerformanceClassWithAnnotation() {
  }

  @Around("logPerformanceClassWithAnnotation()")
  public Object aroundAnnotationAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long inicio = System.currentTimeMillis();

    Object response = proceedingJoinPoint.proceed();

    long tiempoEjecucion = System.currentTimeMillis() - inicio;

    System.out.println("tiempo de ejecucion en ms: " + tiempoEjecucion);

    enviarAlerta(tiempoEjecucion);

    return response;
  }

  private void enviarAlerta(long tiempoEjecucion) {
    if (tiempoEjecucion > UMBRAL_TOLERANCIA) {
      System.out.println("Tiempo de ejecucion por encima de lo aceptable!!!!");
    }
  }
}
