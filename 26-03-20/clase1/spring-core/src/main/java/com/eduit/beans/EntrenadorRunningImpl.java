package com.eduit.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("runningCoach")
public class EntrenadorRunningImpl implements Entrenador {

    private final FacturacionService facturacionService;

    @Autowired
    public EntrenadorRunningImpl(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @Override
    public void darRutinaDiaria() {
        System.out.println("Correr 5 K");
    }

    @Override
    public void darFacturacion() {
        double facturacion = facturacionService.calcularFactura(50, 5);
        System.out.println(facturacion);
    }
}
