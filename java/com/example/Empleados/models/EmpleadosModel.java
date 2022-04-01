package com.example.Empleados.models;

import java.util.UUID;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Empleados")
@Data
public class EmpleadosModel {
@Id
    private UUID id;

    private String nombre;

    private String apellidos;

    private String dni;


    public EmpleadosModel(UUID id, String nombre, String apellidos, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

}
