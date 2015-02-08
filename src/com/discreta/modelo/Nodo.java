package com.discreta.modelo;

import com.discreta.gui.CirculoNodo;
import java.util.ArrayList;

public class Nodo{
    private Object dato;
    private ArrayList<Enlace> nodosAdyacentes;
    private boolean visitado = false;    
    private CirculoNodo circulo;
    private int     izquierda;
    
    //estos campos los utiliza el Algoritmo de Disjktra
    private int     longitudCamino; 
    private Nodo    nodoAntecesorDisjktra; 
    private boolean marca;

    public Nodo(){
        this.dato = new Object();
        circulo = null;
        izquierda = 0;
        inicializarParaDisjktra();
    }

    private void inicializarParaDisjktra(){
        longitudCamino = -1;
        nodoAntecesorDisjktra = null;
        marca = false;
    }

    public Nodo(Object dato,Coordenadas coordenada){
        this.dato = dato;
        nodosAdyacentes = new ArrayList<Enlace>();
        circulo = new CirculoNodo(coordenada);
        circulo.setIzquierda(izquierda);
        inicializarParaDisjktra();
    }

    public void setDato(Object dato){
        this.dato = dato;
    }
    public Object getDato(){
        return this.dato;
    }
    public ArrayList<Enlace> getListaNodoAdyacente(){
        ArrayList<Enlace> listAristaAux = null;
        if(!nodosAdyacentes.isEmpty()){
            listAristaAux = new ArrayList<Enlace>();
            for(Enlace enlace:nodosAdyacentes){
                if(enlace.getArista().isHabilitado()){
                    listAristaAux.add(enlace);
                }
            }
        }        
        return listAristaAux;
    }

   public void addNodoAdyacente(Enlace arista){
        nodosAdyacentes.add(arista);
    }
    public void addNodoAdyacente(Arista via,Nodo nodo){
        this.addNodoAdyacente(new Enlace(via,nodo));
    }
    public void setVisitado(boolean visitado){
        this.visitado = visitado;
    }
    public boolean isVisitado(){
        return visitado;
    }
    
    public CirculoNodo getCirculo() {
        return circulo;
    }

    public void setCirculo(CirculoNodo circulo) {
        this.circulo = circulo;
    }

    public int getLongitudCamino() {
        return longitudCamino;
    }

    public void setLongitudCamino(int longitudCamino) {
        this.longitudCamino = longitudCamino;
    }

    public boolean isMarca() {
        return marca;
    }

    public void setMarca(boolean marca) {
        this.marca = marca;
    }

    public Nodo getNodoAntecesorDisjktra() {
        return nodoAntecesorDisjktra;
    }

    public void setNodoAntecesorDisjktra(Nodo nodoAntecesorDisjktra) {
        this.nodoAntecesorDisjktra = nodoAntecesorDisjktra;
    }
    
}