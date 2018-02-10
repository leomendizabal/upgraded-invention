import edu.ude.bedelia.logica.colecciones.DiccionarioAlumnos;
import edu.ude.bedelia.logica.entidades.Alumno;

public class Main {

	public static void main(String[] args) {
		Alumno a = new Alumno("1234", "asdf", "asdf", "asdfasd", "asdfasd", "asdfasd@gmail.com");
		DiccionarioAlumnos diccionario = new DiccionarioAlumnos();
		diccionario.insert(a.getCedula(), a);
		
		System.out.println("existe alumno? "+diccionario.member(a.getCedula()));
	}

}
