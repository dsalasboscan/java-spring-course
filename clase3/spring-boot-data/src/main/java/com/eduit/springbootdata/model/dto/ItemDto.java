package com.eduit.springbootdata.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDto {
    private Long cantidad;
    @JsonProperty("producto")
    private ProductoDto productoDto;

    public ItemDto() {}

    public ItemDto(Long cantidad, ProductoDto productoDto) {
        this.cantidad = cantidad;
        this.productoDto = productoDto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoDto getProductoDto() {
        return productoDto;
    }

    public void setProductoDto(ProductoDto productoDto) {
        this.productoDto = productoDto;
    }
}
