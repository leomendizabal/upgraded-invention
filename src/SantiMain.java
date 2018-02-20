import edu.ude.bedelia.persistencia.fachada.FachadaPersistencia;
import edu.ude.bedelia.test.DataClass;

public class SantiMain {

	public static void main(String[] args) {
		FachadaPersistencia.getInstance().respaldarDatos(DataClass.ALUMNOS);
		FachadaPersistencia.getInstance().recuperarDatos();
	}

}
