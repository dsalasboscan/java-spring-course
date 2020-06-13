package com.eduit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) throws InterruptedException {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    System.out.println("-----------              SIN AOP ---------------------------");
    ejecutarSinAop(context);
    System.out.println();
    System.out.println();

    System.out.println("-----------              CON AOP ---------------------------");
    ejecutarConAop(context);
  }

  private static void ejecutarSinAop(ApplicationContext context) throws InterruptedException {
    ServicioMedibleSinAop servicioMedibleSinAop = context.getBean(ServicioMedibleSinAop.class);

    servicioMedibleSinAop.method1();
    servicioMedibleSinAop.method2();
    servicioMedibleSinAop.method3();
    servicioMedibleSinAop.method4();
  }

  private static void ejecutarConAop(ApplicationContext context) throws InterruptedException {
    ServicioMedibleConAop servicioMedibleConAop = context.getBean(ServicioMedibleConAop.class);

    servicioMedibleConAop.method1();
    servicioMedibleConAop.method2();
    servicioMedibleConAop.method3();
    servicioMedibleConAop.method4();
  }
}
