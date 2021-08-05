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
import java.util.Random;

/**
 *
 * @author Mechu
 */
public class Diccionario implements java.io.Serializable {
    
    private ArrayList<String> miListaDePalabras;
    private static final String PATH= "Diccionario.xml";
    
    public Diccionario()
    {
        miListaDePalabras = new ArrayList<>();
    }

    public static Diccionario CargarDiccionario() throws JuegoException
    {
        ManejadorDeArchivos manejador = new ManejadorDeArchivos(PATH);
        Diccionario diccionario = (Diccionario) manejador.CargarObjetoDeArchivo();
        
        if(diccionario == null){
            throw new JuegoException("No hay palabras para adivinar");
            
        }else{
            return diccionario;
        }
        
        /*
        miListaDePalabras.add("GARFIELD");
        miListaDePalabras.add("GRUMPYCAT");
        miListaDePalabras.add("SILVESTRE");
        miListaDePalabras.add("GOOSE");
        miListaDePalabras.add("GATURRO");
        miListaDePalabras.add("FELIX");
        miListaDePalabras.add("SALEM");
        miListaDePalabras.add("PUSHEEN");
        miListaDePalabras.add("KITTY");
        miListaDePalabras.add("BONGOCAT");
        
        */

    }
    
    public ArrayList<String> getMiListaDePalabras() {
        return miListaDePalabras;
    }

    public void setMiListaDePalabras(ArrayList<String> miListaDePalabras) {
        this.miListaDePalabras = miListaDePalabras;
    }
    
    @Override
    public String toString() {
        StringBuilder salida = new StringBuilder();
        for (String unaPalabra : this.miListaDePalabras) {
            salida.append(unaPalabra).append("\n");
        }

        return salida.toString();
    }
    /*
    public void guardarArchivoDiccionario()
    {
        XMLEncoder encoder = null;

        try
        {
            FileOutputStream file = new FileOutputStream(PATH);
            BufferedOutputStream salida = new BufferedOutputStream(file);
            encoder = new XMLEncoder(salida);
        }
        catch (FileNotFoundException fileNotFound)
        {
            fileNotFound.getMessage();
            System.out.println("ERROR- file not found");
        }

        encoder.writeObject(miListaDePalabras);
        encoder.close();
    }

    public static Diccionario cargarDiccionario()
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

        Diccionario nuevo = (Diccionario) decoder.readObject();

        return nuevo;
    }
    */
    public void quitarPalabra(String palabra_a_quitar)
    {
        if (!this.miListaDePalabras.remove(palabra_a_quitar))
        {
            System.out.println("La palabra no esta en el diccionario");
        }

    }
    
    public static int Random_Intervalo(int min, int max)
    {
        Random random = new Random();
        int numero = random.nextInt(max + 1 - min) + min;
        return numero;
    }

    public String getPalabraRandom() throws JuegoException
    {
        int nroRandom;

        if (this.miListaDePalabras.isEmpty())
        {
            throw new JuegoException("No hay palabras disponibles");
        }
        else
        {
            nroRandom = Random_Intervalo(0, this.miListaDePalabras.size() - 1);
        }
        
        return this.miListaDePalabras.get(nroRandom);
    }

}
   
    

