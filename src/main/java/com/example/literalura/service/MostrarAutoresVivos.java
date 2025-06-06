package com.example.literalura.service;

import com.example.literalura.model.Autor;
import com.example.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class MostrarAutoresVivos {
    @Autowired
    private AutorRepository autorRepository;
    Scanner teclado = new Scanner(System.in);

    public void mostrarAutoresVivos(){
        System.out.println("Ingresa el año");
        Integer anio = teclado.nextInt();
        teclado.nextLine();

        List<Autor> autoresVivos = autorRepository.buscarAutoresVivos(anio);
        if (autoresVivos.isEmpty()){
            System.out.println("Ningun autor estaba vivo en esta epoca");
        } else {
            System.out.println("Autores vivos en " + anio);
            autoresVivos.stream()
                    .forEach(autor -> {
                        System.out.println("- " + autor.getNombre());
                    });
        }

    }
}
