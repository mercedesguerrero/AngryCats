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
    
    public static String pathDiccionario = "Diccionario.xml";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FrameInicial miFrame= new FrameInicial();
                
        miFrame.setVisible(true);
                
        miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        generarListas();
        
         
    }

    public static void generarListas()
    {        
        Diccionario diccionarioCats = new Diccionario();
        diccionarioCats.AgregarPalabras();
        Diccionario.guardarArchivoDiccionario(diccionarioCats, pathDiccionario );

    }
    
    
}
