package com.example.literalura.service;

import com.example.literalura.model.Libro;
import com.example.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class MostrarLibrosPorIdioma {
    @Autowired
    private LibroRepository libroRepository;
    Scanner teclado = new Scanner(System.in);

    public void mostrarLibrosPorIdioma() {
        System.out.println("Elige un idioma (ES, EN, FR, PT)");
        String idioma = teclado.nextLine();

        List<Libro> librosEncontrados = libroRepository.buscarLibrosPorIdioma(idioma);

        List<Libro> resultados = librosEncontrados.stream()
                .filter(libro -> libro.getIdiomas().contains(idioma))
                .collect(Collectors.toList());

        if (resultados.isEmpty()) {
            System.out.println("No existe ningun libro en " + idioma);
        } else {
            resultados.forEach(libro -> System.out.println("- " + libro.getTitulo()));
        }
    }
}
