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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private JTextArea _areaParaIngresarLetra;
    private char letra_ingresada;
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
    private JButton boton_salir;
    
    public VistaJugar(LogicJuego logicJuego)
    {
        super();
        this._miPartidaJuego = logicJuego;
    }
    
    
    public void iniciarJuego()
    {
        
        try{
            _miPartidaJuego.iniciarJuego();
            
        }catch(JuegoException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error Diccionario- no se puede iniciar juego ");
            
            System.exit(1);
        }   
        
        agregarAreaParaIngresarLetra();
        agregarBotonSalir();
        setVistaNuevaRonda();
        
    }
    
    private void agregarBotonSalir()
    {
        boton_salir= new JButton(new ImageIcon("SalirBtn.png"));
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
                    resetearErrores();
                    setVisible(false);    
                }
            }
        });
        
        add(boton_salir);
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
    
    private void setVistaNuevaRonda()
    {
        try{
        _fondo= ImageIO.read(new File("space2.png"));
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
        
        try{
            seEnojaElGatito();
        } catch (IOException ex) {
            System.out.println("No se pudo enojar el gatito");
        }
    }
    
    private void agregarAreaParaIngresarLetra()
    {
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
                            
                            
                            if(_miPartidaJuego.AdivinoLaPalabra())
                            {
                                haceSonido(sonidoGano);
                                JOptionPane.showMessageDialog(null, "", "Adivinaste!!! Tenés " + _miPartidaJuego.getPuntajeAcumulado() + " puntos acumulados", JOptionPane.INFORMATION_MESSAGE, _happyCatDance);
                                resetearErrores();
                                 //setVisible(false);
                                
                                try{
                                    _miPartidaJuego.iniciarRonda();
            
                                }catch(JuegoException e){
                                    
                                    System.out.println("Error Diccionario- no hay palabras para adivinar");

                                    System.exit(1);
                                }    
                                
                                try {
                                    seEnojaElGatito();
                                } catch (IOException ex) {
                                    System.out.println("No se pudo enojar el gatito");
                                }
                                
                                //repaint();//llama a paint hace update()
                            }
                        }
                        else
                        {
                            //frame1= new FrameGif("catNo.gif", "Letra incorrecta!!!", 230, 230);
                            haceSonido(sonidoCatSuperAngry);
                            JOptionPane.showMessageDialog(null, "", "Letra incorrecta!!!", JOptionPane.INFORMATION_MESSAGE, _catNoNo);
                            
                            if(_miPartidaJuego.QuedanIntentos())
                            {
                                try {
                                    seEnojaElGatito();
                                } catch (IOException ex) {
                                    System.out.println("No se pudo enojar el gatito");
                                }

                                System.out.println("Cantidad de errores: " + _miPartidaJuego.getCuentaErrores());
                                _areaParaIngresarLetra.setText("");

                                //repaint();
                            }
                            else
                            {
                                System.out.println("No te quedan mas intentos!!!");
                                haceSonido(sonidoPerdio);
                                _miPartidaJuego.ChequeaPuntaje();
                                JOptionPane.showMessageDialog(null, "", "No te quedan mas intentos!!! Sumaste " + _miPartidaJuego.getPuntajeAcumulado() + " puntos", JOptionPane.INFORMATION_MESSAGE, _mCat);
                                _areaParaIngresarLetra.setText("");
                                _miPartidaJuego.NoQuedanIntentos();
                                resetearErrores();
                                //setVisible(false);   
                                try{
                                    _miPartidaJuego.iniciarRonda();

                                }catch(JuegoException e){

                                    System.out.println("Error Diccionario- no hay palabras para adivinar");

                                    System.exit(1);
                                }    

                                try {
                                    seEnojaElGatito();
                                } catch (IOException ex) {
                                    System.out.println("No se pudo enojar el gatito");
                                }
                                //repaint();//llama a paint hace update()

                            }
                        }
                    }
                    repaint();//llama a paint hace update()
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
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
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
        
    }
    
    public void borraLetraIngresada() 
    {
        this._areaParaIngresarLetra.setText("");
    }

    private void seEnojaElGatito() throws IOException 
    {
        switch(_miPartidaJuego.getCuentaErrores()){
            case 0:
                setGatitoEnojado("gatitoEnojado0.png");
                break;
            case 1:
                setGatitoEnojado("gatitoEnojado1.png");
                break;
            case 2:
                setGatitoEnojado("gatitoEnojado2.png");
                break;
            case 3:
                setGatitoEnojado("gatitoEnojado3.png");
                break;
            case 4:
                setGatitoEnojado("gatitoEnojado4.png");
                break;
            case 5:
                setGatitoEnojado("gatitoEnojado5.png");
                break;
            case 6:
                setGatitoEnojado("gatitoEnojado6.png");
                break;
        }
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

    public void resetearErrores() 
    {
        _miPartidaJuego.setCuentaErrores(0); 
    }

}
