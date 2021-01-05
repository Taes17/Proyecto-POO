package meetto.ventana_grafica.registro_ingreso;

import meetto.usuarios.*;

//Interfacex graficas
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.LayoutManager;

//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIngreso extends JPanel implements ActionListener {
    
    JButton BotonIngreso;
    JButton BotonRegreso;

    JTextField CajaEmail; 
    JTextField CajaPassword;
    JLabel etiquetaMensaje;

    Sistema s;

    public PanelIngreso( Sistema s ) {

        this.setBackground( Color.WHITE ); //Establecemos el color del panel
        this.setVisible( false );
        this.setLayout( null );

        this.addComponentes();

        this.s = s;
    }

    private void addComponentes() {

        JLabel etiquetaEmail = new JLabel("Correo");
        this.add( etiquetaEmail ); //Agregamos la etiqueta al panel
        etiquetaEmail.setBounds( 30, 30, 100, 30 );

        CajaEmail = new JTextField();
        this.add( CajaEmail );
        CajaEmail.setBounds( 150, 30, 300, 30 );

        JLabel etiquetaPassword = new JLabel("Contraseña");
        this.add( etiquetaPassword ); //Agregamos la etiqueta al panel
        etiquetaPassword.setBounds( 30, 80, 100, 30 );

        CajaPassword = new JTextField();
        this.add( CajaPassword );
        CajaPassword.setBounds( 150, 80, 300, 30 );

        etiquetaMensaje = new JLabel();
        this.add( etiquetaMensaje );
        etiquetaMensaje.setBounds( 30, 180, 600, 30 );

        BotonIngreso = new JButton("Ingresar");
        this.add( BotonIngreso );
        BotonIngreso.setBounds( 500, 130, 100, 30);
        
        BotonIngreso.addActionListener( this );
    }

    @Override
    public void actionPerformed( ActionEvent ae ) {
        
        if( ae.getSource() == BotonIngreso ) {
     
            etiquetaMensaje.setText( s.Ingresar( CajaEmail.getText(), CajaPassword.getText() ));

            if( etiquetaMensaje.getText().equals("Ingreso correcto") ) {

                CajaEmail.setText( null );
                CajaPassword.setText( null );
                etiquetaMensaje.setText( null );

                this.setVisible( false );
            }

        } 
    }
}
