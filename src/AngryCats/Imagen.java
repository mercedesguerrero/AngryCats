/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Mechu
 */
public class Imagen extends JPanel{
    
    private Image _imagen;
    
    public Image getImagen() {
        return _imagen;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        //File miImagen= new File("banderines.png");
        
        try{
        _imagen= ImageIO.read(new File("nyan_cat.gif"));
        }
        catch(IOException e)
        {
            System.out.println("No se encontró la imagen");
        }
        
        g.drawImage(_imagen, 350, 55, null); //OBSERVER= informar el progreso de conversion de la imagen
        
    } 
}
