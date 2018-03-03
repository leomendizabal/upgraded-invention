package edu.ude.bedelia.presentacion.controladores;

import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.ude.bedelia.logica.vo.VOAsignatura;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;
import edu.ude.bedelia.presentacion.panel.listener.IMensaje;
import edu.ude.bedelia.presentacion.tablemodel.AsignaturaModel;

public class ControlladorListadoAsignatura extends Controllador implements Controllador.IListar {

	private static ControlladorListadoAsignatura instancia;
	private ICargarTabla listener;

	protected ControlladorListadoAsignatura(ICargarTabla listener) {
		super();
		this.listener = listener;
	}

	public static ControlladorListadoAsignatura getInstancia(ICargarTabla listener) {
		if (instancia == null) {
			instancia = new ControlladorListadoAsignatura(listener);
		}

		return instancia;
	}

	@Override
	public void listar(String... argumentos) {
		try {
			List<VOAsignatura> resultado = fachada.listarAsignaturas();
			List<Field> lista = new ArrayList<>(Arrays.asList(VOAsignatura.class.getDeclaredFields()));

			List<String> columnas = lista.stream().map(object -> object.getName()).collect(Collectors.toList());
			listener.cargarTabla(new AsignaturaModel(resultado, columnas));

		} catch (RemoteException e) {
			// TODO colocar error amigables
			listener.mostrarError("Error", e.getMessage());
		}

	}
}
