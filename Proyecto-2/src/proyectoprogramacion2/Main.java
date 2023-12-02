/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoprogramacion2;


import proyectoprogramacion2.JFrame.Inicio;

/**
 *
 * @author josue
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       RellenarListas r = new RellenarListas();
       
      r.RellenarListaPopular("&language=es-Es");
       
       r.RellenarListaTotal("&language=es-ES");
       //r.imprimirTodasLasPeliculas();
       
              java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
       
      
    }
}

    

