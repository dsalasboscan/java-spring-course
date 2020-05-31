package com.eduit;

import com.eduit.model.Product;
import com.eduit.repository.ProductoRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    ProductoRepository productoRepository = context.getBean(ProductoRepository.class);

    Product product = new Product("XBOX1", "console");

    productoRepository.save(product);

    System.out.println("Imprimiendo lista de productos " + productoRepository.findAll());

    productoRepository.findAll().stream().map(p -> p.getId()).forEach(id -> {
      System.out.println("Buscando producto por id e imprinendolo uno por uno " + productoRepository.findById(id));
    });
  }
}
