package com.eduit;

import com.eduit.model.Categoria;
import com.eduit.model.Factura;
import com.eduit.model.Producto;
import com.eduit.repository.FacturaRepository;
import com.eduit.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private ProductoRepository productoRepository;

  @Autowired
  private FacturaRepository facturaRepository;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    Categoria categoria = new Categoria(null, "utensilios");
    Producto producto = new Producto(null, "tenedor", 2020.0, categoria);

    Factura factura = new Factura();

    facturaRepository.save(factura);

    productoRepository.save(producto);

  }
}
