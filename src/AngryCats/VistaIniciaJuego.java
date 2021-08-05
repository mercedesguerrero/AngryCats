/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Mechu
 */
public class VistaIniciaJuego extends JPanel{
    
    private Image _fondo;
    private Image _tituloJuego;
    private int respuesta;
    private ImageIcon _catTyping;
    private FrameJuego JugarNuevaPartida;
    private FrameLoguearse Loguearse;
    private LogicLogin inicioDeSesion;
    private LogicJuego logicJuego;
    private boolean _estaLogueado;
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        try{
        _fondo= ImageIO.read(new File("space.jpg"));
        _tituloJuego= ImageIO.read(new File("angryCatsTitulo.png"));
        _catTyping= new ImageIcon("catTyping.gif");
        
        }
        catch(IOException e)
        {
            System.out.println("No se encontró la imagen");
        }
        
        setLayout(null);
        
        g.drawImage(_fondo, 0, 0, null); //OBSERVER= informar el progreso de conversion de la imagen
        g.drawImage(_tituloJuego, 90, 20, null);
        
        JButton BotonJugar= new JButton(new ImageIcon("jugarBtn.png"));
        BotonJugar.setFont(new Font("Aharoni", 1, 32));
        BotonJugar.setBorder(null);
        BotonJugar.setBorderPainted(false);
        BotonJugar.setContentAreaFilled(false);
        BotonJugar.setFocusPainted(false);
        BotonJugar.setToolTipText("Juego nuevo");
        BotonJugar.setActionCommand("Jugar");
        BotonJugar.setBounds(660, 470, 350, 200);//x,y,tamaño
        BotonJugar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Usuario usuario = null;
                Jugadores jugadores = null; 
                
                if(inicioDeSesion != null)
                {
                    usuario = inicioDeSesion.usuarioLogueado;
                    jugadores = inicioDeSesion.jugadoresAngryCats;
                }
                logicJuego = new LogicJuego(usuario, jugadores);
                JugarNuevaPartida= new FrameJuego(logicJuego);
                JugarNuevaPartida.setVisible(true);
                JOptionPane.showMessageDialog(null, "", "Ingresa letras y adivina el gatito", JOptionPane.INFORMATION_MESSAGE, _catTyping);
            }
        });
        
        add(BotonJugar);
        
        //JButton BotonLogIn= new JButton(new ImageIcon("LoginBtn.png"));
        JButton BotonLogIn= new JButton("Login");
        BotonLogIn.setBorder(null);
        BotonLogIn.setBorderPainted(false);
        BotonLogIn.setContentAreaFilled(false);
        BotonLogIn.setFocusPainted(false);
        BotonLogIn.setFont(new Font("Calibri", Font.BOLD, 20));
        BotonLogIn.setForeground(new Color(65, 228, 195));
        BotonLogIn.setToolTipText("Iniciar sesion");
        BotonLogIn.setActionCommand("LogIn");
        BotonLogIn.setBounds(760, 10, 350, 50);//x,y,tamaño
        BotonLogIn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                inicioDeSesion= new LogicLogin();
                Loguearse= new FrameLoguearse(inicioDeSesion);
                Loguearse.setVisible(true);
            }
        });
        
        add(BotonLogIn);
        
        JButton BotonCrearCuenta= new JButton("Crear cuenta");
        BotonCrearCuenta.setBorder(null);
        BotonCrearCuenta.setBorderPainted(false);
        BotonCrearCuenta.setContentAreaFilled(false);
        BotonCrearCuenta.setFocusPainted(false);
        BotonCrearCuenta.setFont(new Font("Calibri", Font.BOLD, 20));
        BotonCrearCuenta.setForeground(new Color(65, 228, 195));
        BotonCrearCuenta.setToolTipText("Crear nueva cuenta");
        BotonCrearCuenta.setActionCommand("CrearCuenta");
        BotonCrearCuenta.setBounds(890, 10, 350, 50);//x,y,tamaño
        BotonCrearCuenta.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Loguearse= new FrameLoguearse();
                //Loguearse.setVisible(true);
            }
        });
        
        add(BotonCrearCuenta);
        
        JButton boton_cerrar= new JButton(new ImageIcon("CerrarBtn.png"));
        boton_cerrar.setFont(new Font("Aharoni", 1, 32));
        //BotonJugar.setSize(200, 100);
        boton_cerrar.setBorder(null);
        boton_cerrar.setBorderPainted(false);
        boton_cerrar.setContentAreaFilled(false);
        boton_cerrar.setFocusPainted(false);
        boton_cerrar.setToolTipText("Salir de Angry Cats");
        boton_cerrar.setActionCommand("Salir");
        boton_cerrar.setBounds(120, 470, 360, 200);//x,y,tamaño
        boton_cerrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                respuesta = JOptionPane.showConfirmDialog(null, "Desea abandonar el juego?", "AngryCats", JOptionPane.YES_NO_OPTION);
                if (respuesta == 0)
                {
                    System.exit(0);
                }
            }
        });
        
        add(boton_cerrar);
    }

    
}      
  
    

