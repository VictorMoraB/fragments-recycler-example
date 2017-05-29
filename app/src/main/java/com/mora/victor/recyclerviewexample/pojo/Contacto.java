package com.mora.victor.recyclerviewexample.pojo;

/**
 * Created by Victor on 13-May-17.
 */

public class Contacto {

    //identificador unico del contacto en la base de datos
    private int id;

    private String Nombre;
    private String Telefono;
    private String Correo;
    private int LikesCount;
    private int Imagen;

    public Contacto(int imagen, String nombre, String telefono, String correo, int likesCount){
        Imagen = imagen;
        Nombre = nombre;
        Telefono = telefono;
        Correo = correo;
        LikesCount = likesCount;
    }

    public Contacto() {

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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public int getLikesCount() {
        return LikesCount;
    }

    public void setLikesCount(int likesCount) {
        LikesCount = likesCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
