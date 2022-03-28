package com.example.Empleados.services;

import com.example.Empleados.exception.ApiRequestException;
import com.example.Empleados.models.EmpleadosModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpleadosService {

    private List<EmpleadosModel> empleadosModelList= new ArrayList<>();

    public  List<EmpleadosModel> getAllEmpleados(){
        if(empleadosModelList.size()>0){
        return  empleadosModelList;
        }
        throw  new ApiRequestException("No hay ningún empleado");
    }

    public EmpleadosModel getEmpleados(String dni){


      Optional<EmpleadosModel>emp=  empleadosModelList.stream().filter(t-> t.getDni().equals(dni)).findFirst();

      if(!emp.isPresent())
      {
          throw new ApiRequestException("No existe dicho dni ");
      }
        return emp.get();
    }

    public void addEmpleados(EmpleadosModel empleadosModel){

        if(empleadosModel.getNombre().equals(""))
        {
            throw new ApiRequestException("El nombre del empleado está vacio ");
        }
        if(empleadosModel.getApellidos().equals(""))
        {
            throw new ApiRequestException("El apellido del empleado está vacio ");
        }

        UUID result = UUID.fromString(UUID.randomUUID().toString());

        empleadosModel.setId(result);
        empleadosModelList.add(empleadosModel);
    }

    public void updateEmpleado(UUID id, EmpleadosModel empleadosModel) {

        empleadosModelList.stream()
                .filter(p -> p.getId().equals(id)).findFirst()
                .map(p -> empleadosModelList.set( empleadosModelList.indexOf(p), empleadosModel))
                ;
    }

    public void deleteEmpleados(UUID id){

        empleadosModelList.removeIf(t->t.getId().equals(id));
    }

}
