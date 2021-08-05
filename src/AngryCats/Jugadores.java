/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Mechu
 */
public class Jugadores {
    
    private ArrayList<Usuario> _listaDeJugadores;
    private static final String PATH = "Jugadores.xml";
    
    public Jugadores()
    {
        this._listaDeJugadores= new ArrayList<>();
    }

    public ArrayList<Usuario> getListaDeJugadores() {
        return _listaDeJugadores;
    }

    public void setListaDeJugadores(ArrayList<Usuario> _listaDeJugadores) {
        this._listaDeJugadores = _listaDeJugadores;
    }
    
    public static Jugadores CargarJugadores() throws JuegoException
    {
        
        ManejadorDeArchivos manejador = new ManejadorDeArchivos(PATH);
        Jugadores jugador = (Jugadores) manejador.CargarObjetoDeArchivo();
        
        if(jugador == null){
            throw new JuegoException("No hay jugadores para cargar");
            
        }else{
            return jugador;
        }
        
    }
    
    public static void guardarArchivoJugadores(Jugadores jugadores)
    {
        ManejadorDeArchivos manejador = new ManejadorDeArchivos(PATH);
        manejador.GuardarObjetoEnArchivo(jugadores);
        
    }

    public static Jugadores cargarJugadoresOld()
    {
        XMLDecoder decoder = null;

        try
        {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(PATH)));
        }
        catch (FileNotFoundException fileNotFound)
        {
            fileNotFound.getMessage();
            System.out.println("ERROR- file not found");
        }

        Jugadores nuevo = (Jugadores) decoder.readObject();

        return nuevo;
    }

}
