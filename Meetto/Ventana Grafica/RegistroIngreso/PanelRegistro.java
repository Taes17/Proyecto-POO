package meetto.ventana_grafica.registro_ingreso;

import meetto.usuarios.*;

//Interfacex graficas
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BoxLayout;
import  java.awt.Dimension;

//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistro extends JPanel implements ActionListener {

    JButton BotonRegistro;
    JButton BotonRegreso;

    JTextField CajaNombre;
    JTextField CajaEdad;
    JTextField CajaEmail; 
    JTextField CajaPassword;
    JTextField CajaRepPassword;

    JLabel etiquetaMensaje;

    Sistema s;

    public PanelRegistro( Sistema s ) {

        this.setBackground( Color.WHITE ); //Establecemos el color del panel
        this.setVisible( true );
        //this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ));
        this.setLayout( null );
        this.addComponentes();

        this.s = s;
    }

    private void addComponentes() {

        JLabel etiquetaNombre = new JLabel("Nombre(s)");
        this.add( etiquetaNombre ); //Agregamos la etiqueta al panel
        etiquetaNombre.setBounds( 30, 30, 100, 30 );

        CajaNombre = new JTextField();
        this.add( CajaNombre );
        CajaNombre.setBounds( 150, 30, 300, 30 );

        JLabel etiquetaEdad = new JLabel("Edad");
        this.add( etiquetaEdad ); //Agregamos la etiqueta al panel
        etiquetaEdad.setBounds( 490, 30, 50, 30 );

        CajaEdad = new JTextField();
        this.add( CajaEdad );
        CajaEdad.setBounds( 550, 30, 50, 30 );

        JLabel etiquetaEmail = new JLabel("Email");
        this.add( etiquetaEmail ); //Agregamos la etiqueta al panel
        etiquetaEmail.setBounds( 30, 80, 100, 30 );

        CajaEmail = new JTextField();
        this.add( CajaEmail );
        CajaEmail.setBounds( 150, 80, 450, 30 );

        JLabel etiquetaPassword = new JLabel("Contraseña");
        this.add( etiquetaPassword ); //Agregamos la etiqueta al panel
        etiquetaPassword.setBounds( 30, 130, 100, 30 );

        CajaPassword = new JTextField();
        this.add( CajaPassword );
        CajaPassword.setBounds( 220, 130, 300, 30 );

        JLabel etiquetaRepPassword = new JLabel( "Confirma tu contraseña" );
        this.add( etiquetaRepPassword ); //Agregamos la etiqueta al panel
        etiquetaRepPassword.setBounds( 30, 180, 200, 30 );

        CajaRepPassword = new JTextField();
        this.add( CajaRepPassword );
        CajaRepPassword.setBounds( 220, 180, 300, 30 );

        etiquetaMensaje = new JLabel();
        this.add( etiquetaMensaje );
        etiquetaMensaje.setBounds( 30, 280, 100, 30);

        BotonRegistro = new JButton("Registrarse");
        this.add( BotonRegistro );
        BotonRegistro.setBounds( 500, 230, 200, 30);

        BotonRegistro.addActionListener( this );
    }

    @Override
    public void actionPerformed( ActionEvent ae ) {
        
        if( ae.getSource() == BotonRegistro ) {
     
            etiquetaMensaje.setText( s.Registro( CajaNombre.getText(), Integer.parseInt( CajaEdad.getText() ), 
                                    CajaEmail.getText(), CajaPassword.getText(), CajaRepPassword.getText() ));

            if( etiquetaMensaje.getText().equals("Registro exitoso.") ) {

                CajaNombre.setText( null );
                CajaEdad.setText( null );
                CajaEmail.setText( null );
                CajaPassword.setText( null );
                CajaRepPassword.setText( null );

                this.setVisible( false ); 
            }
        }
    }
}
