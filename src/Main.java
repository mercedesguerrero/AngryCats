
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
        ArrayList<Letras> listaLetras = juego1.Letra();
        
        Jugador ll1 = new Jugador("Leandro");
        
        listaJugadores.add(ll1);
        
        char letraAux;
                
        letraAux= juego1.pedirLetra();
        
        juego1.comprobarLetra(letraAux, "amar");
        
        Palabra p0 = new Palabra("cocina");
        Palabra p1 = new Palabra("amar");
        Palabra p2 = new Palabra("mesa");
        Palabra p3 = new Palabra("carton");
        Palabra p4 = new Palabra("caja");
        
        List palabrasList = new ArrayList();
        
        palabrasList.add(p1);
        palabrasList.add(p2);
        palabrasList.add(p3);
        palabrasList.add(p4);

        DVD bourneSeries = new DVD();
        bourneSeries.setMovies(palabrasList);

        serializarPeliculas(bourneSeries);

        //Lectura
        DVD lectura = deserializarPeliculas();

        System.out.println(lectura.toString());
        
    }
    
    public static void serializarPeliculas(DVD bourneSeries) {
        XMLEncoder encoder = null;
        
     
        try {
               FileOutputStream fos = new FileOutputStream(SERIALIZED_FILE_NAME);
               BufferedOutputStream bos = new BufferedOutputStream(fos); 
            
            
               encoder = new XMLEncoder(bos);
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("ERROR: guardando dvds");
        }
        encoder.writeObject(bourneSeries);
        encoder.close();
    }

    public static DVD deserializarPeliculas() {
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado");
        }
        
        DVD peliculas = (DVD) decoder.readObject();

        return peliculas;
    }
    
}
