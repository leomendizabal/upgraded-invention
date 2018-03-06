package edu.ude.bedelia.presentacion.controladores;

import java.rmi.RemoteException;

import edu.ude.bedelia.logica.excepciones.AlumnosException;
import edu.ude.bedelia.logica.vo.VOAlumno;
import edu.ude.bedelia.presentacion.panel.listener.ICargarTabla;

public class ControladorDetalleAlumno extends ControladorAlumno implements Controlador.IListar<String>{

	
	private ICargarTabla listener;
	
	public ControladorDetalleAlumno(ICargarTabla listener) {
		super(listener);
		this.listener = listener;
		
	}

	@Override
	public void listar(String... argumentos) {
		try {
			VOAlumno alumno = fachada.listarDatosAlumno(argumentos[0]);
			
		} catch (RemoteException | AlumnosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

	
	
}
