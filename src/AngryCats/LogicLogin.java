/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.util.ArrayList;

/**
 *
 * @author Mechu
 */
public class LogicLogin {
    
    public Jugadores jugadoresAngryCats;
    public Usuario usuarioLogueado;
    
     public void IniciarLogin() throws JuegoException
    {
        
        jugadoresAngryCats= Jugadores.CargarJugadores();
        
        for (Usuario user : jugadoresAngryCats.getListaDeJugadores()) {
            System.out.println("Usuario: " + user.getNombreUsuario() + " - Contraseña: " + user.getPassword());
        }
    }

    private Usuario BuscarUsuarioEnBase(String nombre, String password)
    {
        Usuario retorno= null;
        
        for (Usuario usuario : jugadoresAngryCats.getListaDeJugadores()) {
            if(usuario.getNombreUsuario().equals(nombre) && usuario.getPassword().equals(password))
            {
                retorno= usuario;
            }
        }
        
        return retorno;
    }
    
    private Usuario CrearCuenta(String nombre, String password)
    {
        Usuario usuario = new Usuario(nombre, password);
        
        jugadoresAngryCats.getListaDeJugadores().add(usuario);
        
        Jugadores.guardarArchivoJugadores(jugadoresAngryCats);
        
        return usuario;
    }
    
    public Usuario ProcesarUsuario(String nombre, String password)
    {
        Usuario usuario = BuscarUsuarioEnBase(nombre, password);
        
        if(usuario == null)
        {
            usuario = CrearCuenta(nombre, password);
        }
        
        usuarioLogueado = usuario;
        
        return usuario;
    }
}
