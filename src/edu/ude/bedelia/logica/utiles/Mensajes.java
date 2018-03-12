package edu.ude.bedelia.logica.utiles;

public final class Mensajes {
	// TODO: Ver si se puede agrupar mensajes, para que quede mas claro.
	public final static String MSG_MAXIMO_MATERIAS_SUPERADO = "La cantidad maxima de materias es %d";

	public final static String MSG_NO_EXISTEN_ALUMNOS_APELLIDO = "No existen alumnos con ese apellido";
	public final static String MSG_NO_EXISTEN_ALUMNOS_EGRESADOS = "No existen alumnos egresados";
	public final static String ALUMNO_NO_INSCRIPTO = "El alumno no esta inscripto a esta asignatura";
	public final static String MSG_NO_EXISTEN_ASIGNATURAS = "No existen asignaturas";
	public final static String MSG_YA_EXISTE_ASIGNATURA = "Ya existe una asignatura con dicho codigo en el sistema";
	public final static String MSG_ALUMNO_NO_EXISTE = "El alumno no existe en el sistema";
	public final static String MSG_ALUMNO_YA_APROBO_ASIGNATURA = "El alumno ya aprob� la asignatura";
	public final static String MSG_ALUMNO_YA_ESTA_INSCRIPTO_ASIGANTURA = "El alumno ya est� inscripto a esta asignatura";
	public final static String MSG_ANO_NO_COINCIDE_CON_ACTUAL = "El a�o lectivo no coincide con el actual";
	public final static String MSG_NUMERO_INSCRIPCION_INCORRECTO = "El numero de inscripcion es incorrecto";
	public final static String MSG_ASIGNATURA_NO_EXISTE = "La asignatura con el codigo %s no existe";

	public final static String MSG_EXISTE_ALUMNO = "Ya existe un alumno con cedula %s";
	public final static String MSG_NO_EXISTE_ALUMNO = "El alumno con cedula %s no existe";
	public final static String MSG_CALIF_INVALIDA = "La calificacion es invalida";

	public static String mensaje(String templete, String referencia) {
		return String.format(templete, referencia);
	}

}
