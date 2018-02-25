package edu.ude.bedelia.logica.utiles;

public class Helper {

	public static boolean calificacionEsValida(int calif) {
		return calif >= Constantes.NOTA_MINIMA && calif <= Constantes.NOTA_MAXIMA;
	}
}
