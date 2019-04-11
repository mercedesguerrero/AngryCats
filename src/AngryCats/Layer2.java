/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Mechu
 */
public class Layer2 extends JPanel{
    
    private Image _fondo;
    JButton boton_cerrar;
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        //g.drawRect(50, 50, 200, 200);
        //g.drawLine(100, 100, 300, 200);
        
        try{
        _fondo= ImageIO.read(new File("space.jpg"));
        }
        catch(IOException e)
        {
            System.out.println("No se encontró la imagen");
        }
        
        g.drawImage(_fondo, 0, 0, null);
        
        boton_cerrar= new JButton("Cerrar");
        boton_cerrar.setFont(new Font("Aharoni", 1, 32));
        //BotonJugar.setSize(200, 100);
        boton_cerrar.setBorder(null);
        boton_cerrar.setBorderPainted(false);
        boton_cerrar.setContentAreaFilled(false);
        boton_cerrar.setFocusPainted(false);
        boton_cerrar.setMaximumSize(new java.awt.Dimension(200, 1055));
        boton_cerrar.setMinimumSize(new java.awt.Dimension(200, 1055));
        boton_cerrar.setPreferredSize(new java.awt.Dimension(200, 1055));
        
        add(boton_cerrar);
        
        NewListener oyente= new NewListener();
    }
    
    private class NewListener implements ActionListener{// CLASE INTERNA

        @Override
        public void actionPerformed(ActionEvent e) {

            Frame2 frame= new Frame2();
            
            //frame.setVisible(true);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
