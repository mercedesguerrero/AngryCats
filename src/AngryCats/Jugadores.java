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
    
    private ArrayList<Usuario> _listaJugadores;
    private static String _path;
    
    public Jugadores()
    {
        this._listaJugadores= new ArrayList<>();
        _path= "Jugadores.xml";
    }
    
    public boolean AgregarJugador(Usuario unJugador)
    {
        boolean retorno= false;
        
        if(!EstaEnLaLista(unJugador))
        {
            this._listaJugadores.add(unJugador);
            retorno= true;
        }
        
        return retorno;
    }
    
    private boolean EstaEnLaLista(Usuario otroUsuario)
    {
        boolean retorno = false;
        
        for (Usuario unUsuario : _listaJugadores)
        {
            if(unUsuario.CompararUsuarios(otroUsuario))
            {
                retorno = true;
                break;
            }
        }
        
        return retorno;
    }
    
    public static void guardarArchivoJugadores(Jugadores lista)
    {
        XMLEncoder encoder = null;

        try
        {
            FileOutputStream file = new FileOutputStream(_path);
            BufferedOutputStream salida = new BufferedOutputStream(file);
            encoder = new XMLEncoder(salida);
        }
        catch (FileNotFoundException fileNotFound)
        {
            fileNotFound.getMessage();
            System.out.println("ERROR- file not found");
        }

        encoder.writeObject(lista);
        encoder.close();
    }

    public static Jugadores cargarJugadores()
    {
        XMLDecoder decoder = null;

        try
        {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(_path)));
        }
        catch (FileNotFoundException fileNotFound)
        {
            fileNotFound.getMessage();
            System.out.println("ERROR- file not found");
        }

        Jugadores nuevo = (Jugadores) decoder.readObject();

        return nuevo;
    }

    public boolean bajaJugador(Usuario unJugador)
    {
        boolean retorno= false;
        
        if(!EstaEnLaLista(unJugador))
        {
            this._listaJugadores.remove(unJugador);
            retorno= true;
        }
        else
        {
            System.out.println("No existe ese jugador");
        }

        return retorno;
    }
    
    public boolean modificaJugador(Usuario unJugador, String password)
    {
        boolean retorno= false;
        
        if(!EstaEnLaLista(unJugador))
        {
            unJugador.setPassword(password);
            retorno= true;
        }
        else
        {
            System.out.println("No existe ese jugador");
        }

        return retorno;
    }
}
