/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mechu
 */
public class LogicJuego {
    
    private static ArrayList<String> miDiccionario;
    private String _PalabraIngresada;
    private String _PalabraParaAdivinar;
    private String _PalabraCorrecta;
    private char _letraIngresada;
    private char[] _letrasCorrectas;
    private int _valorMaxErrores= 6;
    private int _totalIntentosIncorrectos;
    private char[] _letrasIncorrectas;

    private static int _juegosGanados;
    private static int _juegosJugados;
    
    public LogicJuego()
    {
        _totalIntentosIncorrectos = 0;
        _juegosGanados = 0;
        _juegosJugados = 0;
        miDiccionario = new ArrayList<>();
    }

    public char[] getLetrasCorrectas() {
        return _letrasCorrectas;
    }

    public char[] getLetrasIncorrectas() {
        return _letrasIncorrectas;
    }

    public static int getJuegosGanados() {
        return _juegosGanados;
    }

    public static void setJuegosGanados(int _juegosGanados) {
        LogicJuego._juegosGanados = _juegosGanados;
    }

    public static int getJuegosJugados() {
        return _juegosJugados;
    }

    public static void setJuegosJugados(int _juegosJugados) {
        LogicJuego._juegosJugados = _juegosJugados;
    }

    
    
    public void Serializar()
    {
        miDiccionario.add("GARFIELD");
        miDiccionario.add("GRUMPY CAT");
        miDiccionario.add("SILVESTRE");
        miDiccionario.add("GOOSE");
        miDiccionario.add("GATURRO");
        
        try{
            
            ObjectOutputStream escribiendo_fichero= new ObjectOutputStream(new FileOutputStream("diccionario.xml"));
            escribiendo_fichero.writeObject(miDiccionario);
            escribiendo_fichero.close();
            
            ObjectInputStream recuperar_fichero= new ObjectInputStream(new FileInputStream("empleado.xml"));
            String[] diccionarioRecuperado= (String[]) recuperar_fichero.readObject();
            recuperar_fichero.close();
            
            for (String palabra : diccionarioRecuperado) 
            {
                System.out.println(palabra);
            }
            
        }catch(Exception e){
            
            System.out.println("No se pudo escribir en el archivo");
        }
    }
    
    public String getPalabraRandom() {

        Random randomP = new Random();
        _PalabraParaAdivinar = miDiccionario.get(randomP.nextInt(miDiccionario.size()));
                
        setLetrasCorrectas(_PalabraParaAdivinar);
        setLetrasInCorrectas(_PalabraParaAdivinar);
        _totalIntentosIncorrectos = 0;
        _juegosJugados++;

        return _PalabraParaAdivinar;
    }

    public void Jugar() 
    {
        _PalabraCorrecta= getPalabraRandom();

        letrasCorrectasToString();         
        
    }
    
    public boolean comprobarLetra(char letraIngresada) {
        boolean retorno = false;
        boolean flag = false;

        for (int i = 0; i < _PalabraParaAdivinar.length(); i++) 
        {
            if (_PalabraParaAdivinar.charAt(i) == letraIngresada) 
            {
                this._PalabraIngresada += letraIngresada;
                System.out.println("acerto");
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
                    //this._listaLetras+= letraIngresada;
                }
            }            
        }

        return retorno ;
    }
    
    public boolean llenarAdivinanza(String palabra, char adivina) 
    {
        boolean found = false;

        for (int i = 0; i < palabra.length(); i++) 
        {
            if (palabra.charAt(i) == adivina) 
            {
                found = true;
                buscaAciertoEnPalabra(palabra, adivina, i);
            }
        }
        if (!found) 
        {
            addIntentosIncorrectos(adivina);
        }
        
        return found;
    }
    
    public boolean noQuedanIntentos() {
        boolean retorno;
        if (_totalIntentosIncorrectos == _valorMaxErrores) {
            retorno= true;
        }
        else {
            retorno= false;
        }
        
        return retorno;
    }
    
    public void setLetrasCorrectas(String palabra) 
    {
        _letrasCorrectas = new char[palabra.length()];
        
        for (int i = 0; i < _letrasCorrectas.length; i++) 
        {
            _letrasCorrectas[i] = '_';
        }
    }

    private void setLetrasInCorrectas(String palabra) 
    {
        _letrasIncorrectas = new char[_valorMaxErrores];

        for (int i = 0; i < _letrasIncorrectas.length; i++) 
        {
            _letrasIncorrectas[i] = ' ';
        }
    }

    public void buscaAciertoEnPalabra(String palabra, char adivina, int i) {

        if (0 <= i && i < palabra.length() && palabra.charAt(i) == adivina) {
            _letrasCorrectas[i] = adivina;
        }

    }

    public boolean addIntentosIncorrectos(char letraAdivinada) {

        if (_letrasIncorrectas[_totalIntentosIncorrectos] == ' ') 
        {
            _letrasIncorrectas[_totalIntentosIncorrectos] = letraAdivinada;
            _totalIntentosIncorrectos++;
        }

        if (_letrasIncorrectas[_letrasIncorrectas.length - 1] == ' ' && _totalIntentosIncorrectos< _valorMaxErrores) 
        {
            return false; //no todos los intentos posibles fueron usadsos
        }
        else {
            return true; //no tiene mas intentos posibles
        }
    }

   
    public boolean palabraAdivinada() {

        boolean comprueba = true;

        for (int i = 0; i < _letrasCorrectas.length; i++) 
        {
            if (_letrasCorrectas[i] == '_') 
            {
                comprueba = false;
            }
        }

        if (comprueba) 
        {
            _juegosGanados++;
        }

        return comprueba;
    }

    public String letrasIncorrectasToString() {
        String adivinanzaIncorrecta = "";

        for (int i = 0; i < _letrasIncorrectas.length; i++) 
        {
            adivinanzaIncorrecta += _letrasIncorrectas[i] + " ";
        }

        return adivinanzaIncorrecta;
    }

    public String letrasCorrectasToString() {
        String adivinanzaCorrecta = "";

        for (int i = 0; i < _letrasCorrectas.length; i++) 
        {
            adivinanzaCorrecta += _letrasCorrectas[i] + "   ";
        }
        
        return adivinanzaCorrecta;
    }
}
