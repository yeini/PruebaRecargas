package com.example.prueba;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListarRecargasActivity extends AppCompatActivity {

    ListView lista;
    daoRecarga dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_recargas);
        lista = findViewById(R.id.lista);

        dao = new daoRecarga(this);
        ArrayList <Recarga> l = dao.selectRecargas();

        ArrayList<String> list = new ArrayList<String>();
        for (Recarga r: l) {
            list.add(" #."+r.getNumero()+ ". Valor: $"+r.getValor()+ ". Operador: "+r.getOperador());
        }
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
        lista.setAdapter(a);

    }
}