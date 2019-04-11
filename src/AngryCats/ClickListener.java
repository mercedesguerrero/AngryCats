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
    

    public ClickListener()
    {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String clickeo = e.getActionCommand();
        
        if (clickeo.equals("Jugar")) {
            
            Frame2 frameJuego= new Frame2();
            
            frameJuego.setVisible(true);

            //char adivina = miVista.getSiguienteAdivinanza();
            //miVista.borraAdivina(String.valueOf(adivina));

            //if (adivina != ' ') {
                //miControlador.darAdivinanza(adivina);
            //}

        } else if (clickeo.equals("Salir")) {
            int respuesta;
            respuesta = JOptionPane.showConfirmDialog(null, "Desea salir de Angry Cats?");
            if (respuesta == 0) {
                System.exit(0);      
            } else;
        }
    }
    
}
