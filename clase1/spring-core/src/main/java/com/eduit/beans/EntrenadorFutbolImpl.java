package com.eduit.beans;

public class EntrenadorFutbolImpl implements Entrenador {

    FacturacionService facturacionService;

    public EntrenadorFutbolImpl(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @Override
    public void darRutinaDiaria() {
        System.out.println("Disparar 50 veces al arco");
    }

    @Override
    public void darFacturacion() {
        double facturacion = facturacionService.calcularFactura(40, 3);
        System.out.println(facturacion);
    }
}
