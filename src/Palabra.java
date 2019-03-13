
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
public class Palabra {
    
    private String _palabra;
    private String _ayuda;
    private int _dificultad;
    
    public Palabra()
    {
        
    }
    
    public Palabra(String palabra, int dificultad)
    {
        this._palabra= palabra;
        this._dificultad= dificultad;
    }
    
    public Palabra(String ayuda)
    {
        this();
        this._ayuda= ayuda;
    }

    public String getPalabra() {
        return _palabra;
    }

    public void setPalabra(String _palabra) {
        this._palabra = _palabra;
    }

    public String getAyuda() {
        return _ayuda;
    }

    public void setAyuda(String _ayuda) {
        this._ayuda = _ayuda;
    }

    public int getDificultad() {
        return _dificultad;
    }

    public void setDificultad(int _dificultad) {
        this._dificultad = _dificultad;
    }
    
    public String toString()
    {
	Palabra palabra = null;
        
  
	return palabra.getPalabra()+"\n"; 
    }
    
	
    
}
