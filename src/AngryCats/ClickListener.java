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
    
    private FrameJuego nuevaPartidaJuego;
    private int respuesta;

    public ClickListener()
    {
        
    }

    public FrameJuego getNuevaPartidaJuego() {
        return nuevaPartidaJuego;
    }

    public void setNuevaPartidaJuego(FrameJuego nuevaPartidaJuego) {
        this.nuevaPartidaJuego = nuevaPartidaJuego;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String clickeo = e.getActionCommand();
        nuevaPartidaJuego= new FrameJuego();
        
        if (clickeo.equals("Jugar")) {
            
            nuevaPartidaJuego.setVisible(true);

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

                    nuevaPartidaJuego.setVisible(false);
                    nuevaPartidaJuego.dispose();
                } else; 
            }
    }
    
}
