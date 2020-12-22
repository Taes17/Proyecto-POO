import java.lang.Exception;

public class MyException {
    
    MyException() {}

    void ValidarNombre( String nombre ) throws NombreInvalido {

        if( !nombre.matches("^([A-Z]{1}[a-z]+[ ]*){1,4}") ) throw new NombreInvalido();
    }

    void ValidarEdad( int edad ) throws EdadInvalida {

        if( edad < 18 ) throw new EdadInvalida();
    }

    void ValidarEmail( String email ) throws EmailInvalido {

        if( !email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") ) throw new EmailInvalido();
    }

    void validarPassword( String password ) throws PasswordInseguro {

        if( !password.matches("^[A-Za-z|$|@|!]{8}") ) throw new PasswordInseguro();
    }
}

class NombreInvalido extends Exception {

    NombreInvalido() {
        super("El nombre que ingreso es invalido.");
    }
}

class EdadInvalida extends Exception {

    EdadInvalida() {
        super("La edad que ingreso es insuficiente para crear una cuenta en Meetto.");
    }
}

class EmailInvalido extends Exception {

    EmailInvalido() {
        super("El correo que ingreso es invalido.");
    }
}

class PasswordInseguro extends Exception {

    PasswordInseguro() {
        super("El password que ingreso es muy inseguro.");
    }
}