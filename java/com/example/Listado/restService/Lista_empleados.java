package com.example.Listado.restService;
public class Lista_empleados {

    private String Nombre;
    private String Apellidos;
    private String Dni;
    private Integer id;

    public Lista_empleados()
    {

    }

    public Lista_empleados(String nombre, String apellidos, String dni, Integer id) {
        Nombre = nombre;
        Apellidos = apellidos;
        Dni = dni;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }
}
