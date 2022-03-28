package com.example.Empleados.controller;

import com.example.Empleados.exception.ApiRequestException;
import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.services.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class EmpleadosController {

    @Autowired
private EmpleadosService empleadosService;

   @RequestMapping("/empleados")
    public List<EmpleadosModel> getAllEmpleados(){

    return  empleadosService.getAllEmpleados();
   }


   @GetMapping("empleados/{dni}")
    public EmpleadosModel getEmpleado(@PathVariable String dni){

       return empleadosService.getEmpleados(dni);

   }


   @PostMapping("/empleados")
    public void addEmpleados(@RequestBody EmpleadosModel empleadosModel){

       empleadosService.addEmpleados(empleadosModel);
   }

   @PutMapping("/empleados/{id}")
    public  void updateEmpleados(@PathVariable UUID id, @RequestBody EmpleadosModel empleadosModel) {

       empleadosService.updateEmpleado(id,empleadosModel);
   }


    @DeleteMapping("/empleados/{id}")
  public void deleteEmpelados(@PathVariable UUID id)  {
       empleadosService.deleteEmpleados(id);
    }
}
