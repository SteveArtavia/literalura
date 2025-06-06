package com.example.literalura.service;

import com.example.literalura.model.Autor;
import com.example.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostrarAutores {

    @Autowired
    private AutorRepository autorRepository;

    public void mostrarAutores(){
        System.out.println("Autores registrados: ");

        List<Autor> autoresRegistrados = autorRepository.mostrarAutores();

        autoresRegistrados.stream()
                .forEach(autor -> {
                    System.out.println("Nombre: " + autor.getNombre());
                    System.out.println("Nacimiento: " + autor.getNacimiento());
                    System.out.println("Muerte: " + autor.getMuerte());
                    System.out.println("-----------------------------");
                });
    }
}
