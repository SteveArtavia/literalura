package com.example.literalura.main;

import com.example.literalura.model.DatosLibro;
import com.example.literalura.model.DatosResultados;
import com.example.literalura.service.ConsultaAPI;
import com.example.literalura.service.ConvertirDatos;

import java.util.List;

public class Main {
    private ConsultaAPI consultaAPI = new ConsultaAPI();
    private ConvertirDatos convertirDatos = new ConvertirDatos();

    public void mostrarMenu(){
        consultaAPI.obtenerDatos();

        System.out.println("Bienvenido a Literalura");

        mostrarDatos();

    }

    public List<DatosLibro> mostrarDatos(){
        var json = consultaAPI.obtenerDatos();
        DatosResultados datosResultados = convertirDatos.convertirDatos(json, DatosResultados.class);
        List<DatosLibro> datos = datosResultados.resultados();

        datos.forEach(System.out::println);
        return datos;
    }


}
