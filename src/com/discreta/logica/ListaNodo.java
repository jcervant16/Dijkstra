package com.discreta.logica;

import java.util.ArrayList;
import com.discreta.modelo.Nodo;

public class ListaNodo extends ArrayList<Nodo>{

    public ListaNodo(){
        super();
    }
    public Nodo buscarMenor(){
        Nodo aux = new Nodo();
        aux.setLongitudCamino(9999999);

        for(Nodo nodo:this){
            if(nodo.getLongitudCamino() < aux.getLongitudCamino()){
                aux = nodo;                
            }
        }
        return aux;
    }
    
    public boolean isContenido(Nodo nodo){
        boolean retornado = false;
        for(Nodo n:this){
            if(n == nodo){
                retornado = true;
            }
        }
        return retornado;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(Nodo n:this){
            sb.append(n.getCirculo().getEtiqueta());
        }
        return sb.toString();
    }
}