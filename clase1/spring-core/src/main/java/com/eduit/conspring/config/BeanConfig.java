package com.eduit.conspring.config;

import com.eduit.conspring.beans.EntrenadorRunningServiceImpl;
import com.eduit.conspring.beans.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean(name = "entrenadorRunning")
  public EntrenadorRunningServiceImpl entrenadorRunningService(@Autowired FacturacionService facturacionService) {
    EntrenadorRunningServiceImpl entrenadorRunningService =  new EntrenadorRunningServiceImpl(facturacionService);
    return entrenadorRunningService;
  }

}
