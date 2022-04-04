package com.example.Empleados.services;

import com.example.Empleados.exception.NoContentException;
import com.example.Empleados.exception.NotFoundException;
import com.example.Empleados.exception.BadRequestException;
import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.repository.EmpleadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@RequiredArgsConstructor
public class EmpleadosService {

    private final EmpleadosRepository empleadosRepository;


    public  List<EmpleadosModel> getAllEmpleados(){
       List<EmpleadosModel> empleadosModelList = empleadosRepository.findAll();
       if(CollectionUtils.isNotEmpty(empleadosModelList))
      {
        throw new NotFoundException("No hay ningún empleado");
      }

           empleadosModelList;
    }


    public EmpleadosModel getEmpleados(String dni){

      if(!empleadosRepository.existsByDni(dni))
      {
          throw new NotFoundException("No existe dicho dni ");
      }

        return empleadosRepository.findByDni(dni);
    }


    public void addEmpleados(EmpleadosModel empleadosModel){

        if(StringUtils.isBlank(empleadosModel.getNombre())  || StringUtils.isBlank(empleadosModel.getApellidos())
                || StringUtils.isBlank(empleadosModel.getDni()) )
        {

            throw new NoContentException("Un dato del empleado esta vacio");
        }
        else if(empleadosRepository.existsByDni(empleadosModel.getDni()))
        {
            throw new BadRequestException("Este dni ya existe");
        }

        UUID result = UUID.fromString(UUID.randomUUID().toString());

        empleadosModel.setId(result);
        empleadosRepository.save(empleadosModel);
    }


    public void updateEmpleado(UUID id, EmpleadosModel empleadosModel) {

        if(StringUtils.isBlank(empleadosModel.getNombre())
                || StringUtils.isBlank(empleadosModel.getApellidos()) || StringUtils.isBlank(empleadosModel.getDni()))

        {
            throw new NoContentException("Un dato del empleado está vacio ");

        }
        else if(empleadosRepository.existsByDni(empleadosModel.getDni()))
        {
            throw new BadRequestException("Este dni ya existe");
        }

        empleadosRepository.save(empleadosModel);
    }


    public void deleteEmpleados(UUID id){

        if (!empleadosRepository.existsById(id))
        {
            throw new NotFoundException("No existe dicho id ");

        }
            empleadosRepository.deleteById(id);
    }

}
