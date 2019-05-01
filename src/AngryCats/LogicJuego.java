/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Mechu
 */
public class LogicJuego {
  
    private int _cantFallosPermitidos;
    private String _palabra_a_adivinar;
    private String _palabra_del_usuario;
    private int _cantAciertos;
    private int _cuentaErrores; //cantidad de errores que el usuario cometio hasta el momento
    private Diccionario diccionarioCats;
    private int respuesta;
    JTextArea _areaParaIngresarLetra;
    private final ArrayList<Character> _letrasIngresadasList;
    private int _juegosGanados;
    private int _juegosJugados;
    
    public LogicJuego() throws XMLException
    {
        this.diccionarioCats = Diccionario.cargarDiccionario();
        this._palabra_del_usuario= "";
        this._cantAciertos= 0;
        this._cuentaErrores= 0;
        this._cantFallosPermitidos= 6;  
        this._letrasIngresadasList = new ArrayList<>();
        this._juegosGanados = 0;
        this._juegosJugados = 0;
        nuevaPalabra();
    }
    
    private void nuevaPalabra() throws XMLException
    {    
        this._palabra_a_adivinar = this.diccionarioCats.getPalabraRandom();   
        generarMascara();
    }

    public String getPalabra_a_adivinar()
    {
        return _palabra_a_adivinar;
    }

    public void setPalabra_a_adivinar(String _palabra_a_adivinar)
    {
        this._palabra_a_adivinar= _palabra_a_adivinar;
    }

    public String getPalabra_del_usuario() {
        return _palabra_del_usuario;
    }

    public void setPalabra_del_usuario(String _palabra_del_usuario) {
        this._palabra_del_usuario = _palabra_del_usuario;
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

    public ArrayList<Character> getLetrasIngresadasList() {
        return _letrasIngresadasList;
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

    public void setCuentaErrores(int error) {
        this._cuentaErrores += error;
    }

    
    public Diccionario getDiccionarioCats()
    {
        return this.diccionarioCats;
    }

    public void setDiccionarioCats(Diccionario diccionarioCompleto)
    {
        this.diccionarioCats = diccionarioCompleto;
    }
    
    public boolean esLetra(char letra)
    {
        boolean retorno= false;
        
        if(Character.isLetter(letra))
        {
            retorno=true;
        }
        
        return retorno;
    }
    
    public void AgregarLetraIngresada(char letraIngresada)
    {
        this._letrasIngresadasList.add(letraIngresada);
    }
    
    public boolean LetraEstaEnLaLista(char letraIngresada)
    {
        boolean retorno= false;
        
        for (Character letra : _letrasIngresadasList) 
        {
            if(letra== letraIngresada)
            {
                retorno= true;
            }
        }
        return retorno;
    }
    
    public char Caracter_a_Mayuscula(char letra)
    {
        char aux;
        
        String cadenaAux= String.valueOf(letra).toUpperCase();
        aux= cadenaAux.charAt(0);
        
        return aux;
    }

    private void generarMascara()
    {
        String caracteres= "";
        System.out.println("Cantidad de letras a adivinar: " + this._palabra_a_adivinar.length());
        System.out.println("Palabra a adivinar: " + this._palabra_a_adivinar);

        for (int i = 0; i < this._palabra_a_adivinar.length(); i++)
        {
            caracteres+= "_";
        }
        
        this.setPalabra_del_usuario(caracteres);
    }

    public boolean BuscaLetraEnPalabra(char letraIngresada)
    {
        boolean retorno= false;
        
        this.AgregarLetraIngresada(letraIngresada);
        
        for (int i = 0; i < this._palabra_a_adivinar.length(); i++)//-1=????
        {
            System.out.println(" --- \nLetra a buscar: " + _palabra_a_adivinar.charAt(i) );
            System.out.println("Letra ingresada: " + letraIngresada);     
                        
            if (this._palabra_a_adivinar.charAt(i) == letraIngresada)
            {  
                if (this._palabra_del_usuario.charAt(i) != '_')
                {
                    JOptionPane.showMessageDialog(null, "Ya ingresaste la letra " + letraIngresada);
                    break;
                }
                else
                {
                    retorno= true;
                    
                    StringBuilder aux = new StringBuilder(this.getPalabra_del_usuario());
                    aux.setCharAt(i, letraIngresada);
                    
                    setPalabra_del_usuario(aux.toString());
               
                    System.out.println("Letras a adivinar seteadas: " + getPalabra_del_usuario());

                }
            }
        }
        
        return retorno;
    }
    
    public boolean AdivinoLaPalabra()
    {
        boolean retorno= false;
        
        if(this._palabra_a_adivinar.equalsIgnoreCase(this._palabra_del_usuario))
        {
            retorno= true;
            System.out.println("GANASTE!!!");
        }
        
        return retorno;
    }
    
    public boolean noQuedanIntentos() 
    {
        boolean retorno= false;
        
        if (this._cuentaErrores > this._cantFallosPermitidos) 
        {
            retorno= true;
        }
        
        return retorno;
    }
    
    public boolean QuedanIntentos() 
    {
        boolean retorno= false;
        if (this._cuentaErrores <= this._cantFallosPermitidos) 
        {
            retorno= true;
        }
        
        return retorno;
    }
   
}
