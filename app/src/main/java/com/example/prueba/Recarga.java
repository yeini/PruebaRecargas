package com.example.prueba;

public class Recarga {
    int id;
    String numero;
    String valor;
    String operador;

    public Recarga() {
    }

    public Recarga(String numero, String valor, String operador) {
        this.numero = numero;
        this.valor = valor;
        this.operador = operador;
    }

    public boolean isNull(){
        if(numero.equals("") || valor.equals("") || operador.equals("")){
            return false;
        }else{
            return true;
        }
    }


    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", valor='" + valor + '\'' +
                ", operador='" + operador + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
}
