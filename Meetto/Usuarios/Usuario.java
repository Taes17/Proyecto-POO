package meetto.usuarios;

public class Usuario {

    String nombre;
    String email;
    int edad;
    String password;

    Usuario() {}

    Usuario( String nombre, String email, int edad, String password ) {

        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.password = password;
    }

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

    String getPassword() {

        return this.password;
    }

    public String toString() {
        return "\n" + this.nombre + "\n" + this.email + "\n" + this.password;
    }
}
