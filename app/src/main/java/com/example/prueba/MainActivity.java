package com.example.prueba;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button recargar, listausuarios,listarecargas;
    TextView nombre;
    EditText numero,confirmacionnumero,valor,confirmacionvalor;
    Spinner operador;

    int id=0;
    Usuario u;
    daoUsuario dao;
    Recarga r;
    daoRecarga daor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.nombre);
        numero = findViewById(R.id.numero);
        confirmacionnumero = findViewById(R.id.confirmacionnumero);
        valor = findViewById(R.id.valor);
        confirmacionvalor = findViewById(R.id.confirmacionvalor);
        operador = findViewById(R.id.operador);
        recargar = findViewById(R.id.recargar);
       /* listausuarios = findViewById(R.id.listausuarios);
        listarecargas = findViewById(R.id.listarecargas);*/

        recargar.setOnClickListener(this);
        listausuarios.setOnClickListener(this);
        listarecargas.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id = b.getInt("Id");
        dao = new daoUsuario(this);
        u = dao.getUsuarioById(id);
        daor = new daoRecarga(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recargar:

                String num = numero.getText().toString();
                String confnum=confirmacionnumero.getText().toString();
                String val=valor.getText().toString();
                String confval=confirmacionvalor.getText().toString();


                Recarga r = new Recarga();
                r.setNumero(numero.getText().toString());
                r.setValor(valor.getText().toString());
                r.setOperador(operador.getSelectedItem().toString());

                if(!r.isNull()) {//validar campos
                    Toast.makeText(this, "Error: Campos vacios!", Toast.LENGTH_LONG).show();
                }else if( !(num.length()== 10)) {
                    numero.setError("El numero debe tener 10 digitos");
                }else if( !(Integer.parseInt(val) > 0)) {
                    valor.setError("El valor debe ser mayor que cero");
                }else if(!validarNumeros(num,confnum)) {
                    numero.setError("los numeros no coinciden");
                    confirmacionnumero.setError("los numeros no coinciden");
                }else if (!validarvalores(val,confval)) {
                    valor.setError("los valores no coinciden");
                    confirmacionvalor.setError("los valores no coinciden");
                }else {
                    daor.insertarRecarga(r);
                    Toast.makeText(this, "Recarga Exitosa", Toast.LENGTH_SHORT).show();

                }
                break;



        }
    }
    private boolean validarNumeros(String numero, String confirmacionnumero ) {
        if(numero.equals(confirmacionnumero)){
            return true;
        }else{
            return false;
        }
    }
    private boolean validarvalores(String valor, String confirmacionvalor ) {
        if(valor.equals(confirmacionvalor)){
            return true;
        }else{
            return false;
        }
    }

}