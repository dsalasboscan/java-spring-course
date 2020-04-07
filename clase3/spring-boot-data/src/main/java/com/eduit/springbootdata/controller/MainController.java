package com.eduit.springbootdata.controller;

import com.eduit.springbootdata.model.dto.CompraDto;
import com.eduit.springbootdata.model.dto.FacturaDto;
import com.eduit.springbootdata.model.dto.ProductosRespuestaDto;
import com.eduit.springbootdata.service.MainService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class MainController {

    private MainService mainService;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importJob;

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

    @GetMapping("/job/disparar")
    public ResponseEntity<Void> dispararJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = new JobParametersBuilder().addDate("currentDate", new Date()).toJobParameters();
        jobLauncher.run(importJob, jobParameters);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
