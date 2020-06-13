package com.eduit.springbootdata.repository;

import com.eduit.springbootdata.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturacionRepository extends JpaRepository<Factura, Long> {
}
