
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author capacita_mecon
 */
public class Juego {
    
    private String _PalabraIngresada;
    private String _PalabraCorrecta;
    private char _letraIngresada;
    private char _letraCorrecta;
    private ArrayList<Jugador> _listaDeJugadores;
    private ArrayList<Letras> _listaLetras;
    
    public Juego()
    {
        this._listaDeJugadores = new ArrayList<>();
        this._listaLetras = new ArrayList<>();
    }
    
    public ArrayList<Jugador> Jugadores()
    {
        return _listaDeJugadores;
    }
    
    public ArrayList<Letras> Letra()
    {
        return _listaLetras;
    }
    
    char pedirLetra()
    {
        char retorno;
        
        System.out.println("Ingrese una letra: ");
        Scanner lector= new Scanner(System.in);//Rserva memoria en el heap

        retorno= lector.next(".").charAt(0);
        
        return retorno;
    }
    
    boolean comprobarLetra(char letraIngresada, String palabraCorrecta)
    {
        boolean retorno= false;
        
        for(int i=0; i<palabraCorrecta.length(); i++)
        {
            if(palabraCorrecta.charAt(i) == letraIngresada)
            {
                
                retorno= true;
            }
        }
        
        return retorno;
    }
    
    public String Mostrar()
    {
        StringBuilder cadena = new StringBuilder();
        
        cadena.append("---------------------").append("\n");
        cadena.append("ANGRY CATS").append("\n");
        cadena.append("---------------------").append("\n");
        
        
        for (Letras unaLetra : _listaLetras)
        {
            if(unaLlamada instanceof Local)
            {
                cadena.append(((Local) unaLlamada).Mostrar());
            }
            else if(unaLlamada instanceof Provincial)
            {
                cadena.append(((Provincial) unaLlamada).Mostrar());
            }
        }
        return cadena.toString();
    }
    
}
