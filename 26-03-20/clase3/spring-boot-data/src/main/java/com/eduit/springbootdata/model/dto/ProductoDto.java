package com.eduit.springbootdata.model.dto;

import com.eduit.springbootdata.model.Producto;

public class ProductoDto {
    private String nombre;
    private Double precio;
    private Long categoriaId;

    public ProductoDto() {
    }

    public ProductoDto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductoDto(String nombre, Double precio, Long categoriaId) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
