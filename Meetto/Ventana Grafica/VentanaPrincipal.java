package meetto.ventana_grafica;

import meetto.ventana_grafica.registro_ingreso.*;

import java.awt.Color;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.text.ComponentView;
import javax.swing.text.AttributeSet.ColorAttribute;

public class VentanaPrincipal extends JFrame {
    
    PanelPrincipal panelP;
    PanelRegistro panelR;
    PanelIngreso panelI;

    JScrollPane contenedor;

    VentanaPrincipal() {

        this.setTitle("Meetto"); //Establecemos el titulo de la ventana 
        this.setSize( 900, 900 ); //Establecemos tamano de la ventana 
        this.setResizable( false );
        this.setLocationRelativeTo( null ); //Establecemos la ventana en el centro de cualquier pantalla
        this.setDefaultCloseOperation( EXIT_ON_CLOSE ); //Se termina la ejecuacion del programa al presionar al tache
    
        this.panelP = new PanelPrincipal();

        this.add( panelP );
    }
}


class Control {

    public static void main(String[] args) {
        
        VentanaPrincipal v = new VentanaPrincipal();

        v.setVisible( true );
    }
}