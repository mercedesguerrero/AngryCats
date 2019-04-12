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
    private LogicJuego _miPartidaJuego;
    JTextArea miArea;
    private int respuesta;
    private int cuentaErrores; //cantidad de errores que el usuario cometio hasta el momento
    private final JLabel _lblCaracterIngresado = new JLabel("Ingrese las letras para adivinar la palabra");
    private final JLabel _lblMensajeIncorrecto = new JLabel("Letras incorrectas: ");
    private JLabel _lblMensaje; 
    private JLabel lblLetraIncorrecta;//letra que no se adivinó correctamente
    private JLabel lblPalabraAAdivinar;
    private JLabel lblPalabraSinCompletar;
    private String palabraCorrecta;
    
    private final String sonidoGano = "gano.wav";
    private final String sonidoPerdio = "perdio.wav";
    private final String sonidoTeclaCorrecta = "tecla_correcta.wav";
    private final String sonidoTeclaIncorrecta = "tecla_incorrecta.wav";
    
    public Layer2()
    {
        cuentaErrores= 0;
        _miPartidaJuego= new LogicJuego();
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
        }
        catch(IOException e)
        {
            System.out.println("No se encontró la imagen");
            e.printStackTrace();
        }
        
        if (cuentaErrores> 0) 
        {
            seEnojaElGatito(g);
        }
        
        setLayout(null);
        
        g.drawImage(_fondo, 0, 0, null);
        
        _miPartidaJuego.Jugar();
        palabraCorrecta= _miPartidaJuego.getPalabraRandom();

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
  
                    String cadena= String.valueOf(validar).toUpperCase();
                    miArea.setText(cadena);
                    
                    _miPartidaJuego.llenarAdivinanza(palabraCorrecta, validar);
                }
                else
                {
                    getToolkit().beep();
                    ke.consume();
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
        
        lblPalabraAAdivinar= new JLabel(_miPartidaJuego.letrasCorrectasToString());
        lblPalabraAAdivinar.setBounds(100, 100, 400, 250);
        lblPalabraAAdivinar.setFont(new Font("Aharoni", Font.BOLD, 86));
        lblPalabraAAdivinar.setForeground(Color.WHITE);
        
        add(lblPalabraAAdivinar);
        
        lblPalabraSinCompletar= new JLabel(_miPartidaJuego.letrasCorrectasToString());
        lblPalabraSinCompletar.setBounds(120, 130, 400, 250);
        lblPalabraSinCompletar.setFont(new Font("Aharoni", Font.BOLD, 86));
        lblPalabraSinCompletar.setForeground(Color.WHITE);
        
        add(lblPalabraAAdivinar);
                
        
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

    //comprobar la validez y notificar al usuario
    public boolean darAdivinanza(char adivina) {
        
        boolean _retorno= false;
        
        if (!_miPartidaJuego.noQuedanIntentos() && !_miPartidaJuego.palabraAdivinada()) 
        {
            _retorno= _miPartidaJuego.llenarAdivinanza(palabraCorrecta, adivina);
           
            if (_retorno) 
            {
                tieneLetraCorrecta();
                imprimeLetrasCorrectas(_miPartidaJuego.letrasCorrectasToString());
            }
                    else {
                        tieneLetraIncorrecta();
                        imprimeLetrasIncorrectas(_miPartidaJuego.letrasIncorrectasToString());
                    }
                }
            

            boolean gana = _miPartidaJuego.palabraAdivinada();

            if (gana) {
                //gana ABRIR JFRAME GANASTE!!!
                System.out.println("GANSTE!!!");
            }
            else if (_miPartidaJuego.noQuedanIntentos()) {
                System.out.println("PERDISTE!!!");
            }
            
        return _retorno;
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
        this.lblLetraIncorrecta.setText(letrasIncorrectas);
    }
    
    public void imprimeLetrasCorrectas(String letrasCorrectas) 
    {
        //letrasCorrectas= 
        //lblPalabraAAdivinar.setText(letrasCorrectas);
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
