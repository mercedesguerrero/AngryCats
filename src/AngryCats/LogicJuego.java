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
    private int _puntajeAcumulado;
    private Usuario usuarioLogueado;
    private Jugadores jugadores;
    private static final int PUNTAJE_ACIERTO = 50;
    private static final int PUNTAJE_A_RESTAR_POR_FALLO = 10;
    private int _cuentaErrores; //cantidad de errores que el usuario cometio hasta el momento
    private Diccionario diccionarioCats;
    private int respuesta;
    JTextArea _areaParaIngresarLetra;
    private ArrayList<Character> _letrasIngresadasList;
    private int _rondasGanadas;
    private int _rondasJugadas;
    
    public LogicJuego(Usuario usuario, Jugadores jugadores)
    {
        this._palabra_del_usuario= "";
        this._puntajeAcumulado = 0;
        this.usuarioLogueado= usuario;
        this.jugadores = jugadores;
        this._cuentaErrores= 0;
        this._cantFallosPermitidos= 6;  
        this._rondasGanadas = 0;
        this._rondasJugadas = 0;       
    }
    
    public void iniciarJuego()throws JuegoException
    {
        this.diccionarioCats = Diccionario.CargarDiccionario();
        iniciarRonda();
    }
    
    public void iniciarRonda()throws JuegoException
    {    
        _rondasJugadas += 1;
        _cuentaErrores = 0;
        _palabra_a_adivinar = this.diccionarioCats.getPalabraRandom();   
        System.out.println("Palabra a adivinar: " + this._palabra_a_adivinar);
        _letrasIngresadasList = new ArrayList<>();
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
    
    public int getPuntajeAcumulado() {
        return _puntajeAcumulado;
    }

    public void setPuntajeAcumulado(int _puntaje) {
        this._puntajeAcumulado = _puntaje;
    }
    
    public int getRondasGanadas() {
        return _rondasGanadas;
    }

    public void setRondasGanadas(int _rondasGanadas) {
        this._rondasGanadas = _rondasGanadas;
    }

    public int getRondasJugadas() {
        return this._rondasJugadas;
    }

    public void setRondasJugadas(int _rondasJugadas) {
        this._rondasJugadas = _rondasJugadas;
    }

    public ArrayList<Character> getLetrasIngresadasList() {
        return _letrasIngresadasList;
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
        this._cuentaErrores = error;
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
        System.out.println("Numero de ronda: " + this._rondasJugadas + "\nRondas ganadas: " + this._rondasGanadas);

        for (int i = 0; i < this._palabra_a_adivinar.length(); i++)
        {
            caracteres+= "_";
        }
        
        this.setPalabra_del_usuario(caracteres);
    }

    public boolean BuscaLetraEnPalabra(char letraIngresada)
    {
        boolean huboCoincidencia= false;
        
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
                    huboCoincidencia= true;
                    
                    _puntajeAcumulado += PUNTAJE_ACIERTO;
                    
                    StringBuilder aux = new StringBuilder(this.getPalabra_del_usuario());
                    aux.setCharAt(i, letraIngresada);
                    
                    setPalabra_del_usuario(aux.toString());
               
                    System.out.println("Letras a adivinar seteadas: " + getPalabra_del_usuario());

                }
            }
        }
        
        if(!huboCoincidencia)
        {
            _cuentaErrores += 1;
            _puntajeAcumulado -= PUNTAJE_A_RESTAR_POR_FALLO;
        }
        
        System.out.println("Puntaje: " + getPuntajeAcumulado());
            
        return huboCoincidencia;
    }
    
    public boolean AdivinoLaPalabra()
    {
        boolean retorno= false;
        
        if(this._palabra_a_adivinar.equalsIgnoreCase(this._palabra_del_usuario))
        {
            retorno= true;
            _rondasGanadas += 1;
            System.out.println("Adivinaste la palabra!!!");
            this.NoQuedanIntentos();
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
    
    public void NoQuedanIntentos() 
    {
        this.diccionarioCats.quitarPalabra(_palabra_a_adivinar);
        this.diccionarioCats.getMiListaDePalabras().forEach((palabra) -> {
        System.out.println("Palabra disponible: " + palabra);
        });
        
        ActualizarPuntajeUsuario();
    }
    
    private void ActualizarPuntajeUsuario()
    {
        if(usuarioLogueado != null && jugadores != null)
        {
            usuarioLogueado.setPuntaje(_puntajeAcumulado);
            
            Jugadores.guardarArchivoJugadores(jugadores);
        }
    }
    
    public void ChequeaPuntaje() 
    {
        if(_puntajeAcumulado < 0)
        {
            setPuntajeAcumulado(0);
        }
    }
    
    

   
}
