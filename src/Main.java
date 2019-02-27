
import java.util.ArrayList;

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
    public static void main(String[] args) {
        
        Juego juego1 = new Juego();
        
        ArrayList<Jugador> listaJugadores = juego1.Jugadores();
        ArrayList<Letras> listaLetras = juego1.Letra();
        
        Jugador ll1 = new Jugador("Leandro");
        
        listaJugadores.add(ll1);
        
        char letraAux;
                
        letraAux= juego1.pedirLetra();
        
        juego1.comprobarLetra(letraAux, "amar");
        
    }
    
}
