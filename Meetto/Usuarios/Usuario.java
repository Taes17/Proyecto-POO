public class Usuario {

    String nombre;
    String email;
    int edad;
    String password;

    Usuario() {}

    void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    void setEmail( String email ) {
        this.email = email;
    }

    void setEdad( int edad ) {
        this.edad = edad;
    }

    void setPassword( String password ) {

        this.password = password;
    }

    String getNombre() {
        return this.nombre;
    }

    String setEmail() {
        return this.email;
    }

    int setEdad() {
        return this.edad;
    }

    String setPassword() {

        return this.password;
    }
}
