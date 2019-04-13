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
    private String palabra_a_buscar;
    private String palabra_del_usuario = "";
    private int _cantAciertos;
    private int _cuentaErrores; //cantidad de errores que el usuario cometio hasta el momento

    private Diccionario diccionarioCats;

    private int _juegosGanados;
    private int _juegosJugados;
    
    public LogicJuego() throws DiccionarioException
    {
        this.diccionarioCats = Diccionario.cargarDiccionario(AngryCats.Main.pathDiccionario);
        nuevaPalabra();
        this._cantAciertos= 0;
        this._juegosGanados = 0;
        this._juegosJugados = 0;
        this._cuentaErrores= 0;
        this._cantFallosPermitidos = 6;  
    }
    
    public void nuevaPalabra() throws DiccionarioException
    {    
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

    public int getCantFallosPermitidos() {
        return _cantFallosPermitidos;
    }

    public void setCantFallosPermitidos(int _cantFallosPermitidos) {
        this._cantFallosPermitidos = _cantFallosPermitidos;
    }

    public int getCuentaErrores() {
        return _cuentaErrores;
    }

    public void setCuentaErrores(int _cuentaErrores) {
        this._cuentaErrores = _cuentaErrores;
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
        
        System.out.println("Palabra del usuario: " + this.getPalabra_del_usuario());

    }

    public boolean BuscaLetraEnPalabra(char letra)
    {
        StringBuilder buffer = new StringBuilder(this.palabra_del_usuario);
        boolean retorno = false; 
        String letra_a_validar= Character.toString(letra);        
        
        for (int i = 0; i < this.getPalabra_a_buscar().length(); i++)
        {
            if (letra_a_validar.equalsIgnoreCase(Character.toString(this.getPalabra_a_buscar().charAt(i))))
            {//la encontro, aca copio la letra en la posicion de la palabra encontrada
                buffer.setCharAt(i, letra);
                retorno = true;
            }
            else
            {
                this.setCuentaErrores(this._cuentaErrores +1);                
            }
        }
        this.setPalabra_del_usuario(buffer.toString());
        System.out.println(this.getPalabra_del_usuario());
 
        return retorno;
    }
    
    public boolean noQuedanIntentos() 
    {
        boolean retorno;
        
        if (_cuentaErrores == _cantFallosPermitidos) 
        {
            retorno= true;
        }
        else 
        {
            retorno= false;
        }
        
        return retorno;
    }

   
}
