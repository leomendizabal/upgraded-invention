package edu.ude.bedelia.presentacion;

public final class Helper {

	public static boolean isEmpty(String... args) {
		boolean resultado = false;
		if (args.length > 0) {
			int i = 0, tam = args.length;
			while (i < tam && !resultado) {
				resultado = args[i] == null || args[i].trim().isEmpty();
				i += 1;
			}
		} else {
			resultado = true;
		}
		return resultado;

	}

	public static boolean isEmpty(Boolean... args) {
		boolean resultado = false;
		if (args.length > 0) {
			int i = 0, tam = args.length;
			while (i < tam && !resultado) {
				resultado = args[i] == null;
				i += 1;
			}
		} else {
			resultado = true;
		}

		return resultado;

	}

}
