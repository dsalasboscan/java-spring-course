package com.eduit.springbootdata.service;

import com.eduit.springbootdata.model.Categoria;
import com.eduit.springbootdata.model.Factura;
import com.eduit.springbootdata.model.Item;
import com.eduit.springbootdata.model.Producto;
import com.eduit.springbootdata.model.dto.*;
import com.eduit.springbootdata.repository.CategoriaRepository;
import com.eduit.springbootdata.repository.FacturacionRepository;
import com.eduit.springbootdata.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainServiceImpl implements MainService {

    private FacturacionRepository facturacionRepository;
    private ProductoRepository productoRepository;
    private CategoriaRepository categoriaRepository;

    @Autowired
    public MainServiceImpl(FacturacionRepository facturacionRepository, ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.facturacionRepository = facturacionRepository;
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public FacturaDto hacerFactura(CompraDto compraDto) {
        Factura factura = new Factura();

        factura.setItems(mapearItemsDtoAItem(compraDto.getItems()));
        factura.setFechaCompra(LocalDateTime.now());
        factura.setMontoMontotal(calcularMontoFactura(compraDto.getItems()));

        facturacionRepository.save(factura);

        return new FacturaDto(factura.getId(), compraDto.getItems(), factura.getFechaCompra(), factura.getMontoMontotal());
    }

    @Override
    public ProductosRespuestaDto obtenerTodosLosProductos() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoDto> productoDtos = mapearProductosADto(productos);
        return new ProductosRespuestaDto(productoDtos.size(), productoDtos);
    }

    @Override
    public ProductosRespuestaDto obtenerProductosPorCategoria(String nombreCategoria) {
        Categoria categoria = categoriaRepository.findCategoriaPorNombre(nombreCategoria);

        List<Producto> productos = productoRepository.findAllByCategoriaNombre(categoria.getNombre());

        List<ProductoDto> productoDtos = mapearProductosADto(productos);

        return new ProductosRespuestaDto(productoDtos.size(), productoDtos);
    }

    private List<Item> mapearItemsDtoAItem(List<ItemDto> itemDtos) {
        return itemDtos.stream()
                .map(item -> new Item(
                                item.getCantidad(),
                                new Producto(
                                        item.getProductoDto().getNombre(),
                                        item.getProductoDto().getPrecio()
                                )
                        )
                ).collect(Collectors.toList());
    }

    private Double calcularMontoFactura(List<ItemDto> itemDtos) {
        return itemDtos
                .stream()
                .mapToDouble(item -> item.getProductoDto().getPrecio() * item.getCantidad())
                .sum();
    }

    private List<ProductoDto> mapearProductosADto(List<Producto> productos) {
        return productos.stream().map(producto -> new ProductoDto(producto.getNombre(), producto.getPrecio(), producto.getCategoria().getId())).collect(Collectors.toList());
    }
}
