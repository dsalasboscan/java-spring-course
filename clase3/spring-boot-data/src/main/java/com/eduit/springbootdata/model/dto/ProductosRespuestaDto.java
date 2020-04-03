package com.eduit.springbootdata.model.dto;

import java.util.List;

public class ProductosRespuestaDto {
    private Integer cantidadRegistros;
    private List<ProductoDto> productos;

    public ProductosRespuestaDto() {
    }

    public ProductosRespuestaDto(Integer cantidadRegistros, List<ProductoDto> productos) {
        this.cantidadRegistros = cantidadRegistros;
        this.productos = productos;
    }

    public Integer getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void setCantidadRegistros(Integer cantidadRegistros) {
        this.cantidadRegistros = cantidadRegistros;
    }

    public List<ProductoDto> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDto> productos) {
        this.productos = productos;
    }
}
