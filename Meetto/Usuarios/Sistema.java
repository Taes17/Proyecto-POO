import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Sistema {

    Map<String, Usuario> usuarios;
    Scanner sc;

    Sistema() {

        this.usuarios = new HashMap<String, Usuario>();
        /* NO se si aqui pero deberia de ir la serializacion para el mapa*/
        this.sc = new Scanner( System.in );
    }

    void Registro() {
        
        MyException ex = new MyException();

        try {
            //se implementa lo neceario para que en la interfaz grafica salga este campo
            String nombre = sc.nextLine();
            ex.ValidarNombre( nombre );
            //se implementa lo necesario par que salga el campo de la edad
            int edad = sc.nextInt(); //Excepcion para validar correo, que sea con una estructura correcta, con @ y todo
            ex.ValidarEdad( edad );
            //se implementa lo neceario para que en la interfaz grafica salga este campo
            String email = sc.next();
            ex.ValidarEmail( email );

            Usuario u = new Usuario();

            u.setNombre( nombre );
            u.setEdad( edad );
            u.setEmail( email );
            
            usuarios.put( email, u );
        } catch( NombreInvalido ni ) {

            System.out.println( ni.getMessage() );
        } catch( InputMismatchException ime ) {

            System.out.println( "Ingrese solo numeros." );
        } catch( EdadInvalida ei ) {

            System.out.println( ei.getMessage() );
        } catch( EmailInvalido ci ) {

            System.out.println( ci.getMessage() );
        }
    }
}
