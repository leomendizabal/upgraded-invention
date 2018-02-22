import edu.ude.bedelia.persistencia.fachada.FachadaPersistencia;

public class SantiMain {

	public static void main(String[] args) {
		// FachadaPersistencia.getInstance().respaldarDatos(DataClass.ALUMNOS);
		FachadaPersistencia.getInstance().recuperarDatos();
	}

}
