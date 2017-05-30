package com.mora.victor.recyclerviewexample.db;

import android.content.ContentValues;
import android.content.Context;

import com.mora.victor.recyclerviewexample.R;
import com.mora.victor.recyclerviewexample.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Victor on 21-May-17.
 */

public class ConstructorContactos {

    private Context context;
    private static final int LIKE = 1;

    public ConstructorContactos(Context context){
        this.context = context;
    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        int likes=0;
        BaseDatos db = new BaseDatos(context);
        try{
            likes = db.obtenerLikesContacto(contacto);
        }finally {
            db.close();
            return  likes;
        }
    }

    public ArrayList<Contacto> obtenerDatos(){
        /*
        ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto(R.drawable.spaceships_001, "Rocketman 01",
                "787878", "rocket01@gmail.com", 23));
        contactos.add(new Contacto(R.drawable.spaceships_002, "Rocketman 02",
                "74521358", "rocket02@gmail.com", 28));
        contactos.add(new Contacto(R.drawable.spaceships_003, "Rocketman 03",
                "7135768415", "rocket03@gmail.com", 78));
        contactos.add(new Contacto(R.drawable.spaceships_004, "Rocketman 04",
                "7135768415", "rocket04@gmail.com", 14));
        contactos.add(new Contacto(R.drawable.spaceships_005, "Rocketman 05",
                "7135768415", "rocket05@gmail.com", 14));
        return  contactos;
        */
        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Popote Meza");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "78454-987");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "lala@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.spaceships_008);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Emiyi Meza");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "78454-1087");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "emma@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.spaceships_007);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Cleo Meza");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "78454-9787");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "cleo@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.spaceships_009);
        db.insertarContacto(contentValues);

    }

}
