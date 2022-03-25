package com.example.Empleados.services;

import com.example.Empleados.models.EmpleadosModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpleadosService {

    private List<EmpleadosModel> empleadosModelList= new ArrayList<>(Arrays.asList(
            new EmpleadosModel(0,"name","Cruz","123455678L"),
            new EmpleadosModel(1,"Khatif","Cruz","123455678L"),
            new EmpleadosModel(2,"Noa","Cruz","72891234L"),
            new EmpleadosModel(3,"Noanda","Rodriguez","123455678L")
    ));

    public  List<EmpleadosModel> getAllEmpleados(){
        return  empleadosModelList;
    }

    public EmpleadosModel getEmpleados(String dni){
        return empleadosModelList.stream().filter(t-> t.getDni().equals(dni)).findFirst().get();
    }

    public void addEmpleados(EmpleadosModel empleadosModel){

        empleadosModelList.add(empleadosModel);
    }

    public void updateEmpleado(Integer id,EmpleadosModel empleadosModel)
    {
        for(int i=0;i<empleadosModelList.size(); i++)
        {
            EmpleadosModel t=empleadosModelList.get(i);

            if(t.getId().equals(id)){
                empleadosModelList.set(i,empleadosModel);
            }


        }
    }

    public void deleteEmpleados(Integer id){
        empleadosModelList.removeIf(t->t.getId().equals(id));
    }

}
