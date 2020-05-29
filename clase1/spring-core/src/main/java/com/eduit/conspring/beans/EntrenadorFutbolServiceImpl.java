package com.eduit.conspring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("entrenadorFutbol")
public class EntrenadorFutbolServiceImpl implements EntrenadorService {

  // @Autowired // FIELD INJECTION
  private FacturacionService facturacionService;

  public EntrenadorFutbolServiceImpl(@Autowired FacturacionService facturacionService) { // Constructor injection RECOMMENDED!
    this.facturacionService = facturacionService;
  }


  @Override
  public void darRutinaDiaria() {
    System.out.println("Patea 300 balones");
  }

  @Override
  public void darFacturacion() {
    facturacionService.calcularFactura(600, 4);
  }
}
