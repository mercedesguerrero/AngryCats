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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mechu
 */
public class Diccionario {
    
    public ArrayList<String> miDiccionario;
    
    public Diccionario()
    {
        miDiccionario = new ArrayList<>();
    }
    
    public void AgregarPalabras()
    {
        miDiccionario.add("GARFIELD");
        miDiccionario.add("GRUMPYCAT");
        miDiccionario.add("SILVESTRE");
        miDiccionario.add("GOOSE");
        miDiccionario.add("GATURRO");
        miDiccionario.add("FELIX");
        miDiccionario.add("SALEM");
        miDiccionario.add("PUSHEEN");
        miDiccionario.add("KITTY");
    }
    
    public static void guardarArchivoDiccionario(Diccionario lista, String nombreArchivo)
    {
        XMLEncoder encoder = null;

        try
        {
            FileOutputStream file = new FileOutputStream(nombreArchivo);
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

    public static Diccionario cargarDiccionario(String nombreArchivo)
    {
        XMLDecoder decoder = null;

        try
        {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(nombreArchivo)));
        }
        catch (FileNotFoundException fileNotFound)
        {
            fileNotFound.getMessage();
            System.out.println("ERROR- file not found");
        }

        Diccionario nuevo = (Diccionario) decoder.readObject();

        return nuevo;
    }

    public void quitarPalabra(String nombre)
    {

        boolean encontrada = false;

        for (String palabra : this.miDiccionario)
        {
            if (nombre.equalsIgnoreCase(palabra))
            {
                this.miDiccionario.remove(palabra);
                encontrada = true;
            }
        }

        if (encontrada == false)
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

    public String getPalabraRandom() throws DiccionarioException
    {
        int nroRandom;

        if (this.miDiccionario.isEmpty())
        {
            throw new DiccionarioException("diccionario 100% usado");
        }
        else
        {
            nroRandom = Random_Intervalo(0, this.miDiccionario.size() - 1);
        }
        
        return this.miDiccionario.get(nroRandom);
    }

    // </editor-fold>
}
   
    

