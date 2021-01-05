package meetto.usuarios;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {

    private HashMap<String, Usuario> usuarios;
    private Scanner sc;

    public Sistema() {

        this.usuarios = new HashMap<String, Usuario>();
        this.sc = new Scanner( System.in );
    }

    public String Registro( String nombre, int edad, String email, String password, String repPassword ) {
        
        String str = "";

        try {

            MyException ex = new MyException();

            ex.ValidarNombre( nombre );
            ex.ValidarEdad( edad );
            ex.ValidarEmail( email );
            ex.validarPassword( password, repPassword );
            
            if( usuarios.containsKey( email ) ) {
           
                System.out.println( "El correo que trata de utilizar para registrarse, ya ha sido usado para crear otra cuenta" );
                str = "El correo que trata de utilizar para registrarse, ya ha sido usado para crear otra cuenta";
            } else {

                usuarios.put( email, new Usuario( nombre, email, edad, password ) );
                System.out.println( "Registro exitoso." + usuarios.get(email) );
                str = "Registro exitoso.";
            }

        } catch( NombreInvalido ni ) {

            str = ni.getMessage();
            System.out.println( ni.getMessage() );
        } catch( InputMismatchException ime ) {

            str = "Ingrese solo numeros";
            System.out.println( "Ingrese solo numeros." );
        } catch( EdadInvalida ei ) {

            str = ei.getMessage();
            System.out.println( ei.getMessage() );
        } catch( EmailInvalido ci ) {

            str = ci.getMessage();
            System.out.println( ci.getMessage() );
        } catch( PasswordError pe ) {

            str = pe.getMessage();
            System.out.println( pe.getMessage() );
        }

        return str;
    }

    public String Ingresar( String email, String password ) {

        Usuario u = null;

        try {

            MyException ex = new MyException();

            ex.ValidarEmail( email );

            if( usuarios.containsKey( email ) ) {

                u = usuarios.get( email );
                if( u.getPassword().equals( password ) ) return "Ingreso correcto";
                else return "Contraseña incorrecta.";
            } else {

                System.out.println("El email que trata de usar no se encuentra registrado registrado");
                return "El email que trata de usar no se encuentra registrado registrado.";
            }

        } catch( EmailInvalido ci ) {

            System.out.println( ci.getMessage() );
            return ci.getMessage();
        } 

        //return "Ingreso correcto";
    }
}
