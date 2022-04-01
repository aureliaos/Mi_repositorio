package com.example.Empleados.exception;

public class FieldEmptyException extends  RuntimeException{

    public FieldEmptyException(String message){
        super(message);
    }
}
