/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import javax.swing.JFrame;

/**
 *
 * @author Mechu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FrameInicial miFrame= new FrameInicial();
                
        miFrame.setVisible(true);
                
        miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Diccionario diccionarioCats = new Diccionario();
        
        Diccionario.guardarArchivoDiccionario(diccionarioCats);
        
        Jugadores jugadoresAngryCats = new Jugadores();
        
        Jugadores.guardarArchivoJugadores(jugadoresAngryCats);
        
    }
    
}
