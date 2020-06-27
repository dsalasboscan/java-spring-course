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

import java.util.ArrayList;
import java.util.List;
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
  
  public ResponseEntity<List<RecursoCreadoDto>> addAllProducts(List<ProductDto> productos){
	  List<RecursoCreadoDto> productosCreados = new ArrayList<RecursoCreadoDto>();
	  for (ProductDto productDto : productos) {
		  Producto producto = modelMapper.map(productDto, Producto.class);
		  productoRepository.save(producto);
		  RecursoCreadoDto rcd = new RecursoCreadoDto(producto.getId());
		  productosCreados.add(rcd);
		 }
	  return new ResponseEntity<>(productosCreados, HttpStatus.CREATED);
  }
  
  public ResponseEntity<List<ProductDto>> getAll(){
	  List<ProductDto> productosDto = new ArrayList<ProductDto>();
	  List<Producto> productos = productoRepository.findAll();
	  for (Producto product : productos) {
		  ProductDto productDto = modelMapper.map(product, ProductDto.class);
		  productosDto.add(productDto);
		 }
	  return new ResponseEntity<>(productosDto, HttpStatus.CREATED);
  }
}
