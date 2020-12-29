package com.example.prueba;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd = "BDRecargas";
    String tabla = "create table  if not exists usuario(id integer primary key autoincrement, nombre text,tipo_documento text, documento text, correo text, clave text)";

    public daoUsuario(Context c) {
        this.c = c;
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuario();
    }

    public boolean insertarUsuario(Usuario u){
        if(buscar(u.getCorreo())== 0) {
            ContentValues cv = new ContentValues();
            cv.put("nombre", u.getNombre());
            cv.put("tipo_documento", u.getTipo_documento());
            cv.put("documento", u.getDocumento());
            cv.put("correo", u.getCorreo());
            cv.put("clave", u.getClave());
            return (sql.insert("usuario", null, cv) > 0);
        }else{
            return false;
        }
    }
    public int buscar(String u){
        int x=0;
        lista = selectUsuarios();
        for (Usuario us:lista){
            if(us.getCorreo().equals(u)) {
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if(cr!=null && cr.moveToFirst()){
            do {
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setTipo_documento(cr.getString(2));
                u.setDocumento(cr.getString(3));
                u.setCorreo(cr.getString(4));
                u.setClave(cr.getString(5));
                lista.add(u);
            }while(cr.moveToNext());
        }
        return lista;
    }


    public int login(String corr, String clav){
        int a = 0;
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if(cr != null && cr.moveToFirst()){
            do {
                if(cr.getString(4).equals(corr) && cr.getString(5).equals(clav)){
                    a++;
                }
            }while(cr.moveToNext());
        }return a;
    }

    public Usuario getUsuario(String corr, String clav){
        lista = selectUsuarios();
        for (Usuario usu:lista){
            if(usu.getCorreo().equals(corr) && usu.getClave().equals(clav)){
                return usu;
            }
        }
        return null;
    }

    public Usuario getUsuarioById(int id){
        lista = selectUsuarios();
        for (Usuario usu:lista){
            if(usu.getId() == id){
                return usu;
            }
        }
        return null;
    }

    public boolean UpdateUsuario (Usuario u){
        ContentValues cv = new ContentValues();
        cv.put("nombre", u.getNombre());
        cv.put("documento", u.getDocumento());
        cv.put("correo", u.getCorreo());
        cv.put("clave", u.getClave());
        return (sql.update("usuario", cv,"id="+u.getId(), null) > 0);
    }

}
