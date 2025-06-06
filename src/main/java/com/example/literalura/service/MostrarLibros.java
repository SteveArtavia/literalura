package com.example.literalura.service;

import com.example.literalura.model.Libro;
import com.example.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostrarLibros {

    @Autowired
    private LibroRepository libroRepository;

    public void mostrarLibros(){
        List<Libro> librosRegistrados = libroRepository.mostrarLibros();
        librosRegistrados.stream()
                .forEach(libro -> {
                    System.out.println("Titulo: " + libro.getTitulo());
                    System.out.println("Autor: " + libro.getAutor());
                    System.out.println("Idiomas: " + libro.getIdiomas());
                    System.out.println("Descargas: " + libro.getDescargas());
                    System.out.println("----------------------------------");
                });
    }

}
