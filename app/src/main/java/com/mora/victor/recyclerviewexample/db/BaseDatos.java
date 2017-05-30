package com.mora.victor.recyclerviewexample.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mora.victor.recyclerviewexample.pojo.Contacto;

import java.util.ArrayList;


/**
 * Created by Victor on 28-May-17.
 */

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }


    public ArrayList<Contacto> obtenerTodosLosContactos(){
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        //garantizar que la conexion a la base de datos siempre se va a cerrar
        try{
            Cursor cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()){
                Contacto contactoActual = new Contacto();
                contactoActual.setId(cursor.getInt(0));
                contactoActual.setNombre(cursor.getString(1));
                contactoActual.setTelefono(cursor.getString(2));
                contactoActual.setCorreo(cursor.getString(3));
                contactoActual.setImagen(cursor.getInt(4));
                contactos.add(contactoActual);
                //obtener los likes de la tabla de likes
                String queryLikes = "SELECT COUNT(" +  ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES +
                        ")" + "as likes" + " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +
                        " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + "=" + contactoActual.getId();
                Cursor registrosLikes = db.rawQuery(queryLikes, null);
                if(registrosLikes.moveToNext()){
                    contactoActual.setLikesCount(registrosLikes.getInt(0));
                }
            }
        }finally {
            db.close();
        }
        return contactos;
}

    public int obtenerLikesContacto(Contacto contacto){
        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + ")" +
                "FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +
                " WHERE " +  ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + "= " +
                contacto.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        try{
            Cursor registros = db.rawQuery(query, null);
            if(registros.moveToNext()){
                likes = registros.getInt(0);
            }
        }finally {
            db.close();
        }
        return likes;
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACT, null, contentValues);
        }finally {
            db.close();
        }
    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            db.insert(ConstantesBaseDatos.TABLE_CONTACTS, null, contentValues);
        }finally {
            db.close();
        }


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto="CREATE TABLE " + ConstantesBaseDatos.TABLE_CONTACTS + "(" +
                ConstantesBaseDatos.TABLE_CONTACTS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE   + " TEXT, " +
                ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO + " TEXT, " +
                ConstantesBaseDatos.TABLE_CONTACTS_EMAIL    + " TEXT, " +
                ConstantesBaseDatos.TABLE_CONTACTS_FOTO     + " INTEGER " +
                ")";

        String queryCrearTablaLikesContacto = "CREATE TABLE " +ConstantesBaseDatos.TABLE_LIKES_CONTACT + "(" +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_CONTACTS + "(" + ConstantesBaseDatos.TABLE_CONTACTS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //usado para realizar migraciones en caso de ser necesario alterar la estructura de la tabla
    }
}
