
import java.util.ArrayList;
import java.util.List;
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
    private String _letraCorrecta;
    private ArrayList<Jugador> _listaDeJugadores;
    private String _listaLetras;

    public Juego() {
        this._listaDeJugadores = new ArrayList<>();
        this._listaLetras = "";
    }

    public ArrayList<Jugador> Jugadores() {
        return _listaDeJugadores;
    }

    public String Letra() {
        return _listaLetras;
    }

    public void setListaDeJugadores(ArrayList<Jugador> _listaDeJugadores) {
        this._listaDeJugadores = _listaDeJugadores;
    }

    public void setListaLetras(String _listaLetras) {
        this._listaLetras = _listaLetras;
    }

    public String getPalabraIngresada() {
        return _PalabraIngresada;
    }

    public void setPalabraIngresada(String _PalabraIngresada) {
        this._PalabraIngresada = _PalabraIngresada;
    }

    public String getPalabraCorrecta() {
        return _PalabraCorrecta;
    }

    public void setPalabraCorrecta(String _PalabraCorrecta) {
        this._PalabraCorrecta = _PalabraCorrecta;
    }

    public char getLetraIngresada() {
        return _letraIngresada;
    }

    public void setLetraIngresada(char _letraIngresada) {
        this._letraIngresada = _letraIngresada;
    }

    public String getLetraCorrecta() {
        return _letraCorrecta;
    }

    public void setLetraCorrecta(String _letraCorrecta) {
        this._letraCorrecta = _letraCorrecta;
    }

    char pedirLetra() {
        char retorno;

        System.out.println("Ingrese una letra: ");
        Scanner lector = new Scanner(System.in);//Rserva memoria en el heap

        retorno = lector.next(".").charAt(0);

        return retorno;
    }

    boolean comprobarLetra(char letraIngresada, String palabraCorrecta) {
        boolean retorno = false;
        boolean flag = false;

        for (int i = 0; i < palabraCorrecta.length(); i++) 
        {
            if (palabraCorrecta.charAt(i) == letraIngresada) 
            {
                this._PalabraIngresada += letraIngresada;
                retorno = true;
            }
        
            else
            {
                if(this._PalabraIngresada.charAt(i)!=' ')
                {
                    continue;                          
                }
                else
                {
                    this._PalabraIngresada+=" ";
                    this._listaLetras+= letraIngresada;
                }
            }            
        }

        return retorno ;
    }

public String Mostrar()
    {
        StringBuilder cadena = new StringBuilder();
        
        cadena.append("---------------------").append("\n");
        cadena.append("ANGRY CATS").append("\n");
        cadena.append("---------------------").append("\n");
        
        /*
        for (Letras unaLetra : _listaLetras)
        {
            if(unaLetra instanceof Letras)
            {
                cadena.append(((Letras) unaLetra).Mostrar());
            }
        }
        */
        return cadena.toString();
    }
    
}
