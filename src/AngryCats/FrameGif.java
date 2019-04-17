/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Mechu
 */
public class FrameGif extends JFrame{
    
    private String _path;
    private String _titulo;
    private int _sizeX;
    private int _sizeY;
    
    public FrameGif(String path, String titulo, int sizeX, int sizeY)
    {
        this._path= path;
        this._titulo= titulo;
        this._sizeX= sizeX;
        this._sizeY= sizeY;
        Iniciar();
    }
    
    public void Iniciar()
    {
        
        setVisible(true);
        setTitle(this._titulo);
        setContentPane(new JLabel(new ImageIcon(this._path)));
        setSize(this._sizeX, this._sizeY);
        //setBounds(100, 100, 600, 350);
        setResizable(false);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
    }   
    
}
