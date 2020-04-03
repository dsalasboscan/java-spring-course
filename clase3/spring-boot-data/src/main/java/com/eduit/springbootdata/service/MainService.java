package com.eduit.springbootdata.service;

import com.eduit.springbootdata.model.dto.CompraDto;
import com.eduit.springbootdata.model.dto.FacturaDto;
import com.eduit.springbootdata.model.dto.ProductosRespuestaDto;

public interface MainService {
    FacturaDto hacerFactura(CompraDto compraDto);
    ProductosRespuestaDto obtenerTodosLosProductos();
    ProductosRespuestaDto obtenerProductosPorCategoria(String nombreCategoria);
}
