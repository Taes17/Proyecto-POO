package ventana_grafica;

import javax.swing.JPanel;
import javax.swing.JButton;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

import ventana_grafica.PanelRegistro;

public class PanelPrincipal extends JPanel implements ActionListener {
    
    PanelRegistro panelRegistro;
    //PanelIngreso panelIngreso;
    
    JButton BotonRegistro;
    JButton BotonIngreso;

    PanelPrincipal( PanelRegistro registro/*, PanelIngreso ingreso */ ) {
        
        this.panelRegistro = registro;
        //this.panelIngreso = ingreso;
        

        this.setBackground( Color.WHITE ); //Establecemos el color del panel

        Botones();
    }

    private void Botones() {

        BotonRegistro = new JButton("Registrarse");
        this.add( BotonRegistro );

        BotonIngreso = new JButton("Ingresar");
        this.add( BotonIngreso );

        BotonRegistro.addActionListener( this );
        BotonIngreso.addActionListener( this );
    }

    
    @Override
    public void actionPerformed( ActionEvent ae ) {
        
        if( ae.getSource() == BotonRegistro ) {
            
            this.setVisible( false );
            panelRegistro.setVisible( true );
            
        } /*else if( ae.getSource() == BotonIngreso ) {

            this.setVisible( false );
            panelIngreso.setVisible( true );
        }*/
    }
}
