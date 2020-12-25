package ventana_grafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

import usuarios.*;

public class PanelRegistro extends JPanel implements ActionListener {

    JButton BotonRegistro;

    JTextField CajaNombre;
    JTextField CajaEdad;
    JTextField CajaEmail; 
    JTextField CajaPassword;
    JTextField CajaRepPassword;

    JLabel etiquetaMensaje;

    boolean done;

    PanelRegistro() {
        
        this.setBackground( Color.WHITE ); //Establecemos el color del panel
        this.setVisible( false );
        this.setLayout( null );

        this.Botones();
        this.Etiquetas();
        this.CajasDeTexto();
    }

    private void Botones() {

        BotonRegistro = new JButton("Registrarse");
        BotonRegistro.setBounds( 500, 280, 200, 30 );
        this.add( BotonRegistro );
        
        BotonRegistro.addActionListener( this );
    }

    private void Etiquetas() {
        
        JLabel etiquetaNombre = new JLabel("Nombre(s)");
        etiquetaNombre.setBounds( 50, 10, 100, 30 );
        this.add( etiquetaNombre ); //Agregamos la etiqueta al panel

        JLabel etiquetaEdad = new JLabel("Edad");
        etiquetaEdad.setBounds( 500, 10, 100, 30 );
        this.add( etiquetaEdad ); //Agregamos la etiqueta al panel

        JLabel etiquetaEmail = new JLabel("Correo");
        etiquetaEmail.setBounds( 50, 90, 100, 30 );
        this.add( etiquetaEmail ); //Agregamos la etiqueta al panel

        JLabel etiquetaPassword = new JLabel("Contraseña");
        etiquetaPassword.setBounds( 50, 170, 200, 30 );
        this.add( etiquetaPassword ); //Agregamos la etiqueta al panel

        JLabel etiquetaRepPassword = new JLabel( "Confirma tu contraseña" );
        etiquetaRepPassword.setBounds( 300, 170, 300, 30 );
        this.add( etiquetaRepPassword ); //Agregamos la etiqueta al panel

        etiquetaMensaje = new JLabel();
        etiquetaMensaje.setBounds( 50, 250, 300, 30 );
        this.add( etiquetaMensaje );
    }

    private void CajasDeTexto() {

        CajaNombre = new JTextField();
        CajaNombre.setBounds( 50, 50, 400, 30 );
        this.add( CajaNombre );

        CajaEdad = new JTextField();
        CajaEdad.setBounds( 500, 50, 50, 30 );
        this.add( CajaEdad );

        CajaEmail = new JTextField();
        CajaEmail.setBounds( 50, 130, 400, 30 );
        this.add( CajaEmail );

        CajaPassword = new JTextField();
        CajaPassword.setBounds( 50, 210, 200, 30 );
        this.add( CajaPassword );

        CajaRepPassword = new JTextField();
        CajaRepPassword.setBounds( 300, 210, 200, 30 );
        this.add( CajaRepPassword );
    }

   
    @Override
    public void actionPerformed( ActionEvent ae ) {
        
        if( ae.getSource() == BotonRegistro ) {

            String nombre       = CajaNombre.getText();
            String email        = CajaEmail.getText();
            int edad            = Integer.parseInt( CajaEdad.getText() );
            String password     = CajaPassword.getText();
            String repPassword  = CajaRepPassword.getText();

            Sistema s = new Sistema();

            done = s.Registro( nombre, edad, email, password, repPassword, etiquetaMensaje );
        }
    }
}
