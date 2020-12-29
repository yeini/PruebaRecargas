package com.example.prueba;


public class Usuario {
    int id;
    String nombre;
    String tipo_documento;
    String documento;
    String correo;
    String clave;

    public Usuario() {
    }

    public Usuario(String nombre, String tipo_documento, String documento, String correo, String clave) {
        this.nombre = nombre;
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.correo = correo;
        this.clave = clave;
    }

    public boolean isNull(){
        if(nombre.equals("") || documento.equals("") || correo.equals("") || clave.equals("")){
            return false;
        }else{
            return true;
        }
    }


    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo_documento='" + tipo_documento + '\'' +
                ", documento='" + documento + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

