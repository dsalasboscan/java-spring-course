package com.eduit.springbootdata.repository;

import com.eduit.springbootdata.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("select c from Categoria c where c.nombre = ?1")
    Categoria findCategoriaPorNombre(String nombre);
}
