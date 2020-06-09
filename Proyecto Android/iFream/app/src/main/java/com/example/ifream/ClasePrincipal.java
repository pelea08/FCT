package com.example.ifream;

import android.graphics.Bitmap;
import android.media.Image;

public class ClasePrincipal {

    private String identificador;
    private Bitmap imagen;
    private String nombrePublicacion;
    private String autor;
    private String contadorVisitas;

//    public ClasePrincipal(String nombrePublicacion, Bitmap imagen, String autor) {
//        this.imagen = imagen;
//        this.nombrePublicacion = nombrePublicacion;
//        this.autor = autor;
//    }

//    public ClasePrincipal(Bitmap imagen, String nombrePublicacion, String autor, String contadorVisitas) {
//        this.imagen = imagen;
//        this.nombrePublicacion = nombrePublicacion;
//        this.autor = autor;
//        this.contadorVisitas = contadorVisitas;
//    }

    public ClasePrincipal(String identificador,Bitmap imagen, String nombrePublicacion, String contadorVisitas ) {
        this.identificador = identificador;
        this.imagen = imagen;
        this.nombrePublicacion = nombrePublicacion;
        this.contadorVisitas = contadorVisitas;
    }
    public ClasePrincipal(String identificador,Bitmap imagen, String nombrePublicacion, String contadorVisitas,String autor ) {
        this.identificador = identificador;
        this.imagen = imagen;
        this.nombrePublicacion = nombrePublicacion;
        this.contadorVisitas = contadorVisitas;
        this.autor=autor;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getContadorVisitas() {
        return contadorVisitas;
    }

    public void setContadorVisitas(String contadorVisitas) {
        this.contadorVisitas = contadorVisitas;
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
