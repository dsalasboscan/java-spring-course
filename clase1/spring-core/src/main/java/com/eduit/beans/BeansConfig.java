package com.eduit.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean("entrenadorFutbol")
    public Entrenador entrenadorFutbol(@Autowired FacturacionService facturacionService) {
        return new EntrenadorFutbolImpl(facturacionService);
    }
}