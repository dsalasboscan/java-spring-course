package com.eduit.conspring.beans;

public class EntrenadorRunningServiceImpl implements EntrenadorService {

  private FacturacionService facturacionService;

  public EntrenadorRunningServiceImpl(FacturacionService facturacionService) {
    this.facturacionService = facturacionService;
  }

  @Override
  public void darRutinaDiaria() {
    System.out.println("Correr 5K");
  }

  @Override
  public void darFacturacion() {
    facturacionService.calcularFactura(800, 5);
  }
}
