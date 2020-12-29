package com.example.prueba;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoRecarga {
    Context c;
    Recarga r;
    ArrayList<Recarga> lista;
    SQLiteDatabase sql;
    String bd = "BDRecargas";
    String tabla = "create table  if not exists recarga(id integer primary key autoincrement, numero text,valor text, operador text)";

    public daoRecarga(Context c) {
        this.c = c;
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        r = new Recarga();
    }

    public boolean insertarRecarga(Recarga r){
            ContentValues cv = new ContentValues();
            cv.put("numero", r.getNumero());
            cv.put("valor", r.getValor());
            cv.put("operador", r.getOperador());
            return (sql.insert("recarga", null, cv) > 0);
    }


    public ArrayList<Recarga> selectRecargas(){
        ArrayList<Recarga> lista = new ArrayList<Recarga>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from recarga", null);
        if(cr!=null && cr.moveToFirst()){
            do {
                Recarga r = new Recarga();
                r.setId(cr.getInt(0));
                r.setNumero(cr.getString(1));
                r.setValor(cr.getString(2));
                r.setOperador(cr.getString(3));
                lista.add(r);
            }while(cr.moveToNext());
        }
        return lista;
    }

}

