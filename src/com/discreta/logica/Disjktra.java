package com.discreta.logica;

import com.discreta.AppMain;
import java.awt.Color;
import java.util.ArrayList;
import com.discreta.modelo.Arista;
import com.discreta.modelo.Enlace;
import com.discreta.modelo.Grafo;
import com.discreta.modelo.Nodo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Disjktra {

    AppMain main;
    Grafo grafo;
    ListaNodo nodosAdyacentes;
    ArrayList<Arista> aux = new ArrayList<Arista>();

    public Disjktra(Grafo grafo) {
        this.grafo = grafo;
        nodosAdyacentes = new ListaNodo();
    }

    private void llenarConAdyacentes(Nodo nodo) {
        if (nodo != null) {
            ArrayList<Enlace> listaAux = nodo.getListaNodoAdyacente();
            if (listaAux != null) {
                for (Enlace enlace : listaAux) {
                    Nodo aux2 = enlace.getNodo();
                    if (!aux2.isMarca()) {

                        if (nodosAdyacentes.isContenido(aux2)) {
                            int longitud = nodo.getLongitudCamino() + enlace.getArista().getPeso();
                            if (aux2.getLongitudCamino() > longitud) {
                                aux2.setLongitudCamino(longitud);
                                aux2.setNodoAntecesorDisjktra(nodo);
                            }
                        } else {
                            aux2.setLongitudCamino(nodo.getLongitudCamino() + enlace.getArista().getPeso());
                            aux2.setNodoAntecesorDisjktra(nodo);
                            nodosAdyacentes.add(aux2);
                        }

                    }
                }
            }
        }
    }

    public void ejecutar(Nodo nodoInicio) {
        nodoInicio.setLongitudCamino(0);
        System.out.println("NODO INICIO: "+nodoInicio.getCirculo().getEtiqueta());
        if (nodoInicio != null) {
            nodosAdyacentes = new ListaNodo();
            nodosAdyacentes.add(nodoInicio);
            while (!nodosAdyacentes.isEmpty()) {
                System.out.println("listaNodosAdyacentes: "+nodosAdyacentes+"|");
                Nodo menor = nodosAdyacentes.buscarMenor();
                menor.setMarca(true);
                nodosAdyacentes.remove(menor);
                llenarConAdyacentes(menor);
            }
        }
    }

    private void rutaCorta(Nodo nodoFinal) {
        aux.clear();
        Nodo nAux = nodoFinal;
        while (nAux.getNodoAntecesorDisjktra() != null) {
            aux.add(grafo.getArista(nAux, nAux.getNodoAntecesorDisjktra()));
            nAux = nAux.getNodoAntecesorDisjktra();
        }
    }

    public void marcarRutaCorta(Nodo nodoFinal, Color color, AppMain appmain) {
        if (nodoFinal != null) {
            rutaCorta(nodoFinal);
            for (int i = 0; i < aux.size(); i++) {
                if (!aux.isEmpty()) {
                    try {
                        aux.get(i).getLineaArista().setColor(color);
                        aux.get(i).getLineaArista().setGrosorLinea(5);
                        if (appmain != null) {
                            appmain.dibujarGrafo();    
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Disjktra.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    public void marcarRutaCorta(Nodo nodoFinal, Color color) {
        marcarRutaCorta(nodoFinal, color, null);
    }

}
