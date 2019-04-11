/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AngryCats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Mechu
 */
public class ClickListener implements ActionListener{
    
    private Frame2 frameJuego;
    private int respuesta;

    public ClickListener()
    {
        
    }

    public Frame2 getFrameJuego() {
        return frameJuego;
    }

    public void setFrameJuego(Frame2 frameJuego) {
        this.frameJuego = frameJuego;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String clickeo = e.getActionCommand();
        
        if (clickeo.equals("Jugar")) {
            
            frameJuego= new Frame2();
            
            frameJuego.setVisible(true);

            //char adivina = miVista.getSiguienteAdivinanza();
            //miVista.borraAdivina(String.valueOf(adivina));

            //if (adivina != ' ') {
                //miControlador.darAdivinanza(adivina);
            //}

        } else if (clickeo.equals("Salir")) {
            
            respuesta = JOptionPane.showConfirmDialog(null, "Desea salir de Angry Cats?");
            if (respuesta == 0) {
                System.exit(0);      
            } else;
            
        } else if (clickeo.equals("Abandonar_partida")) {

                respuesta = JOptionPane.showConfirmDialog(null, "Desea abandonar partida?");
                if (respuesta == 0) {

                    //frameJuego.setVisible(false);
                    frameJuego.dispose();
                } else; 
            }
    }
    
}
