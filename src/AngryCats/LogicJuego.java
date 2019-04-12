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
  
    private String _PalabraCorrecta;
    private int _cantFallosPermitidos;
    private int _totalIntentosIncorrectos;
    private String palabra_a_buscar;
    private String palabra_del_usuario = "";
    private int _cantFallos;
    private int _cantAciertos;

    private Diccionario diccionarioCats;

    private int _juegosGanados;
    private int _juegosJugados;
    
    public LogicJuego() throws DiccionarioException
    {
        this.diccionarioCats = Diccionario.cargarDiccionario(AngryCats.Main.pathDiccionario);
        nuevaPalabra();
        this._totalIntentosIncorrectos = 0;
        this._cantAciertos= 0;
        this._juegosGanados = 0;
        this._juegosJugados = 0;
    }
    
    public void nuevaPalabra() throws DiccionarioException
    {
        this._cantFallos = 0;
        this._cantFallosPermitidos = 6;      
        this.palabra_a_buscar = this.diccionarioCats.getPalabraRandom(); 
        generaMascara();
        System.out.println(this.palabra_a_buscar);
        System.out.println(this.palabra_del_usuario);
    }

    public String getPalabra_a_buscar()
    {
        return palabra_a_buscar;
    }

    public void setPalabra_a_buscar(String palabra_a_buscar)
    {
        this.palabra_a_buscar = palabra_a_buscar;
    }

    public String getPalabra_del_usuario()
    {
        return this.palabra_del_usuario;
    }

    public void setPalabra_del_usuario(String palabra_del_usuario)
    {
        this.palabra_del_usuario = palabra_del_usuario;
    }
    
    public int getJuegosGanados() {
        return _juegosGanados;
    }

    public void setJuegosGanados(int _juegosGanados) {
        this._juegosGanados = _juegosGanados;
    }

    public int getJuegosJugados() {
        return this._juegosJugados;
    }

    public void setJuegosJugados(int _juegosJugados) {
        this._juegosJugados = _juegosJugados;
    }

    public int getCantAciertos()
    {
        return _cantAciertos;
    }

    public void setCantAciertos(int cantAciertos)
    {
        this._cantAciertos = cantAciertos;
    }

    public Diccionario getDiccionarioCats()
    {
        return this.diccionarioCats;
    }

    public void setDiccionarioCats(Diccionario diccionarioCompleto)
    {
        this.diccionarioCats = diccionarioCompleto;
    }

    private void generaMascara()
    {
        this.palabra_del_usuario = new String();

        for (int i = 0; i < this.getPalabra_a_buscar().length(); i++)
        {
            this.palabra_del_usuario += " ";
        }
        
        System.out.println("Usuario palabra: " + this.getPalabra_del_usuario());

    }

    public int BuscaLetraEnPalabra(char letra)
    {
        StringBuilder buffer = new StringBuilder(this.palabra_del_usuario);
        int resp = 1; 
        String retorno= Character.toString(letra);        
        
        for (int i = 0; i < this.getPalabra_a_buscar().length(); i++)
        {
            if (retorno.equalsIgnoreCase(Character.toString(this.getPalabra_a_buscar().charAt(i))))
            {//la encontro, aca copio la letra en la posicion de la palabra encontrada
                buffer.setCharAt(i, letra);
                resp = 0;
            }
        }
        this.palabra_del_usuario= buffer.toString();
        System.out.println(this.palabra_del_usuario);
 
        return resp;
    }
    
    public boolean noQuedanIntentos() {
        boolean retorno;
        if (_totalIntentosIncorrectos == _cantFallosPermitidos) {
            retorno= true;
        }
        else {
            retorno= false;
        }
        
        return retorno;
    }

   
}
