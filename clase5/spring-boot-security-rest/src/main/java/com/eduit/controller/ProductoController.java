package com.eduit.controller;

import com.eduit.model.Producto;
import com.eduit.model.dto.ProductDto;
import com.eduit.model.dto.RecursoCreadoDto;
import com.eduit.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

  private final ProductService productService;

  public ProductoController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping(value = "/producto/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RecursoCreadoDto> add(@RequestBody ProductDto productDto) {
    return productService.add(productDto);
  }

  @PostMapping(value = "/producto/add-bulk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<RecursoCreadoDto>> addBulk(@RequestBody List<ProductDto> productDtos) {
    return productService.addBulk(productDtos);
  }

  @GetMapping(value = "/producto/{id}")
  public ResponseEntity<ProductDto> getById(@PathVariable("id") Long id) {
    return productService.getById(id);
  }
}
