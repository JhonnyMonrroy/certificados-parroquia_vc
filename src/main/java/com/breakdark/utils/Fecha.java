package com.breakdark.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Libreria para manejar fechas
 * 
 * @author BreakDark (Jhonny Monrroy)
 * @version 1.0 18/04/2017
 */
public class Fecha {

	/**
	 * Metodo que parsea un objeto Date a un string con formato de fecha larga
	 * 
	 * @param fecha
	 *            Objeto <code>Date</code> a parsear
	 * @return Un objeto <code>String</code> con la fecha ya parseada, obtiene
	 *         una fecha tipo: "Jueves 11 de Septiembre de 1980",
	 *         <code>null</code> en el caso de que ocurriese algun error
	 */
	public static String obtenerFechaLarga(Date fecha) {
		try {
			Calendar fech = Calendar.getInstance();
			fech.setTime(fecha);
			String[] dias = { "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
			return dias[fech.get(Calendar.DAY_OF_WEEK) - 1] + " " + fech.get(Calendar.DAY_OF_MONTH) + " de "
					+ obtenerMes(fecha) + " de " + fech.get(Calendar.YEAR);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Metodo que parsea un objeto Date a un string con formato de fecha corta
	 * 
	 * @param fecha
	 *            Objeto <code>Date</code> a parsear
	 * @return Un objeto <code>String</code> con la fecha ya parseada, obtiene
	 *         una fecha tipo: "11 de Septiembre de 1980", <code>null</code> en
	 *         el caso de que ocurriese algun error
	 */
	public static String obtenerFecha(Date fecha) {
		try {
			Calendar fech = Calendar.getInstance();
			fech.setTime(fecha);
			return "" + fech.get(Calendar.DAY_OF_MONTH) + " de " + obtenerMes(fecha) + " de " + fech.get(Calendar.YEAR);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Obtiene el literal del mes del objeto Date enviado
	 * 
	 * @param fecha
	 *            Objeto <code>Date</code> a parsear
	 * @return Un objeto <code>String</code> con el mes ya parseada, obtiene una
	 *         texto tipo: "Enero, Fecrero, Abril...", <code>null</code> en el
	 *         caso de que ocurriese algun error
	 */
	public static String obtenerMes(Date fecha) {
		try {
			Calendar fech = Calendar.getInstance();
			fech.setTime(fecha);
			String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
					"Octubre", "Noviembre", "Diciembre" };
			return meses[fech.get(Calendar.MONTH)];
		} catch (Exception ex) {
			return null;
		}
	}

}
