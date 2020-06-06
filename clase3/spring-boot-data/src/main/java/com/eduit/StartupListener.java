package com.eduit;

import com.eduit.model.Categoria;
import com.eduit.model.Producto;
import com.eduit.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private ProductoRepository productoRepository;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    Categoria categoria = new Categoria(null, "utensilios");
    Producto producto = new Producto(null, "tenedor", 2020.0, categoria);

    productoRepository.save(producto);

  }
}
