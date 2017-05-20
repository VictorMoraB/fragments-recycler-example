package com.mora.victor.recyclerviewexample.pojo;

/**
 * Created by Victor on 13-May-17.
 */

public class Contacto {

    private String Nombre;
    private String Telefono;
    private int Imagen;

    public Contacto(int imagen, String nombre, String telefono){
        Imagen = imagen;
        Nombre = nombre;
        Telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}
