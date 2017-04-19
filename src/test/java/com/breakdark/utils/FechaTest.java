package com.breakdark.utils;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test para la clase Fecha
 * 
 * @author BreakDark
 * @version 1.0 18/04/2017
 */
public class FechaTest {
	@Test
	public void testObtenerFechaLarga() {
		Date fecha = java.sql.Date.valueOf("1980-09-11");
		Assert.assertNotNull("El resultado al enviar un objeto date es null", Fecha.obtenerFechaLarga(fecha));
		Assert.assertEquals("No se obtiene la fecha correcta", "Jueves 11 de Septiembre de 1980",
				Fecha.obtenerFechaLarga(fecha));
		Assert.assertNull("Se esperaba un null al enviar un null como parametro", Fecha.obtenerFechaLarga(null));
	}

	@Test
	public void testObtenerFecha() {
		Date fecha = java.sql.Date.valueOf("1980-09-11");
		Assert.assertNotNull("El resultado al enviar un objeto date es null", Fecha.obtenerFecha(fecha));
		Assert.assertEquals("No se obtiene la fecha correcta", "11 de Septiembre de 1980", Fecha.obtenerFecha(fecha));
		fecha = java.sql.Date.valueOf("2000-04-12");
		Assert.assertEquals("No se obtiene la fecha correcta", "12 de Abril de 2000", Fecha.obtenerFecha(fecha));
		Assert.assertNull("Se esperaba un null al enviar un null como parametro", Fecha.obtenerFecha(null));
	}

	@Test
	public void testObtenerMes() {
		Date fecha = java.sql.Date.valueOf("1980-09-11");
		Assert.assertNotNull("El resultado al enviar un objeto date es null", Fecha.obtenerMes(fecha));
		Assert.assertEquals("No se obtiene la fecha correcta", "Septiembre", Fecha.obtenerMes(fecha));
		fecha = java.sql.Date.valueOf("2000-04-12");
		Assert.assertEquals("No se obtiene la fecha correcta", "Abril", Fecha.obtenerMes(fecha));
		fecha = java.sql.Date.valueOf("2000-11-12");
		Assert.assertEquals("No se obtiene la fecha correcta", "Noviembre", Fecha.obtenerMes(fecha));
		fecha = java.sql.Date.valueOf("2000-12-12");
		Assert.assertEquals("No se obtiene la fecha correcta", "Diciembre", Fecha.obtenerMes(fecha));
		Assert.assertNull("Se esperaba un null al enviar un null como parametro", Fecha.obtenerMes(null));
	}
}
