package com.eduit;

import com.eduit.beans.Entrenador;
import com.eduit.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    private static String DEFAULT_COACH_TYPE = "runningCoach";

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        String coachType;
        if (args.length > 0) {
            coachType = args[0];
        } else {
            coachType = DEFAULT_COACH_TYPE;
        }

        Entrenador entrenador = context.getBean(coachType, Entrenador.class);

        entrenador.darRutinaDiaria();
        entrenador.darFacturacion();
    }
}
