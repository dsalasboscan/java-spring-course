package com.eduit.springbootdata.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class FacturaDto {
    private Long id;
    private List<ItemDto> items;
    private LocalDateTime fechaCompra;
    private Double totalFactura;

    public FacturaDto() {
    }

    public FacturaDto(Long id, List<ItemDto> items, LocalDateTime fechaCompra, Double totalFactura) {
        this.id = id;
        this.items = items;
        this.fechaCompra = fechaCompra;
        this.totalFactura = totalFactura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Double totalFactura) {
        this.totalFactura = totalFactura;
    }
}
