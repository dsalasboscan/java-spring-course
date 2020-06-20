package com.eduit.model.dto;

import lombok.Data;

@Data
public class ProductDto {
  private Long id;
  private String nombre;
  private Double precio;
  private CategoriaDto categoriaDto;
}
