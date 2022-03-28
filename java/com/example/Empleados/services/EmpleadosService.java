package com.example.Empleados.services;

import com.example.Empleados.models.EmpleadosModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpleadosService {

    private List<EmpleadosModel> empleadosModelList= new ArrayList<>();

    public  List<EmpleadosModel> getAllEmpleados(){
        return  empleadosModelList;
    }

    public EmpleadosModel getEmpleados(String dni){
        return empleadosModelList.stream().filter(t-> t.getDni().equals(dni)).findFirst().get();
    }

    public void addEmpleados(EmpleadosModel empleadosModel){

        UUID result = UUID.fromString(UUID.randomUUID().toString());

        empleadosModel.setId(result);
        empleadosModelList.add(empleadosModel);
    }

    public void updateEmpleado(UUID id, EmpleadosModel empleadosModel) {

        empleadosModelList.stream()
                .filter(p -> p.getId().equals(id)).findFirst()
                .map(p -> empleadosModelList.set( empleadosModelList.indexOf(p), empleadosModel));
    }

    public void deleteEmpleados(UUID id){
        empleadosModelList.removeIf(t->t.getId().equals(id));
    }

}
