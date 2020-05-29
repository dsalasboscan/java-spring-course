package com.eduit.conspring.beans;

import org.springframework.stereotype.Component;

@Component
public class FacturacionService {

  public void calcularFactura(double tarifaPorHora, int cantidadDeHoras) {
    double montoTotal = tarifaPorHora * cantidadDeHoras;
    System.out.println("El monto total de la factura es: " + montoTotal);
  }
}
