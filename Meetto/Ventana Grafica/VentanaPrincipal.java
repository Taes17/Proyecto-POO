package ventana_grafica;

import usuarios.*;
import ventana_grafica.PanelPrincipal;

import java.awt.Color;

import javax.swing.JFrame;
import java.awt.LayoutManager;
import java.awt.CardLayout;

public class VentanaPrincipal extends JFrame {
    
    PanelPrincipal panelP;
    PanelRegistro panelR;

    VentanaPrincipal() {

        this.setTitle("Meetto"); //Establecemos el titulo de la ventana 
        this.setSize( 800, 800 ); //Establecemos tamano de la ventana 
        this.setLocationRelativeTo( null ); //Establecemos la ventana en el centro de cualquier pantalla
        this.setDefaultCloseOperation( EXIT_ON_CLOSE ); //Se termina la ejecuacion del programa al presionar al tache
        
        this.setLayout( new CardLayout() );

        this.panelR = new PanelRegistro();
        this.panelP = new PanelPrincipal( this.panelR );

        this.add( panelP );
        this.add( panelR );
    }
}


class Control {

    public static void main(String[] args) {
        
        VentanaPrincipal v = new VentanaPrincipal();

        v.setVisible( true );
    }
}