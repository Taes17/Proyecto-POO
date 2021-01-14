/** LIgada con el muro general 
 * 
 * 
 * 
 * - Tafolla 
*/

//Usuario no supe como importalo perdon XD
import java.util.ArrayList;
import java.io.*;
/** LIgada con el muro general 
 * 
 * 
 * 
 * - Tafolla 
*/
public class Muro {
	static final String CARPETA = "Publicaciones";
	static final String E = "ERROR";
	static final String S = "\\";
	static final String SERIAL = "Nombres.ser";
	static final String PUBLICACION = "pbNo";
	// Recibe un usuario para saber de quien es el muro
    //Usuario u; 
	//Todos los nombres de los archivos se almacenaran dentro del arrayList para luego se mostrados en la interfaz
	ArrayList<String> publicaciones = new ArrayList<String>();
    String nombre;
	
	public static void main(String[] arg){
	boolean hola = false;
		Muro apoyo = new Muro("Pedro");
		System.out.println("Bienvenido a tu muro personal, aquí veras las publicaciones en las que te mencionen tu amigos");
		do{	
			BufferedReader br = null;
			try{
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1.- Publicar");
				System.out.println("2.- Mostrar muro");
				System.out.println("Para salir ingrese cualquier otro numero");
				System.out.print("¿Qué deseas hacer?  ");
				String almacen = br.readLine();
				int opcion = Integer.parseInt(almacen);
				hola = apoyo.menu(opcion);
			}catch(Exception e){
				System.out.println("Gran ERROR");
			}
		}while(hola);
	}
	
	boolean menu(int opcion){
		Muro apoyo = new Muro("Pedro");
		apoyo.busquedaArchivos(apoyo.nombre + S + PUBLICACION, 1);
					
		switch(opcion){
			case 1:
				if(apoyo.carpetaExiste(apoyo.nombre)){
					String origen = apoyo.obtenerDireccionP();
					//System.out.println("Usted a publicado: " + apoyo.publicaciones.size() + " cosas");
					apoyo.crearPublicacion(origen + S + CARPETA + apoyo.nombre);
					
				}
				return true;
				//break;
					
			case 2:
				apoyo.mostrarMuro();
				return true;
				//break;
					
			default:
				System.out.println("Hasta luego");
				return false;
				//break;
		}	
	}
	
	boolean carpetaExiste(String nombre){
		File publico = null;
		try{
			//System.out.println(CARPETA + nombre);
			publico = new File(CARPETA + nombre);
			if(publico.exists()){
				return true;
			}
			return false;
		}catch(Exception ex){
			return false;
		}
	}
	
	Muro(String nombre/*, Usuario U*/){
		/*this.U = U;*/
		this.nombre = nombre;
		//this.publicaciones.add(nombre);
		File publico = null;
		try{
			publico = new File(CARPETA + nombre);
			if(publico.exists() == false){
				publico.mkdir();
			}
		}catch(Exception ex){
			System.out.println("A fallado, Ayuda");
		}/*Checar que onda con la exepcion*/		
	}
	
	void busquedaArchivos(String nombre, int numero){
			//System.out.println(nombre+(char)(48 + numero));
		if (carpetaExiste(nombre + (char)(48 + numero) + ".txt")){ // en direccion se coloca el mombre del archivo 
			//System.out.println("Se encontro: " + nombre +  numero);
			publicaciones.add(nombre + (char)(48 + numero));
			busquedaArchivos(nombre, numero + 1 );
		}
		/*else{
			System.out.println("Se a culminado la operacion exitosamente");
			
		}*/
		
	}
	
	private String organizar(){
		int nPublicacion = this.publicaciones.size()+49;
		return "pbNo" + (char)(nPublicacion);
	}
	
	private String obtenerDireccionP(){
		try{
			return new java.io.File(".").getCanonicalPath(); 
		}catch(Exception ex){
			return E;
		}
	}
		
	
	void mostrarPublicacion(String nombrePublicacion, String carpeta){
		File arch = new File(carpeta + S +  nombrePublicacion);
		if(arch.exists()){
			FileInputStream aux = null;
			byte[] buffer = new byte[81];
			int nbytes;
			try{
				aux = new FileInputStream(carpeta + S +  nombrePublicacion);
				nbytes = aux.read(buffer, 0, 81);
				String texto = new String(buffer, 0, nbytes);
				System.out.println(texto);
			}catch(IOException ioe){
				System.out.println("A fallado algo");
				
			}
			//Hacer que busque los archivos y comenzar a hacer publicaciones
		}
	}
	
	void mostrarMuro(){
		System.out.println("Usted tiene "+this.publicaciones.size()+ " publicacion(es)\n");
		for(int cont = 1; cont <= this.publicaciones.size(); ++cont ){
			
			//System.out.println("Esta haciendo el ciclo e ingresa los siguientes datos: " + PUBLICACION + (char)(48 + cont) + ".txt" + " y " + CARPETA + this.nombre);
			
			mostrarPublicacion(PUBLICACION + (char)(48 + cont) + ".txt", CARPETA + this.nombre);
			
		}
	}
	
	void crearPublicacion(String carpeta){
		FileOutputStream aux = null;
		byte[] buffer = new byte[81];
		int nbytes;
		try{
			System.out.println("Escribe algo");
			nbytes = System.in.read(buffer);
			String nombre = organizar();
			aux = new FileOutputStream(carpeta+ S + nombre + ".txt");
			aux.write(buffer, 0, nbytes);
			this.publicaciones.add(nombre + ".txt");
			//System.out.println(this.publicaciones.size());
		}catch(IOException ioe){
			System.out.println("A ocurrido un error");
		}	
		
	}
	
	void subirArchivos(){
		
		
	}
	
	/*Muro( /*Usuario u ) {
        //this.u = u;
        /*Aqui se manda a llamar a cualquier metodo, etc que 
        serialice la informaciono que cada usuario tuviera en su muro/
    }*/
}

