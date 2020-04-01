package com.eduit;

import com.eduit.config.AppConfig;
import com.eduit.model.Product;
import com.eduit.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Product product = new Product("PS4", "console");

        productRepository.save(product);
        System.out.println("insertando producto: " + product);

        System.out.println("Imprimendo lista de products " + productRepository.findAll());

        productRepository.findAll().stream().map(p -> p.getId()).forEach(id -> {
            System.out.println("Buscando producto por id e imprinendolo uno por uno " + productRepository.findById(id));
        });
    }
}
