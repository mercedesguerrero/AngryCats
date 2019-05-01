/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Mechu
 */
public class Logueo extends JPanel {
    
    private Image _fondo;
    private Image _gatitoEnojado;
    private Jugadores jugadoresAngryCats;
    private JTextField _campoNombre;
    private JPasswordField _campoPassword;
    private ImageIcon _nyanCat;
    private final String sonidoCatSuperAngry= "superAngry.wav";
    private final String sonidoGano = "Piipiripipipiiii.wav";
    private final String sonidoPerdio = "angryCatSonido.wav";
    private final String sonidoMiau = "miau.wav";
    
    public Logueo()
    {   
        try
        {
            Loguearse();  
        }
        catch (XMLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Error Lista de Jugadores- no se encuentra el archivo");
        }
    }
    
    private void Loguearse() throws XMLException
    {
        this.jugadoresAngryCats = Jugadores.cargarJugadores();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        try{
        _fondo= ImageIO.read(new File("space.jpg"));
        _nyanCat= new ImageIcon("nyanKitten.gif");
        }
        catch(IOException e)
        {
            System.out.println("No se encontró la imagen");
        }
        
        setLayout(null);
        
        g.drawImage(_fondo, 0, 0, null);
        
        Graphics2D palabra= (Graphics2D) g;
        palabra.setFont(new Font("Calibri", Font.BOLD, 20));
        palabra.setColor(new Color(65, 228, 195));
        palabra.drawString("Nombre de usuario: ", 200, 100);
        
        _campoNombre= new JTextField("", 30); //texto por defecto + columnas
        _campoNombre.setFont(new Font("Aharoni", Font.BOLD, 20));
        _campoNombre.setForeground(new Color(38, 74, 90));
        _campoNombre.setToolTipText("Escriba un nombre de usuario");
        _campoNombre.setBounds(400, 70, 250, 45);//x,y,tamaño
        _campoNombre.setBackground(new Color(237, 143, 196));
        _campoNombre.setRequestFocusEnabled(true);
        add(_campoNombre);

        palabra.drawString("Contraseña: ", 270, 160);
        _campoPassword= new JPasswordField(30);
        _campoPassword.setFont(new Font("Aharoni", Font.BOLD, 20));
        _campoPassword.setForeground(new Color(38, 74, 90));
        _campoPassword.setToolTipText("Escriba su contraseña");
        _campoPassword.setBounds(400, 130, 250, 45);//x,y,tamaño
        _campoPassword.setBackground(new Color(237, 143, 196));
        //_campoPassword.setRequestFocusEnabled(false);
        add(_campoPassword);
        _campoPassword.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent de) {
                char [] password;
            
                password= _campoPassword.getPassword();

                if(password.length< 8 || password.length>12)
                {
                    _campoPassword.setBackground(Color.RED);
                }
                else
                {
                    _campoPassword.setBackground(Color.WHITE);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                
            }
        });
        
        JButton boton_salir= new JButton(new ImageIcon("SalirBtn.png"));
        boton_salir.setBorder(null);
        boton_salir.setBorderPainted(false);
        boton_salir.setContentAreaFilled(false);
        boton_salir.setFocusPainted(false);
        boton_salir.setToolTipText("Abandonar partida");
        boton_salir.setActionCommand("Abandonar_partida");
        boton_salir.setBounds(60, 520, 250, 100);//x,y,tamaño
        
        boton_salir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int respuesta;
                
                haceSonido(sonidoMiau);
                respuesta = JOptionPane.showConfirmDialog(null, "Desea salir?");
                if (respuesta == 0) {
                    setVisible(false);    
                }
            }
        });
   
        add(boton_salir);

        JButton Aceptar= new JButton(new ImageIcon("IngresarBtn.png"));
        Aceptar.setBorder(null);
        Aceptar.setBorderPainted(false);
        Aceptar.setContentAreaFilled(false);
        Aceptar.setFocusPainted(false);
        Aceptar.setToolTipText("Aceptar");
        Aceptar.setActionCommand("Aceptar");
        Aceptar.setBounds(880, 470, 250, 100);//x,y,tamaño
        
        Aceptar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });

        add(Aceptar);
    }
   
    public void haceSonido(String sonido) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.out.println("No se encontró sonido");
        }
    }

}
