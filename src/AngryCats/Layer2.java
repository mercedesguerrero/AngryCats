/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Mechu
 */
public class Layer2 extends JPanel {
    
    private Image _fondo;
    private Image _gatitoEnojado1;
    private Image _globoComic;
    private LogicJuego _miPartidaJuego;
    private char _letra;
    JTextArea miArea;
    private int respuesta;
    private int acerto;
    private int cuentaErrores; //cantidad de errores que el usuario cometio hasta el momento
    private JLabel _lblCaracterIngresado = new JLabel("Ingrese las letras para adivinar la palabra");
    private JLabel _lblMensajeIncorrecto = new JLabel("Letras incorrectas: ");
    private JLabel _lblMensaje; 
    private JLabel lblLetrasIncorrectas;//letra que no se adivinó correctamente
    //private JLabel lblPalabraAAdivinar;
    private JLabel lblPalabraSinCompletar;// pone algunas letras de la palabra todavia incompleta
    private String palabraCorrecta;//palabra random original
    private String letrasIncorrectas;
    
    //private final String sonidoGano = "gano.wav";
    //private final String sonidoPerdio = "perdio.wav";
    //private final String sonidoTeclaIncorrecta = "tecla_incorrecta.wav";
    
    public Layer2()
    {
        cuentaErrores= 0;
        
        try
        {
            iniciarJuego();
        }
        catch (DiccionarioException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void iniciarJuego() throws DiccionarioException
    {
        this._miPartidaJuego= new LogicJuego();
        lblPalabraSinCompletar.setVisible(true);
        
        palabraCorrecta= _miPartidaJuego.getPalabra_a_buscar();
        _miPartidaJuego.setPalabra_a_buscar(palabraCorrecta);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        //g.drawRect(50, 50, 200, 200);
        //g.drawLine(100, 100, 300, 200);
        
        try{
        _fondo= ImageIO.read(new File("space.jpg"));
        _gatitoEnojado1= ImageIO.read(new File("gatitoEnojado1.png"));
        _globoComic= ImageIO.read(new File("globo_comic.png"));
        }
        catch(IOException e)
        {
            System.out.println("No se encontró la imagen");
            e.printStackTrace();
        }
        
        setLayout(null);
        
        g.drawImage(_fondo, 0, 0, null);
        //g.drawImage(_fondo, 100, 350, null);
        
        lblPalabraSinCompletar= new JLabel(_miPartidaJuego.getPalabra_del_usuario());
        lblPalabraSinCompletar.setBounds(120, 130, 400, 250);
        lblPalabraSinCompletar.setFont(new Font("Aharoni", Font.BOLD, 86));
        lblPalabraSinCompletar.setForeground(Color.WHITE);
        
        add(lblPalabraSinCompletar);
        
        lblLetrasIncorrectas= new JLabel(_miPartidaJuego.getPalabra_del_usuario());
        lblLetrasIncorrectas.setBounds(50, 330, 400, 250);
        lblLetrasIncorrectas.setFont(new Font("Aharoni", Font.BOLD, 86));
        lblLetrasIncorrectas.setForeground(Color.WHITE);
        
        add(lblLetrasIncorrectas);
       

        miArea= new JTextArea(8, 20);
        miArea.setLineWrap(true);//No tiene saltos de linea
        miArea.setFont(new Font("Aharoni", Font.BOLD, 86));
        miArea.setForeground(new Color(38, 74, 90));
        miArea.setTabSize(1);
        miArea.setToolTipText("Tipear letra");
        miArea.setBounds(950, 340, 95, 95);
        miArea.setBackground(new Color(237, 143, 196));
        //miArea.setPreferredSize(new Dimension (150,160));
        miArea.setRequestFocusEnabled(true);

        //miArea.setEditable(false);//no te deja escribir
        miArea.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
                char validar= ke.getKeyChar();
                
                if(Character.isLetter(validar))
                {
                    System.out.println("Letra ingresada: " + validar);
                    ke.consume();
                    
                    acerto= _miPartidaJuego.BuscaLetraEnPalabra(validar);
  
                    String cadena= String.valueOf(validar).toUpperCase();
                    miArea.setText(cadena);
                    
                    if(acerto== 0)
                    {
                        _miPartidaJuego.setPalabra_del_usuario(cadena);
                        lblPalabraSinCompletar= new JLabel(_miPartidaJuego.getPalabra_del_usuario());
                        lblPalabraSinCompletar.setVisible(true);
                    }
                    else
                    {
                        cuentaErrores ++;
                        
                        getToolkit().beep();
                        ke.consume();
                        
                        if (cuentaErrores> 0) 
                        {
                            seEnojaElGatito(g);
                            lblLetrasIncorrectas.setVisible(true);
                            letrasIncorrectas= cadena;
                            imprimeLetrasIncorrectas(palabraCorrecta);
                        }
                    }
                    System.out.println(miArea.getText());
                }
            }
            @Override
            public void keyPressed(KeyEvent ke) {
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               
            }
            
        });
   
        add(miArea);
        
        //lblPalabraAAdivinar= new JLabel(_miPartidaJuego.letrasCorrectasToString());
        //lblPalabraAAdivinar.setBounds(100, 100, 400, 250);
        //lblPalabraAAdivinar.setFont(new Font("Aharoni", Font.BOLD, 86));
        //lblPalabraAAdivinar.setForeground(Color.WHITE);
        
        //add(lblPalabraAAdivinar);
                
        
        JButton boton_salir= new JButton(new ImageIcon("SalirBtn.png"));
        boton_salir.setBorder(null);
        boton_salir.setBorderPainted(false);
        boton_salir.setContentAreaFilled(false);
        boton_salir.setFocusPainted(false);
        boton_salir.setToolTipText("Abandonar partida");
        boton_salir.setActionCommand("Abandonar_partida");
        boton_salir.setBounds(80, 470, 250, 100);//x,y,tamaño
        
        boton_salir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                respuesta = JOptionPane.showConfirmDialog(null, "Desea abandonar partida?");
                if (respuesta == 0) {
                    resetear();
                    setVisible(false);    
                }
            }
        });
   
        add(boton_salir);
        
        
        JButton ingresarLetra= new JButton(new ImageIcon("IngresarBtn.png"));
        ingresarLetra.setBorder(null);
        ingresarLetra.setBorderPainted(false);
        ingresarLetra.setContentAreaFilled(false);
        ingresarLetra.setFocusPainted(false);
        ingresarLetra.setToolTipText("Ingresar letra");
        ingresarLetra.setActionCommand("Ingresar_letra");
        ingresarLetra.setBounds(880, 470, 250, 100);//x,y,tamaño
        
        ingresarLetra.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                

            }
        });
        
        add(ingresarLetra);

    }

    public char getLetra()
    {
        return this._letra;
    }
    
    public void borraLetraIngresada(String borra) 
    {
        miArea.setText("");
    }

    public int getJuegosGanados() 
    {
        return _miPartidaJuego.getJuegosGanados();
    }

        public int getJuegosJugados() {
            return _miPartidaJuego.getJuegosJugados();
        }

    private void seEnojaElGatito(Graphics g) 
    {
        g.drawImage(_gatitoEnojado1, 300, 400, null);
        
        if (cuentaErrores > 1) 
        {
            g.drawImage(_gatitoEnojado1, 310, 410, null);
            if (cuentaErrores > 2) 
            {
                g.drawImage(_gatitoEnojado1, 320, 420, null);
                if (cuentaErrores > 3) 
                {
                    g.drawImage(_gatitoEnojado1, 350, 450, null);
                    if (cuentaErrores > 4) 
                    {
                        g.drawImage(_gatitoEnojado1, 360, 460, null);
                        if (cuentaErrores > 5) 
                        {
                            g.drawImage(_gatitoEnojado1, 370, 470, null);
                        }
                    }
                }
            }
        }
    }

    public void RespuestaIncorrecta() 
    {
        cuentaErrores++;
    }

    public void tieneLetraCorrecta() 
    {
        _lblMensaje.setText("Correcta!!");
        System.out.println("Correcta!!");
        //haceSonido(sonidoTeclaCorrecta);
    }
    
    public void tieneLetraIncorrecta() 
    {
        _lblMensaje.setText("Incorrecta!!");
        RespuestaIncorrecta();
        System.out.println("Incorrecta!!");
        //haceSonido(sonidoTeclaIncorrecta);
    }

    public void haceSonido(String sonido) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
        }
    }
 
    public void imprimeLetrasIncorrectas(String letrasIncorrectas) 
    {
        this.lblLetrasIncorrectas.setText(letrasIncorrectas);
    }
    
    public void adivinanzaRepetida() 
    {
        _lblMensaje.setText("Ya ingresaste esta letra!");
    }

    public void resetear() 
    {
        cuentaErrores = 0;
     
    }

}
