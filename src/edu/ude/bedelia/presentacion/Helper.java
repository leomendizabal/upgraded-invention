package edu.ude.bedelia.presentacion;

public final class Helper {

	public static boolean isEmpty(String... args) {
		boolean resultado = false;
		int i = 0, tam = args.length;
		
		while(i<tam && !resultado) {
			resultado = args[i] == null || args[i].trim().isEmpty();
		}
		return resultado;
		
	}
	
	public static boolean isEmpty(Boolean... args) {
		boolean resultado = false;
		int i = 0, tam = args.length;
		
		while(i<tam && !resultado) {
			resultado = args[i] == null;
		}
		return resultado;
		
	}
	
	
}
