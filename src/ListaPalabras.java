
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author capacita_mecon
 */
public class ListaPalabras {

    private ArrayList<Palabra> lista;

    public ListaPalabras() {
        List palabrasList = new ArrayList();
    }

    public void generarLista() 
    {
        lista.add(new Palabra("cocina", 3));
        lista.add(new Palabra("amar", 3));
        lista.add(new Palabra("mesa", 3));
        lista.add(new Palabra("carton", 3));
        lista.add(new Palabra("caja", 3));
    }

    @Override
    public String toString() {
        String retorno = "";
        for (Palabra palabra : this.lista) {
            
            retorno += palabra.getPalabra() + "\n";
        }
        return retorno;
    }
    /*
 
    public static void serializarPalabras(DVD bourneSeries) 
    {
        XMLEncoder encoder = null;
     
        try {
               FileOutputStream fos = new FileOutputStream(SERIALIZED_FILE_NAME);
               BufferedOutputStream bos = new BufferedOutputStream(fos); 
            
            
               encoder = new XMLEncoder(bos);
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("ERROR: guardando dvds");
        }
        encoder.writeObject(bourneSeries);
        encoder.close();
    }

    public static DVD deserializarPeliculas() {
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado");
        }
        
        DVD peliculas = (DVD) decoder.readObject();

        return peliculas;
    }

     */
}
