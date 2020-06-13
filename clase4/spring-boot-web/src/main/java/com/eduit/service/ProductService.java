package com.eduit.service;

import com.eduit.model.Producto;
import com.eduit.model.dto.ProductDto;
import com.eduit.model.dto.RecursoCreadoDto;
import com.eduit.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private ProductoRepository productoRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ResponseEntity<RecursoCreadoDto> add(ProductDto productDto) {
    Producto producto = modelMapper.map(productDto, Producto.class);
    productoRepository.save(producto);

    System.out.println("hola mundo");

    return new ResponseEntity<>(new RecursoCreadoDto(producto.getId()), HttpStatus.CREATED);
  }

  public ResponseEntity<ProductDto> getById(Long id) {
    Optional<Producto> producto = productoRepository.findById(id);

    if (producto.isPresent()) {
      ProductDto productDto = modelMapper.map(producto.get(), ProductDto.class);
      return new ResponseEntity<>(productDto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }
}
