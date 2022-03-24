package com.example.Listado.controllers;


import com.example.Listado.restService.Lista_empleados;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmpleadosController {


    @GetMapping("/set")
    public Lista_empleados SetEmpleado(){

       Lista_empleados empleado =new Lista_empleados();
       empleado.setNombre("Maria");
       empleado.setApellidos("Jarco");
       empleado.setDni("12345678B");
        empleado.setId(5);

       return empleado;
    }

    @GetMapping("/get")
    public String GetNombre_empleadoByString(){

        Lista_empleados empleado= new Lista_empleados("lucai","maron","5522w",1);


        String nuevos = empleado.getNombre();
        return nuevos;
    }



    @GetMapping("/array")
    public List<Lista_empleados> ArrayEmpleados(){

       return Arrays.asList(
               new Lista_empleados("Juan","Rojano","12345674D",0),
               new Lista_empleados("Ana","Nomess","32156785F",1),
               new Lista_empleados("Maria","Absval","12743267P",2),
               new Lista_empleados("Khatif","Riouma","1236123L",3)
       );
    }


}
