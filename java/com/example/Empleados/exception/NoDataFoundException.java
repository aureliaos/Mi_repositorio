package com.example.Empleados.exception;

public class NoDataFoundException extends  RuntimeException{
    public NoDataFoundException(String message){
        super(message);
    }
}
