package usuarios;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Sistema {

    public HashMap<String, Usuario> usuarios;
    private Scanner sc;

    public Sistema() {

        this.usuarios = new HashMap<String, Usuario>();
        /* NO se si aqui pero deberia de ir la serializacion para el mapa*/
        this.sc = new Scanner( System.in );
    }

    public boolean Registro( String nombre, int edad, String email, String password, String repPassword, JLabel mensaje ) {
        
        boolean done = false;

        try {

            MyException ex = new MyException();

            ex.ValidarNombre( nombre );
            ex.ValidarEdad( edad );
            ex.ValidarEmail( email );
            ex.validarPassword( password, repPassword );

            Usuario u = new Usuario();

            u.setNombre( nombre );
            u.setEdad( edad );
            u.setEmail( email );
            u.setPassword( password );
            
            usuarios.put( email, u );

            mensaje.setText( "Registro exitoso." );
            System.out.println( "Registro exitoso." );

            done = true;

        } catch( NombreInvalido ni ) {

            mensaje.setText( ni.getMessage() );
            System.out.println( ni.getMessage() );
        } catch( InputMismatchException ime ) {

            mensaje.setText( "Ingrese solo numeros." );
            System.out.println( "Ingrese solo numeros." );
        } catch( EdadInvalida ei ) {

            mensaje.setText( ei.getMessage() );
            System.out.println( ei.getMessage() );
        } catch( EmailInvalido ci ) {

            mensaje.setText( ci.getMessage() );
            System.out.println( ci.getMessage() );
        } catch( PasswordError pe ) {

            mensaje.setText( pe.getMessage() );
            System.out.println( pe.getMessage() );
        }

        return done;
    }

    public boolean Ingresar() {

        Usuario u = null;
        String password = "";

        try {

            MyException ex = new MyException();

            String email = sc.next();
            ex.ValidarEmail( email );

            sc.nextLine(); //Limpiar buffer del Scanner

            password = sc.nextLine();
            ex.validarPassword( password, password );
            
            u = usuarios.get( email );

        } catch( EmailInvalido ci ) {

            System.out.println( ci.getMessage() );
        } catch( PasswordError pi ) {

            System.out.println( pi.getMessage() );
        }

        if( u.getPassword().equals( password ) ) return true; //Contraseña correcta
        else return false; // Contraseña incorrecta
    }
}
