package com.example.ifream;

import android.graphics.Bitmap;

public class ClasePrincipal {

    private String identificador;
    private Bitmap imagen;
    private String nombrePublicacion;
    private String autor;
    private String likes;

//    public ClasePrincipal(String nombrePublicacion, Bitmap imagen, String autor) {
//        this.imagen = imagen;
//        this.nombrePublicacion = nombrePublicacion;
//        this.autor = autor;
//    }

//    public ClasePrincipal(Bitmap imagen, String nombrePublicacion, String autor, String likes) {
//        this.imagen = imagen;
//        this.nombrePublicacion = nombrePublicacion;
//        this.autor = autor;
//        this.likes = likes;
//    }

    public ClasePrincipal(String identificador,Bitmap imagen, String nombrePublicacion, String likes) {
        this.identificador = identificador;
        this.imagen = imagen;
        this.nombrePublicacion = nombrePublicacion;
        this.likes = likes;
    }
    public ClasePrincipal(String identificador, Bitmap imagen, String nombrePublicacion, String likes, String autor ) {
        this.identificador = identificador;
        this.imagen = imagen;
        this.nombrePublicacion = nombrePublicacion;
        this.likes = likes;
        this.autor=autor;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public String getNombrePublicacion() {
        return nombrePublicacion;
    }

    public void setNombrePublicacion(String nombrePublicacion) {
        this.nombrePublicacion = nombrePublicacion;
    }

    public String getautor() {
        return autor;
    }

    public void setautor(String autor) {
        this.autor = autor;
    }
}
