package com.eduit.beans;

import org.springframework.stereotype.Service;

@Service("facturacionServiceAnnotation")
public class FacturacionService {

    public double calcularFactura(double costoPorHora, int cantidadDeHoras) {
        return costoPorHora * cantidadDeHoras;
    }
}
