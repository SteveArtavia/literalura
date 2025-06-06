package com.example.literalura.main;

import com.example.literalura.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Main {
    Scanner teclado = new Scanner(System.in);

    @Autowired
    private GuardarTodosLosLibros guardarTodosLosLibros;

    @Autowired
    private BuscarLibroPorTitulo buscarLibroPorTitulo;

    @Autowired
    private MostrarLibros mostrarLibros;

    @Autowired
    private MostrarAutoresVivos mostrarAutoresVivos;

    @Autowired
    private MostrarAutores mostrarAutores;

    @Autowired
    private MostrarLibrosPorIdioma mostrarLibrosPorIdioma;


    public void mostrarMenu(){
        System.out.println("Bienvenido a Literalura");

        String menu = """
                Seleccione la accion que desea realizar:
                
                1 - Buscar libro por titulo
                2 - Mostrar libros registrados
                3 - Mostrar autores registrados
                4 - Mostrar autores vivos segun el año
                5 - Mostrar libros por idioma (ES, EN, FR, PT)
                """;

        guardarTodosLosLibros.guardarTodosLosLibros();

        Integer opcion = -1;
        System.out.println(menu);

        while(opcion != 0){
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch(opcion){
                case 1:
                    buscarLibroPorTitulo.buscarLibroPorTitulo();
                    break;
                case 2:
                    mostrarLibros.mostrarLibros();
                    break;
                case 3:
                    mostrarAutores.mostrarAutores();
                    break;
                case 4:
                    mostrarAutoresVivos.mostrarAutoresVivos();
                    break;
                case 5:
                    mostrarLibrosPorIdioma.mostrarLibrosPorIdioma();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
            }

        }

    }
}
