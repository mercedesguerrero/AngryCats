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
import javax.swing.JTextArea;

/**
 *
 * @author Mechu
 */
public class VistaJugar extends JPanel {
    
    private LogicJuego _miPartidaJuego;
    private Image _fondo;
    private Image _gatitoEnojado;
    private Image _globoComic;
    JTextArea _areaParaIngresarLetra;
    private char letra_ingresada;
    private String letrasIngresadas;
    private ImageIcon _nyanCat;
    private ImageIcon _happyCatDance;
    private ImageIcon _catNoNo;
    private ImageIcon _mCat;
    private ImageIcon _isNotAGameCat;
    private ImageIcon _catTyping;
    private ImageIcon _catComputer;
    private final String sonidoCatSuperAngry= "superAngry.wav";
    private final String sonidoGano = "Piipiripipipiiii.wav";
    private final String sonidoPerdio = "angryCatSonido.wav";
    private final String sonidoMiau = "miau.wav";
    
    
    public void iniciarJuego()
    {
        _miPartidaJuego= new LogicJuego();
        
        try{
            _miPartidaJuego.iniciarJuego();
            
        }catch(JuegoException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error Diccionario- no se puede iniciar juego ");
            
            System.exit(1);
        }   
    }

    public Image getGatitoEnojado() {
        return _gatitoEnojado;
    }

    public void setGatitoEnojado(String _gatitoEnojado) throws IOException {
        this._gatitoEnojado = ImageIO.read(new File(_gatitoEnojado));
    }

    public JTextArea getAreaParaIngresarLetra() {
        return _areaParaIngresarLetra;
    }

    public void setAreaParaIngresarLetra(JTextArea _areaParaIngresarLetra) {
        this._areaParaIngresarLetra = _areaParaIngresarLetra;
    }

    public char getLetra_ingresada() {
        return letra_ingresada;
    }

    public void setLetra_ingresada(char letra_ingresada) {
        this.letra_ingresada = letra_ingresada;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        try{
        _fondo= ImageIO.read(new File("space2.jpg"));
        _globoComic= ImageIO.read(new File("globo_comic.png"));
        _nyanCat= new ImageIcon("nyanKitten.gif");
        _happyCatDance= new ImageIcon("catWinner.gif");
        _catNoNo= new ImageIcon("catNo.gif");
        _mCat= new ImageIcon("Macri.gif");
        _catComputer= new ImageIcon("catComputer.gif");
        _catTyping= new ImageIcon("catTyping.gif");
        _isNotAGameCat= new ImageIcon("catAngry.gif");
        }
        catch(IOException e)
        {
            System.out.println("No se encontró la imagen");
        }
        
        setLayout(null);
        
        g.drawImage(_fondo, 0, 0, null);
        g.drawImage(getGatitoEnojado(), 280, 190, null);
        
        Graphics2D palabra= (Graphics2D) g;
        palabra.setFont(new Font("Calibri", Font.BOLD, 112));
        palabra.setColor(new Color(65, 228, 195));
        palabra.drawString(_miPartidaJuego.getPalabra_del_usuario(), 150, 150);
        
        Graphics2D letras= (Graphics2D) g;
        letras.setFont(new Font("Calibri", Font.BOLD, 20));
        letras.setColor(new Color(65, 228, 195));
        letras.drawString("Letras ingresadas: ", 60, 370);
        letras.drawString(_miPartidaJuego.getLetrasIngresadasList().toString(), 60, 400);
        
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
                respuesta = JOptionPane.showConfirmDialog(null, "Desea abandonar la partida?");
                if (respuesta == 0) {
                    resetear();
                    setVisible(false);    
                }
            }
        });
   
        add(boton_salir);

        _areaParaIngresarLetra= new JTextArea(8, 20);
        _areaParaIngresarLetra.setLineWrap(true);//No tiene saltos de linea
        _areaParaIngresarLetra.setFont(new Font("Aharoni", Font.BOLD, 96));
        _areaParaIngresarLetra.setForeground(new Color(38, 74, 90));
        _areaParaIngresarLetra.setTabSize(1);
        _areaParaIngresarLetra.setToolTipText("Tipear letra");
        _areaParaIngresarLetra.setBounds(800, 70, 95, 95);
        _areaParaIngresarLetra.setBackground(new Color(237, 143, 196));
        _areaParaIngresarLetra.setRequestFocusEnabled(true);
        add(_areaParaIngresarLetra);
        //miArea.setEditable(false);//no te deja escribir
        
        if(_miPartidaJuego.QuedanIntentos())
        {
            _areaParaIngresarLetra.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
                setLetra_ingresada(ke.getKeyChar());
                
                if(_miPartidaJuego.esLetra(letra_ingresada))
                {
                    ke.consume();
                    
                    letra_ingresada= _miPartidaJuego.Caracter_a_Mayuscula(letra_ingresada);
                    
                    if (_miPartidaJuego.LetraEstaEnLaLista(letra_ingresada)) 
                    {
                        JOptionPane.showMessageDialog(null, "Ya ingresaste la letra " + letra_ingresada, "Letra repetida", JOptionPane.INFORMATION_MESSAGE, _catComputer);
                        haceSonido(sonidoMiau);
                    }
                    else
                    {
                        _areaParaIngresarLetra.setText(String.valueOf(letra_ingresada));
                
                        if(_miPartidaJuego.BuscaLetraEnPalabra(letra_ingresada))
                        {
                            haceSonido(sonidoMiau);
                            JOptionPane.showMessageDialog(null, "", "Letra correcta!!!", JOptionPane.INFORMATION_MESSAGE, _nyanCat);
                            _areaParaIngresarLetra.setText("");
                            repaint();//llama a paint hace update()
                            
                            if(_miPartidaJuego.AdivinoLaPalabra())
                            {
                                System.out.println("Ganaste!!!");
                                haceSonido(sonidoGano);
                                JOptionPane.showMessageDialog(null, "", "Ganaste!!!", JOptionPane.INFORMATION_MESSAGE, _happyCatDance);
                                resetear();
                                setVisible(false);  
                            }
                        }
                        else
                        {
                            //frame1= new FrameGif("catNo.gif", "Letra incorrecta!!!", 230, 230);
                            haceSonido(sonidoCatSuperAngry);
                            JOptionPane.showMessageDialog(null, "", "Letra incorrecta!!!", JOptionPane.INFORMATION_MESSAGE, _catNoNo);
                            _miPartidaJuego.setCuentaErrores(1);
                            try {
                                seEnojaElGatito();
                            } catch (IOException ex) {
                                System.out.println("No se pudo enojar el gatito");
                            }
                            //g.drawImage(getGatitoEnojado(), 200, 300, null);
                            
                            System.out.println("Cantidad de errores: " + _miPartidaJuego.getCuentaErrores());
                            _areaParaIngresarLetra.setText("");
                            
                            repaint();
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Solo pueden ingresar letras");
                    haceSonido(sonidoMiau);
                    ke.consume();
                    _areaParaIngresarLetra.setText("");   
                }
            }
            @Override
            public void keyPressed(KeyEvent ke) {
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               
            }
            
        });
         
        }
        else
        {
            System.out.println("Perdiste!!!");
            //JOptionPane.showMessageDialog(null, "", "Perdiste!!!", JOptionPane.INFORMATION_MESSAGE, _mCat);
            haceSonido(sonidoPerdio);
            JOptionPane.showMessageDialog(null, "", "Perdiste!!!", JOptionPane.INFORMATION_MESSAGE, _mCat);
            //frame1= new FrameGif("Macri.gif", "Perdiste!!!", 400, 250);
            resetear();
            setVisible(false);   
            
        }
        
        
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
        
        //add(ingresarLetra);

    }
    
    public void borraLetraIngresada() 
    {
        this._areaParaIngresarLetra.setText("");
    }

    public int getJuegosGanados() 
    {
        return _miPartidaJuego.getJuegosGanados();
    }

    public int getJuegosJugados() {
        return _miPartidaJuego.getJuegosJugados();
    }

    private void seEnojaElGatito() throws IOException 
    {
        setGatitoEnojado("gatitoEnojado1.png");
        
        //g.drawImage(_gatitoEnojado1, 300, 400, null);
        
        if (_miPartidaJuego.getCuentaErrores() > 1) 
        {
            setGatitoEnojado("gatitoEnojado2.png");
            if (_miPartidaJuego.getCuentaErrores() > 2) 
            {
                setGatitoEnojado("gatitoEnojado3.png");
                if (_miPartidaJuego.getCuentaErrores() > 3) 
                {
                    setGatitoEnojado("gatitoEnojado4.png");
                    if (_miPartidaJuego.getCuentaErrores() > 4) 
                    {
                        setGatitoEnojado("gatitoEnojado5.png");
                        if (_miPartidaJuego.getCuentaErrores() > 5) 
                        {
                            setGatitoEnojado("gatitoEnojado6.png");
                        }
                    }
                }
            }
        }
    }

    public void tieneLetraCorrecta() 
    {
        System.out.println("Correcta!!");
        //haceSonido(sonidoTeclaCorrecta);
    }
    
    public void tieneLetraIncorrecta() 
    {
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
            System.out.println("No se encontró sonido");
        }
    }
 
    public void imprimeLetrasIncorrectas(String letrasIncorrectas) 
    {
      
    }
    
    public void adivinanzaRepetida() 
    {
        //_lblMensaje.setText("Ya ingresaste esta letra!");
    }

    public void resetear() 
    {
        _miPartidaJuego.setCuentaErrores(0); 
    }

}
