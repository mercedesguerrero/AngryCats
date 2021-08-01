/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 *
 * @author Mechu
 */
public class ManejadorDeArchivos {
    
    private final String _path;
    private String _msg;
    
    public ManejadorDeArchivos(String path){
        this._path= path;
    }
    
    public Object CargarObjetoDeArchivo(){
        
        try{
            FileInputStream file = new FileInputStream(_path);
            XMLDecoder decoder = new XMLDecoder(file);
            Object miObjeto= decoder.readObject();
            decoder.close();
            file.close();
            
            return miObjeto;
    
        }catch(IOException e){
            
            _msg= e.getMessage();
            System.out.println("ERROR- Archivo no encontrado" + _msg); 
            
            return null;
        }catch(ArrayIndexOutOfBoundsException e){
            _msg= e.getMessage();
            System.out.println("ERROR- El contenido del archivo no es válido" + _msg);
            
            return null;
        }
        
    }
    
    public void GuardarObjetoEnArchivo(Object miObjeto){
        
        try{
            FileOutputStream file = new FileOutputStream(_path);
            XMLEncoder encoder = new XMLEncoder(file);
            encoder.writeObject(miObjeto);
            encoder.close();
            file.close();
    
        }catch(IOException e){
            
            _msg= e.getMessage();
            System.out.println("ERROR- Archivo no encontrado" + _msg); 
        }
        
    }
    
    
}
