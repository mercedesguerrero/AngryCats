/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mechu
 */
public class Layer1 extends JPanel{
    
    public Layer1()
    {
        setLayout(new BorderLayout());
        JPanel miLayer2= new JPanel();
        JPanel miLayer3= new JPanel();
        JPanel miLayer4= new JPanel();
        //miLayer2.setLayout(new FlowLayout());
        miLayer2.setLayout(new GridLayout(1, 1));//NORTE
        miLayer3.setLayout(new GridLayout(1, 1));//CENTRO
        miLayer4.setLayout(new GridLayout(1, 2));//SOUTH
        
              
        miLayer2.setBackground(Color.pink);
        
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
        
        add(miLayer2, BorderLayout.NORTH);
        add(miLayer3, BorderLayout.CENTER);
        add(miLayer4, BorderLayout.SOUTH);
    }    
    
}
