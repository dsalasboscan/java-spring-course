package com.eduit;

import org.springframework.stereotype.Component;

@Component
public class ServicioMedibleConAop {

  @PerformanceCheckAble
  public void method1() {
    System.out.println("Llamado al servicio 1 con aop");
  }

  @PerformanceCheckAble
  public void method2() throws InterruptedException {
    Thread.sleep(2000);
    System.out.println("Llamado al servicio 2 con aop");
  }

  @PerformanceCheckAble
  public void method3() {
    System.out.println("Llamado al servicio 3 con aop");
  }

  @PerformanceCheckAble
  public void method4() {
    System.out.println("Llamado al servicio 4 con aop");
  }
}
