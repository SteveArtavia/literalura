package com.example.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ConvertirDatos implements IConvierteDatos{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T convertirDatos(String json, Class<T> clase){
        try{
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e){
            throw new RuntimeException();
        }
    }
}
