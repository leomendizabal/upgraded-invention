package edu.ude.bedelia.test;

import edu.ude.bedelia.logica.colecciones.Alumnos;
import edu.ude.bedelia.logica.colecciones.Asignaturas;
import edu.ude.bedelia.logica.entidades.Alumno;
import edu.ude.bedelia.logica.entidades.Asignatura;

public final class DataClass {

	private final static Alumno elviejo = new Alumno("90000", "Viejo", "Pancho", "asdfasd", "asdfasd",
			"asdfasd@gmail.com");
	private final static Alumno rodri = new Alumno("42587357", "Rodri", "Gordano", "asdfasd", "asdfasd",
			"asdfasd@gmail.com");
	private final static Alumno leo = new Alumno("4387792", "Leo", "Mendizabal", "asdfasd", "asdfasd",
			"asdfasd@gmail.com");
	private final static Alumno santi = new Alumno("52813398", "Santiago", "Mattiauda", "asdfasd", "asdfasd",
			"asdfasd@gmail.com");

	public final static Alumnos ALUMNOS = new Alumnos() {
		{
			insert(leo.getCedula(), leo);
			insert(santi.getCedula(), santi);
			insert(rodri.getCedula(), rodri);
			insert(elviejo.getCedula(), elviejo);
		}
	};

	public final static Asignatura cocina1 = new Asignatura("C1", "Cocina 1", "Descripcion");
	public final static Asignatura panaderia1 = new Asignatura("PYP1", "Panadería y Pastelería I (gastronomía)",
			"Descripcion");
	public final static Asignatura frances = new Asignatura("FR", "Francés", "Descripcion");
	public final static Asignatura seguridadHigiene = new Asignatura("SH", "Seguridad e Higiene", "Descripcion");
	public final static Asignatura admMarkGast1 = new Asignatura("AMG1", "Administración y Marketing Gastronómico I",
			"Descripcion");
	public final static Asignatura enologia = new Asignatura("EN", "Enología", "Descripcion");
	public final static Asignatura cocteleria = new Asignatura("CC", "Coctelería", "Descripcion");
	public final static Asignatura organizacionEvento = new Asignatura("OECP",
			"Organización de Eventos, Ceremonial y Protocolo", "Descripcion");
	public final static Asignatura alimentosBebidas = new Asignatura("AAB", "Administración de Alimentos y Bebidas",
			"Descripcion");
	public final static Asignatura pasteleria2 = new Asignatura("PP2", "Panadería y Pastelería II (gastronomía)",
			"Descripcion");

	public final static Asignaturas ASIGNATURA = new Asignaturas() {
		{
			//insert(cocina1);
			insert(panaderia1);
			insert(frances);
			insert(seguridadHigiene);
			insert(admMarkGast1);
			insert(enologia);
			insert(cocteleria);
			insert(organizacionEvento);
			insert(alimentosBebidas);
			insert(pasteleria2);
		}
	};

}
