package edu.ude.bedelia.presentacion;

public final class UIConstantes {

	public static final String STRING_VACIO = "";
	public static final String[] notas = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

	public static final String MONTO_RECAUDADO_TEMPLE = "El monto recaudado es: %s";

	public final class MensajesError {

		public final static String ERROR_REGISTRAR_ALUMNO = "No se puede registrar alumno";
		public final static String ERROR_VALIDAR_ALUMNO = "Se debe validar si el alumno existe";
		public final static String ERROR_DATOS_ALUMNO = "Los datos del alumno no estan completos";
		public final static String ERROR_DETALLE_ALUMNO = "Detalle del alumno";
		public final static String ERROR_REGISTRAR_ASIGNATURA = "No se puede registrar asignatura";
		public final static String ERROR_CONEXION = "No se puedo conectar";
		public final static String ERROR_CAMPO = "Los campos no pueden estar vacios";
		public final static String ERROR_FORMATO_PARAMETRO = "Por favor verifique los datos ingresados";
		public final static String ERROR_NO_SE_CARGARON_DATOS = "No hay datos para mostrar";

	}

	public final class MensajesConfirmacion {

		public final static String CONF_REGISTRAR_ALUMNO = "El alumno fue registrado correctamente";
		public final static String CONF_MODIFICAR_ALUMNO = "El alumno se ha modificado correctamente";
		public final static String CONF_REGISTRAR_ASIGNATURA = "La asignatura fue registrada correctamente";
		public final static String CONF_REGISTRAR_INSCRIPCION = "La inscripcion fue registrada correctamente";
		public final static String CONF_REGISTRAR_RESULTADO = "La nota fue ingresada correctamente";
		public final static String CONF_RESPALDO = "Se han respaldado los datos";

	}

	public final class MensajeTitulo {

		public final static String TITULO_REGISTRAR = "Registrar";
		public final static String TITULO_REGISTRAR_RESULTADO = "Registrar resultado";
		public final static String TITULO_REGISTRAR_ASIGNATURA = "Registrar asignatura";
		public final static String TITULO_REGISTRAR_INSCRIPCION = "Registrar inscripcion";
		public final static String TITULO_REGISTRAR_ALUMNO = "Registrar alumno";
		public final static String TITULO_ERROR = "Error";
		public final static String TITULO_BUSCAR = "Buscar";
		public final static String TITULO_MODIFICAR = "Modificar";
		public final static String TITULO_LISTAR_ASIGNATURAS = "Listado asignaturas";
		public final static String TITULO_LISTAR = "Listar";
		public final static String TITULO_RESPALDAR = "Respaldar";
	}
}
