package com.discreta;

import com.discreta.modelo.Coordenadas;
import com.discreta.gui.LineaArista;
import com.discreta.modelo.Enlace;
import com.discreta.modelo.Nodo;
import com.discreta.modelo.Grafo;
import com.discreta.modelo.Arista;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.discreta.logica.Disjktra;

public class AppMain extends javax.swing.JFrame {

    Grafo grafo = new Grafo();
    Nodo nodoInicio = null;
    Nodo nodoFin = null;

    //init
    public AppMain() {
        initComponents();
        instrucciones.setText("El algoritmo de Dijkstra, es un algoritmo para la determinación del camino más corto dado un vértice origen al resto de vértices en un grafo con pesos en cada arista.\n"
                + "Para crear un nodo hacer Click en un lugar del recuadro de abajo. Darle un nombre al Nodo (ejemplo: A).\n"
                + "Para unir 2 nodos (vertice), hacer click en el primer nodo y luego click en el siguiente. Asignar un valor a la distancia.\n"
                + "Para calcular el camino mas corto, hacer click Derecho en el nodo origen y click derecho en el nodo final.");

        instrucciones.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanelInstrucciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        instrucciones = new javax.swing.JTextPane();
        jButtonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Algoritmo de Dijkstra"));

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        jPanelInstrucciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Instrucciones"));

        jScrollPane1.setViewportView(instrucciones);

        jButtonReset.setText("Reiniciar");
        jButtonReset.setToolTipText("");
        jButtonReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonResetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelInstruccionesLayout = new javax.swing.GroupLayout(jPanelInstrucciones);
        jPanelInstrucciones.setLayout(jPanelInstruccionesLayout);
        jPanelInstruccionesLayout.setHorizontalGroup(
            jPanelInstruccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanelInstruccionesLayout.createSequentialGroup()
                .addComponent(jButtonReset)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelInstruccionesLayout.setVerticalGroup(
            jPanelInstruccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInstruccionesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonReset)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelInstrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanelInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Algoritmo de Dijkstra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void dibujarGrafo() {
        jPanel1.paint(jPanel1.getGraphics());
        dibujarArista();
        dibujarNodos();
    }

    public void dibujarNodos() {
        ArrayList<Nodo> listaNodo = grafo.getListaNodos();
        for (Nodo nodo : listaNodo) {
            nodo.getCirculo().dibujarCirculo(jPanel1.getGraphics());
        }
    }

    public void dibujarArista() {
        ArrayList<Nodo> listaNodo = grafo.getListaNodos();
        for (Nodo nodo : listaNodo) {
            ArrayList<Enlace> listaEnlace = nodo.getListaNodoAdyacente();
            if (listaEnlace != null) {
                for (Enlace enlace : listaEnlace) {
                    enlace.getArista().getLineaArista().dibujarArista(jPanel1.getGraphics());
                }
            }
        }
    }

    private int ingresarPeso() {
        String peso = JOptionPane.showInputDialog("Longitus de la Arista");
        int intPeso = 0;
        try {
            intPeso = Integer.parseInt(peso);
        } catch (Exception ex) {
            intPeso = ingresarPeso();
        }
        return intPeso;
    }

    private void eliminarNodo(int x, int y) {
        if (grafo.buscarNodo(x, y) != null) {//si se hace clic sobre un nodo
            Nodo temp = grafo.buscarNodo(x, y);
            grafo.eliminarAristasEntrante(temp);
            if (grafo.eliminarNodo(temp)) {
                JOptionPane.showMessageDialog(null, "Eliminado");
                dibujarGrafo();
            }

        }
    }

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        int x = evt.getX();
        int y = evt.getY();
        if (evt.isMetaDown()) {
            if (grafo.buscarNodo(x, y) != null) {//si se hace clic sobre un nodo
                if (nodoInicio == null) {
                    grafo.reiniciarGrafoParaDisjktra();
                    grafo.reiniciarColores();
                    nodoInicio = grafo.buscarNodo(x, y);//nodoInicio lo pongo a apuntar al nodo donde hice clic
                    nodoInicio.getCirculo().setColor(Color.red);//Lo hago cambiar de color
                    nodoInicio.getCirculo().setGrosorBorde(5);
                    nodoInicio.getCirculo().setDiametro(25);
                } else {
                    nodoFin = grafo.buscarNodo(x, y);
                    Disjktra disjktra = new Disjktra(grafo);
                    disjktra.ejecutar(nodoInicio);
                    disjktra.marcarRutaCorta(nodoFin, Color.red, this);
                    nodoInicio = null;//null para poder crear mas arista
                    nodoFin = null;//null para poder crear mas arista
                }
            }
        } else {
            if (grafo.buscarNodo(x, y) != null) {//si se hace clic sobre un nodo
                if (nodoInicio == null) {
                    nodoInicio = grafo.buscarNodo(x, y);//nodoInicio lo pongo a apuntar al nodo donde hice clic
                    nodoInicio.getCirculo().setColor(Color.red);//Lo hago cambiar de color
                } else {//si nodoInicio ya estaba apunto a un nodo, lo preparo para crear arista             
                    nodoFin = grafo.buscarNodo(x, y);
                    crearArista();

                    nodoInicio.getCirculo().setColor(Color.yellow);//lo regreso a su color original

                    nodoInicio = null;
                    nodoFin = null;
                }
            } else {//Si no he hecho clic sobre un nodo
                crearNodo(x, y);//creo un nodo apartir de unas coordenadas
            }
        }
        dibujarGrafo();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButtonResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResetMouseClicked
        // TODO add your handling code here:
        System.out.println("reset");
        jPanel1.removeAll(); 
        jPanel1.updateUI();
        grafo = new Grafo();
    }//GEN-LAST:event_jButtonResetMouseClicked

    private void crearArista() {
        int intPeso = ingresarPeso();
        Arista arista = new Arista();
        arista.setPeso(intPeso);
        Coordenadas c = new Coordenadas(100000, 100000);
        c.addCoordenada(nodoInicio.getCirculo().getX() + (nodoInicio.getCirculo().getDiametro() / 2), nodoInicio.getCirculo().getY() + (nodoInicio.getCirculo().getDiametro() / 2));
        c.addCoordenada(nodoFin.getCirculo().getX() + (nodoInicio.getCirculo().getDiametro() / 2), nodoFin.getCirculo().getY() + (nodoInicio.getCirculo().getDiametro() / 2));
        LineaArista lq = new LineaArista(c);
        arista.setLineaArista(lq);
        grafo.crearEnlacesNoDirigido(nodoInicio, nodoFin, arista);

    }

    private void crearNodo(int x, int y) {
        Coordenadas c = new Coordenadas(100000, 100000, x, y);
        String dato = JOptionPane.showInputDialog("Nombre del Nodo");
        if (dato != null) {
            dato = dato.toUpperCase();//por que lo quiero todo en mayusculas
            Nodo nodo = new Nodo(dato, c);
            nodo.getCirculo().setDiametro(20);
            nodo.getCirculo().setEtiqueta(nodo.getDato() + "");
            if (grafo.adjuntarNodo(nodo)) {
                nodo.getCirculo().dibujarCirculo(jPanel1.getGraphics());
            } else {
            }
            nodoInicio = null;
            nodoFin = null;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AppMain().setVisible(true);
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane instrucciones;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelInstrucciones;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
