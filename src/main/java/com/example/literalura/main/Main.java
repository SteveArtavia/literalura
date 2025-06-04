package com.example.literalura.main;

import com.example.literalura.service.ConsultaAPI;

public class Main {
    public void mostrarMenu(){
        System.out.println("Bienvenido a Literalura");

        ConsultaAPI consultaAPI = new ConsultaAPI();
        consultaAPI.obtenerDatos();
    }
}
