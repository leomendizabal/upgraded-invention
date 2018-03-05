package edu.ude.bedelia.presentacion.controladores;

import edu.ude.bedelia.aplicacion.Sistema;
import edu.ude.bedelia.logica.fachada.IFachada;

//TODO: ver si no conviene usar una interfaces
public abstract class Controlador {

	protected final IFachada fachada;

	public Controlador() {
		super();
		this.fachada = Sistema.getInstancia().getFachadaInstance();
	}

	public interface IRegistrar {
		public void registrar(String... argumentos);
	}

	public interface IListar<T> {
		@SuppressWarnings("unchecked")
		public void listar(T... argumentos);
	}

	public interface IModificar {
		public void modificar(String... argumentos);
	}

}
