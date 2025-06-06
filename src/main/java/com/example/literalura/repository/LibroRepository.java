package com.example.literalura.repository;

import com.example.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("""
            SELECT l FROM Libro l 
            JOIN FETCH l.autor 
            JOIN FETCH l.idiomas
            WHERE LOWER(l.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))
            """)
    List<Libro> buscarPorTitulo(@Param("titulo") String titulo);

    @Query("""
            SELECT DISTINCT l FROM Libro l
            JOIN FETCH l.autor
            JOIN FETCH l.idiomas
            """)
    List<Libro> mostrarLibros();

    @Query("""
            SELECT l FROM Libro l
            WHERE :idioma MEMBER OF l.idiomas
            """)
    List<Libro> buscarLibrosPorIdioma(String idioma);
}
