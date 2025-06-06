package com.example.literalura.service;

import com.example.literalura.model.*;
import com.example.literalura.repository.AutorRepository;
import com.example.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuardarTodosLosLibros {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ConsultaAPI consultaAPI;

    @Autowired
    private ConvertirDatos convertirDatos;

    public void guardarTodosLosLibros(){
        if(libroRepository.count() > 0){
            return;
        }

        var json = consultaAPI.obtenerDatos();
        DatosResultados datosResultados = convertirDatos.convertirDatos(json, DatosResultados.class);
        List<DatosLibro> libros = datosResultados.resultados();

        for (DatosLibro datos : libros) {
            List<Autor> autores = new ArrayList<>();

            for (DatosAutor datosAutor : datos.autor()) {
                Autor autor = autorRepository.findByNombre(datosAutor.nombre())
                        .orElseGet(() -> {
                            Autor nuevoAutor = new Autor(
                                    datosAutor.nombre(),
                                    datosAutor.nacimiento(),
                                    datosAutor.muerte()
                            );
                            return autorRepository.save(nuevoAutor);
                        });

                autores.add(autor);
            }

            Libro libro = new Libro(
                    datos.titulo(),
                    autores,
                    datos.descargas(),
                    datos.idiomas()
            );

            libroRepository.save(libro);
        }
    }
}
