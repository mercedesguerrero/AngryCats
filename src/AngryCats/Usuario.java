/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

/**
 *
 * @author Mechu
 */
public class Usuario {
    
    private String _nombreUsuario;
    private String _password;
    private int _puntaje;
    
    public Usuario()
    {
        
    }
    
    public Usuario(String nombre, String password)
    {
        this._nombreUsuario= nombre;
        this._password= password;
    }

    public String getNombreUsuario() {
        return _nombreUsuario;
    }

    public void setNombreUsuario(String _nombreUsuario) {
        this._nombreUsuario = _nombreUsuario;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public int getPuntaje() {
        return _puntaje;
    }

    public void setPuntaje(int _puntaje) {
        this._puntaje = _puntaje;
    }
    
    public static void MostrarJugador(Usuario unUsuario)
    {
        System.out.println(unUsuario.getInfo());
    }
    
    public String getInfo() 
    {
        StringBuilder miCadena= new StringBuilder();
        
        miCadena.append("\n");
        miCadena.append(" Nombre: ").append(this.getNombreUsuario());
        miCadena.append(" || Puntaje: ").append(this.getPuntaje());
                
        return miCadena.toString();
    }
    
    protected boolean CompararUsuarios(Usuario unUsuario)
    {
        boolean retorno= false;
        
        if(this.getNombreUsuario().equalsIgnoreCase(unUsuario.getNombreUsuario()))
        {
            retorno= true;
        }
        
        return retorno;
    }

}
