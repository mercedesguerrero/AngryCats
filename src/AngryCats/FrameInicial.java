/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;


/**
 *
 * @author Mechu
 */
public class FrameInicial extends javax.swing.JFrame {

    
    public FrameInicial() 
    {
        /**
        Toolkit miMonitor= Toolkit.getDefaultToolkit();
        
        Dimension tamanioMonitor= miMonitor.getScreenSize();
        
        int alturaMonitor= tamanioMonitor.height;
        int anchoMonitor= tamanioMonitor.width;
        
        //setSize(anchoMonitor-100, alturaMonitor-100);
        //setLocation(anchoMonitor-1550, alturaMonitor-850);
        
        //setSize(1200, 850);*/
        setSize(1200, 700);
        setResizable(false);
        setLocationRelativeTo(null); 
        setTitle("AngryCats");
        
        IniciaJuego miLayer= new IniciaJuego();
        //setContentPane(new JLabel(new ImageIcon("space.jpg")));
        //add(new JLabel(new ImageIcon("space.jpg")));
        
        
        add(miLayer);
        //addElementos();
        //miLayer.setBackground(new JLabel(new ImageIcon("space.jpg"));    
        //setContentPane(new JLabel(new ImageIcon("space.jpg")));
        //setVisible(true);
        
        //miCapa.setBackground(Color.CYAN);
        //miFrameImagen.setBackground(Color.GRAY.brighter().brighter());
        
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
    
    
    /**
     *  JLabel rotulo1= new JLabel("Angry Cats");
        
        Box cajaH1= Box.createHorizontalBox();
        
        cajaH1.add(rotulo1);
        
        
        
        Box cajaH2= Box.createHorizontalBox();
        
        cajaH2.add(miLayer);
        
        JButton boton_cerrar= new JButton("Cerrar");
        boton_cerrar.setFont(new Font("Aharoni", 1, 32));
        
        JButton BotonJugar= new JButton("JUGAR");
        BotonJugar.setFont(new Font("Aharoni", 1, 32));
        
        Box cajaH3= Box.createHorizontalBox();
        cajaH3.add(boton_cerrar);
        cajaH3.add(Box.createHorizontalBox());
        cajaH3.add(BotonJugar);
        
        Box cajaVertical= Box.createVerticalBox();
        
        cajaVertical.add(cajaH1);
        cajaVertical.add(cajaH2);
        cajaVertical.add(cajaH3);
        
        add(cajaVertical, BorderLayout.CENTER);
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
