package com.mora.victor.recyclerviewexample.db;

/**
 * Created by Victor on 28-May-17.
 */

public final class ConstantesBaseDatos {

    //constantes para la creacion de la base de datos
    public static final String DATABASE_NAME = "contactos";
    public static final int DATABASE_VERSION = 1;

    //constantes para la creacion de la tabla de contactos
    public static final String TABLE_CONTACTS = "contacto";
    public static final String TABLE_CONTACTS_ID = "id";
    public static final String TABLE_CONTACTS_NOMBRE = "nombre";
    public static final String TABLE_CONTACTS_TELEFONO = "telefono";
    public static final String TABLE_CONTACTS_EMAIL = "email";
    public static final String TABLE_CONTACTS_FOTO = "foto";

    //constantes para la creacion de la tabla de likes
    public static final String TABLE_LIKES_CONTACT = "contacto_likes";
    public static final String TABLE_LIKES_CONTACT_ID = "id";
    public static final String TABLE_LIKES_CONTACT_ID_CONTACTO = "id_contacto";
    public static final String TABLE_LIKES_CONTACT_NUMERO_LIKES = "numero_likes";
}
