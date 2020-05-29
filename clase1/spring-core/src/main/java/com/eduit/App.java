package com.eduit;

import com.eduit.conspring.beans.EntrenadorService;
import com.eduit.conspring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  private static final String DEFAULT_COACH_TYPE = "entrenadorFutbol";

  public static void main(String[] args) {
    ApplicationContext context;

    if (args[0].equalsIgnoreCase("annotation")) {
      context  = new AnnotationConfigApplicationContext(AppConfig.class);
    } else {
      context = new ClassPathXmlApplicationContext("beans.xml");
    }
    String coachType;

    if (args.length > 1) {
      coachType = args[1];
    } else {
      coachType = DEFAULT_COACH_TYPE;
    }

    EntrenadorService entrenadorService = context.getBean(coachType, EntrenadorService.class);


    entrenadorService.darRutinaDiaria();
    entrenadorService.darFacturacion();
  }
}
