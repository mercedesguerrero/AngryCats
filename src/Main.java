
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author capacita_mecon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    private static final String SERIALIZED_FILE_NAME = "Palabras.xml";
    
    public static void main(String[] args) {
        
        Juego juego1 = new Juego();
        
        ArrayList<Jugador> listaJugadores = juego1.Jugadores();
        //ArrayList<Letras> listaLetras = juego1.Letra();
        
        Jugador ll1 = new Jugador("Leandro");
        
        listaJugadores.add(ll1);
        
        System.out.println(juego1.Mostrar());
        
        
        char letraAux;
                
        letraAux= juego1.pedirLetra();
        
        if(juego1.comprobarLetra(letraAux, "amar")== true)
        {
            System.out.println("Adivinaste!");
        }
        else
        {
            System.out.println("Mal!");
        }
        
        
       
    
        
        /*

        DVD bourneSeries = new DVD();
        bourneSeries.setMovies(palabrasList);

        serializarPeliculas(bourneSeries);

        //Lectura
        DVD lectura = deserializarPeliculas();

        System.out.println(lectura.toString());

        */
        
    }
    
}
