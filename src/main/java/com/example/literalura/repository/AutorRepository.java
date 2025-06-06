package com.example.literalura.repository;

import com.example.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);

    @Query("""
            SELECT a FROM Autor a
            WHERE a.nacimiento <= :anio
            AND (a.muerte IS NULL OR a.muerte > :anio)
            """)
    List<Autor> buscarAutoresVivos(@Param("anio") Integer anio);

    @Query("SELECT a FROM Autor a")
    List<Autor> mostrarAutores();
}
