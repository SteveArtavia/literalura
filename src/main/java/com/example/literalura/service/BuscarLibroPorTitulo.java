package com.example.literalura.service;

import com.example.literalura.model.Autor;
import com.example.literalura.model.Libro;
import com.example.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class BuscarLibroPorTitulo {
    @Autowired
    private LibroRepository libroRepository;
    Scanner teclado = new Scanner(System.in);

    public void buscarLibroPorTitulo(){
        System.out.println("Escribe el nombre del libro que deseas buscar");
        String nombre = teclado.nextLine();
        List<Libro> librosEncontrados = libroRepository.buscarPorTitulo(nombre);

        if(librosEncontrados.isEmpty()){
            System.out.println("No se encontro ningun libro relacionado con " + nombre);
        } else {
            System.out.println("Libros encontrados:");
            for(Libro libro : librosEncontrados){
                System.out.println("Titulo: " + libro.getTitulo());
                System.out.println("Autor: ");
                for(Autor autor : libro.getAutor()){
                    System.out.println("- " + autor.getNombre());
                }
                System.out.println("Idiomas: " + libro.getIdiomas());
                System.out.println("Descargas: " + libro.getDescargas());
                System.out.println("------------------------------");
            }
        }
    }
}
