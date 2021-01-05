package meetto.ventana_grafica.registro_ingreso;

import meetto.usuarios.*;
import meetto.ventana_grafica.registro_ingreso.PanelIngreso;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import java.awt.FlowLayout;

import  java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;

public class PanelPrincipal extends JPanel implements ActionListener {
    
    PanelRegistro panelRegistro;
    PanelIngreso panelIngreso;
    
    JButton BotonRegistro;
    JButton BotonIngreso;

    JScrollPane contenedorCentral;
    
    Sistema s = new Sistema();

    public PanelPrincipal() {
        
        this.setBackground( Color.WHITE ); //Establecemos el color del panel
        this.setLayout( new BorderLayout( 10, 10 ) );
    
        this.contenedorCentral = new JScrollPane();

        this.panelRegistro = new PanelRegistro( s );
        this.panelIngreso = new PanelIngreso( s );

        BotonesSup();
        PanelInf();

        this.add( contenedorCentral, BorderLayout.CENTER );
    }

    private void PanelInf() {

        JPanel panelInf = new JPanel();
        panelInf.setBackground( Color.DARK_GRAY );

        panelInf.setLayout( new FlowLayout() );

        JLabel etiqueta = new JLabel("@Copyright. Todos los derechos reservados. \"Proyecto POO\"");
        etiqueta.setForeground( Color.WHITE );

        panelInf.add( etiqueta );
        this.add( panelInf, BorderLayout.SOUTH );
    }

    private void BotonesSup() {

        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setBackground( Color.GREEN );

        BotonRegistro = new JButton("Registrarse");
        BotonIngreso = new JButton("Ingresar");

        contenedorBotones.add( BotonRegistro );

        contenedorBotones.add( new Box.Filler( new Dimension( 5, 50 ), new Dimension( 5, 50 ), 
                                new Dimension( 5, 50 ) ) );

        contenedorBotones.add( BotonIngreso );

        BotonRegistro.addActionListener( this );
        BotonIngreso.addActionListener( this );

        this.add( contenedorBotones,  BorderLayout.NORTH );
    }

    private void defPanel( PanelRegistro panel ) {

        contenedorCentral.setViewportView( panel );
    }

    private void defPanel( PanelIngreso panel ) {

        contenedorCentral.setViewportView( panel );
    }
    
    @Override
    public void actionPerformed( ActionEvent ae ) {
        
        if( ae.getSource() == BotonRegistro ) {
            
            panelRegistro.setVisible( true );
            defPanel( panelRegistro );
            
        } if( ae.getSource() == BotonIngreso ) {

            panelIngreso.setVisible( true );
            defPanel( panelIngreso );
        }
    }
}
