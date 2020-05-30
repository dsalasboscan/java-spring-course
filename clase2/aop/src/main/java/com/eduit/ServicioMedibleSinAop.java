package com.eduit;

import org.springframework.stereotype.Component;

@Component
public class ServicioMedibleSinAop {

  private final long UMBRAL_TOLERANCIA = 1000;

  public void method1() {
    long inicio = System.currentTimeMillis();
    
    System.out.println("LLamando al servicio 1 sin aop");

    long tiempoEjecucion = System.currentTimeMillis() - inicio;

    System.out.println("tiempo de ejecucion en ms: " + tiempoEjecucion);

    enviarAlerta(tiempoEjecucion);
  }

  public void method2() throws InterruptedException {
    long inicio = System.currentTimeMillis();

    System.out.println("LLamando al servicio 2 sin aop");

    Thread.sleep(2000);

    long tiempoEjecucion = System.currentTimeMillis() - inicio;

    System.out.println("tiempo de ejecucion en ms: " + tiempoEjecucion);

    enviarAlerta(tiempoEjecucion);
  }

  public void method3() {
    long inicio = System.currentTimeMillis();

    System.out.println("LLamando al servicio 3 sin aop");

    long tiempoEjecucion = System.currentTimeMillis() - inicio;

    System.out.println("tiempo de ejecucion en ms: " + tiempoEjecucion);

    enviarAlerta(tiempoEjecucion);

  }

  public void method4() {
    long inicio = System.currentTimeMillis();

    System.out.println("LLamando al servicio 4 sin aop");

    long tiempoEjecucion = System.currentTimeMillis() - inicio;

    System.out.println("tiempo de ejecucion en ms: " + tiempoEjecucion);

    enviarAlerta(tiempoEjecucion);
  }

  private void enviarAlerta(long tiempoEjecucion) {
    if (tiempoEjecucion > UMBRAL_TOLERANCIA) {
      System.out.println("Tiempo de ejecucion por encima de lo aceptable!!!!");
    }
  }
}
