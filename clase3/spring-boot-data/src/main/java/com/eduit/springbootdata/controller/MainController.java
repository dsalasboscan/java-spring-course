package com.eduit.springbootdata.controller;

import com.eduit.springbootdata.model.dto.CompraDto;
import com.eduit.springbootdata.model.dto.FacturaDto;
import com.eduit.springbootdata.model.dto.ProductosRespuestaDto;
import com.eduit.springbootdata.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping("/facturas/crear")
    public ResponseEntity<FacturaDto> comprar(@RequestBody CompraDto compraDto) {
        FacturaDto facturaDto = mainService.hacerFactura(compraDto);
        return new ResponseEntity<>(facturaDto, HttpStatus.OK);
    }

    @GetMapping("/productos/obtener-todos")
    public ResponseEntity<ProductosRespuestaDto> obtenerProductos() {
        return new ResponseEntity<>(mainService.obtenerTodosLosProductos(), HttpStatus.OK);
    }

    @GetMapping("/productos/obtener-todos/{categoria}")
    public ResponseEntity<ProductosRespuestaDto> obtenerProductosPorCategoria(@PathVariable(name = "categoria") String categoria) {
        return new ResponseEntity<>(mainService.obtenerProductosPorCategoria(categoria), HttpStatus.OK);
    }
}
