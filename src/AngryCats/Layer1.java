/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.awt.AWTAccessor;

/**
 *
 * @author Mechu
 */
public class Layer1 extends JPanel{
    
    private Image _fondo;
    private Image _tituloJuego;
    JButton boton_cerrar;
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        try{
        _fondo= ImageIO.read(new File("space.jpg"));
        _tituloJuego= ImageIO.read(new File("angryCatsTitulo.png"));
        
        }
        catch(IOException e)
        {
            System.out.println("No se encontró la imagen");
        }
        
        setLayout(null);
        
        g.drawImage(_fondo, 0, 0, null); //OBSERVER= informar el progreso de conversion de la imagen
        g.drawImage(_tituloJuego, 90, 20, null);
        
        //NewListener oyente= new NewListener();
        
        JButton BotonJugar= new JButton(new ImageIcon("jugarBtn.png"));
        //DameTexto miEvento= new DameTexto();
        //miBoton.addActionListener(miEvento);
        BotonJugar.setFont(new Font("Aharoni", 1, 32));
        //BotonJugar.setSize(200, 100);
        BotonJugar.setBorder(null);
        BotonJugar.setBorderPainted(false);
        BotonJugar.setContentAreaFilled(false);
        BotonJugar.setFocusPainted(false);
        BotonJugar.setToolTipText("Juego nuevo");
        BotonJugar.setActionCommand("Jugar");
        BotonJugar.addActionListener(new ClickListener()); 
        //BotonJugar.addActionListener(oyente);
        
        BotonJugar.setBounds(660, 470, 350, 200);//x,y,tamaño
        add(BotonJugar);
        
        
        boton_cerrar= new JButton(new ImageIcon("CerrarBtn.png"));
        boton_cerrar.setFont(new Font("Aharoni", 1, 32));
        //BotonJugar.setSize(200, 100);
        boton_cerrar.setBorder(null);
        boton_cerrar.setBorderPainted(false);
        boton_cerrar.setContentAreaFilled(false);
        boton_cerrar.setFocusPainted(false);
        boton_cerrar.setToolTipText("Salir de Angry Cats");
        boton_cerrar.setActionCommand("Salir");
        boton_cerrar.addActionListener(new ClickListener()); 
        
        boton_cerrar.setBounds(120, 470, 360, 200);//x,y,tamaño
        add(boton_cerrar);
    }    
    
}      
  
    /*
    public Layer1()
    {
        setLayout(new GridLayout(3, 1));
        JPanel miLayer2= new JPanel();
        JPanel miLayer3= new JPanel();
        JPanel miLayer4= new JPanel();
        
        miLayer2.setLayout(new FlowLayout());
        miLayer3.setLayout(new FlowLayout());
        miLayer4.setLayout(new FlowLayout());
        
              
        //miLayer2.setBackground(Color.pink);
        
        JLabel texto1= new JLabel("Angry Cats");
        texto1.setFont(new Font("Aharoni", 1, 32));
        
        miLayer2.add(texto1);
        
        Imagen ImagenCat= new Imagen();
        add(ImagenCat);
       
        miLayer3.add(ImagenCat);
        
        
        
        JButton BotonJugar= new JButton("JUGAR");
        
        //DameTexto miEvento= new DameTexto();
        
        //miBoton.addActionListener(miEvento);
        BotonJugar.setFont(new Font("Aharoni", 1, 32));
        BotonJugar.setSize(200, 100);
        
        miLayer4.add(BotonJugar);
        
        add(miLayer2);
        add(miLayer3);
        add(miLayer4);
    }    
    */

