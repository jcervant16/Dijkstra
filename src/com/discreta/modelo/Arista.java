package com.discreta.modelo;

import com.discreta.gui.LineaArista;

public class Arista{
    private int idArista;
    private String nombreArista;
    private int distancia;//Distancia entre dos puntos
    private LineaArista lineaArista;//Ésta es la via representada graficamente    
    private boolean habilitado;

    public Arista(){
        this(-1,"");
    }
    public Arista(int idArista){
        this(-1,"");
    }
    public Arista(int idArista,String nombreArista){
        this(-1,"",1);
    }
    public Arista(int idArista,String nombreArista,int peso){
        this.idArista = idArista;
        this.nombreArista = nombreArista;
        this.distancia = peso;
        lineaArista = null;
        habilitado = true;
    }
    public void setIdArista(int idArista){
        this.idArista = idArista;
    }
    public int getIdArista(){
        return idArista;
    }
    public void setNombreArista(String nombreVia){
        this.nombreArista = nombreVia;
    }
    public String getNombreArista(){
        return nombreArista;
    }
    public void setPeso(int peso){
        this.distancia = peso;
    }
    public int getPeso(){
        return distancia;
    }
    public void setLineaArista(LineaArista lineaArista){
        this.lineaArista = lineaArista;
        if(lineaArista != null){
            this.lineaArista.setLongitud(distancia);
        }
    }
    public LineaArista getLineaArista(){
        return lineaArista;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
}
