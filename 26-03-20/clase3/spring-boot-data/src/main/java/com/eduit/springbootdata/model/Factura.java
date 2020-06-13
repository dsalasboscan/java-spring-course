package com.eduit.springbootdata.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, insertable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    private LocalDateTime fechaCompra;

    @Column(nullable = false)
    private Double montoMontotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Double getMontoMontotal() {
        return montoMontotal;
    }

    public void setMontoMontotal(Double montoMontotal) {
        this.montoMontotal = montoMontotal;
    }
}
