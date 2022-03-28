package com.example.Empleados.exception;

public class ApiRequestException  extends  RuntimeException{

    public ApiRequestException(String message) {
        super(message);
    }

}
