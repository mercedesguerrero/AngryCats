/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.BorderPane;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

/**
 *
 * @author Mechu
 */
public class Frame1 extends javax.swing.JFrame {

    
    public Frame1() 
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
        
        Layer1 miLayer= new Layer1();
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
    
    public JFrame getFrame()
    {
        return this;
    }
    
    private void addElementos()
    {
        //JLabel texto1= new JLabel("Angry Cats");
        //texto1.setFont(new Font("Aharoni", 1, 32));
        //texto1.setForeground(new java.awt.Color(255, 255, 255));
        
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
    @SuppressWarnings("unchecked")
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
