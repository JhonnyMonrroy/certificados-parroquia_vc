/**
 * ConfiguracionServiceTest.java
 */
package com.breakdark.certificados_parroquia.model.Configuracion;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.breakdark.certificados_parroquia_vc.model.Configuracion.Configuracion;
import com.breakdark.certificados_parroquia_vc.model.Configuracion.ConfiguracionService;

/**
 * @author BreakDark (Jhonny Monrroy)
 * @version 1.0 23 abr. 2017
 */
public class ConfiguracionServiceTest {

	private static ConfiguracionService configuracionService;

	// elementos que seran parte de la prueba
	Configuracion configuracion1;
	Configuracion configuracion2;
	Configuracion configuracion3;

	/**
	 * Cargamos los datos basicos para la prueba
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// eliminar la base de datos de prueba antes de iniciar los test
		// File test_db = new File("data//parroquia_test.sqlite");
		// Assert.assertTrue("No se pudo eliminar la base de datos de prueba",
		// test_db.delete());
		// cargamos el bautismoService
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config_test.xml");
		configuracionService = (ConfiguracionService) context.getBean("configuracionService");

		// datos de prueba
		this.configuracion1 = new Configuracion();
		configuracion1.setFecha(new Date());
		configuracion1.setNombre_parroco("Parroco 1");
		configuracion1.setNombre_parroquia("Parroquia 1");
		configuracion1.setOficial(false);

		this.configuracion2 = new Configuracion();
		configuracion2.setFecha(java.sql.Date.valueOf("1980-09-11"));
		configuracion2.setNombre_parroco("Parroco 2");
		configuracion2.setNombre_parroquia("Parroquia 2");
		configuracion2.setOficial(false);

		this.configuracion3 = new Configuracion();
		configuracion3.setFecha(new Date());
		configuracion3.setNombre_parroco("Test Parroco");
		configuracion3.setNombre_parroquia("Testa Parroquia");
		configuracion3.setOficial(true);
	}

	/**
	 * Al finalizar cada test
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		// eliminamos las configuraciones despues de utilizarlo
		for (Configuracion configuracion : configuracionService.obtenerTodasLasConfiguraciones()) {
			configuracionService.eliminarConfiguracionDeId(configuracion.getId());
		}
	}

	/**
	 * Verificamos que el configuracionService se ha instanciado correctamente
	 */
	@Test
	public void testInstanciaConfiguracionService() {
		Assert.assertNotNull("La clase configuracionService es Null", configuracionService);
	}

	/**
	 * Test method for
	 * {@link com.breakdark.certificados_parroquia_vc.model.Configuracion.ConfiguracionService#adicionarConfiguracion(com.breakdark.certificados_parroquia_vc.model.Configuracion.Configuracion)}.
	 */
	@Test
	public void testAdicionarConfiguracion() {
		Configuracion configuracion_test = configuracionService.adicionarConfiguracion(configuracion1);
		Assert.assertNotNull("Al adicionar el configuracion retorna Null", configuracion_test);
		configuracion1.setId(configuracion_test.getId());
		Assert.assertEquals("La configuracion de la base de datos es distinta a la configuracion original.",
				configuracion1, configuracion_test);
	}

	/**
	 * Test method for
	 * {@link com.breakdark.certificados_parroquia_vc.model.Configuracion.ConfiguracionService#obtenerTodasLasConfiguraciones()}.
	 */
	@Test
	public void testObtenerTodasLasConfiguraciones() {
		List<Configuracion> configuraciones_test = configuracionService.obtenerTodasLasConfiguraciones();
		Assert.assertNotNull("El listado es Null", configuraciones_test);
		// si adicionamos un bautismo la lista deberia ser tamaño_original+1
		configuracionService.adicionarConfiguracion(configuracion1);
		Assert.assertEquals("La lista no se incrementa al adicionar una nueva configuracion.",
				configuraciones_test.size() + 1, configuracionService.obtenerTodasLasConfiguraciones().size());
	}

	/**
	 * Test method for
	 * {@link com.breakdark.certificados_parroquia_vc.model.Configuracion.ConfiguracionService#obtenerConfiguracionDeId(java.lang.Integer)}.
	 */
	@Test
	public void testObtenerConfiguracionDeId() {
		Configuracion configuracion_result = configuracionService.adicionarConfiguracion(configuracion1);
		Assert.assertNotNull("El resultado devolvio null",
				configuracionService.obtenerConfiguracionDeId(configuracion_result.getId()));
		Assert.assertEquals("La configuracion obtenida es distinta al registrado con el id enviado", configuracion1,
				configuracion_result);
		Assert.assertNull("Deberia obtenerse null con un id negativo",
				configuracionService.obtenerConfiguracionDeId(-1));
	}

	/**
	 * Test method for
	 * {@link com.breakdark.certificados_parroquia_vc.model.Configuracion.ConfiguracionService#obtenerConfiguracionOficial()}.
	 */
	@Test
	public void testObtenerConfiguracionOficial() {
		configuracionService.adicionarConfiguracion(configuracion1);
		configuracionService.adicionarConfiguracion(configuracion2);
		configuracionService.adicionarConfiguracion(configuracion3);
		Assert.assertNotNull("El resultado devolvio null", configuracionService.obtenerConfiguracionOficial());
		Assert.assertEquals("La configuracion obtenida es distinta a la configuracion oficial", configuracion3,
				configuracionService.obtenerConfiguracionOficial());
	}

	/**
	 * Metodo test para
	 * {@link com.breakdark.certificados_parroquia_vc.model.Configuracion.ConfiguracionService#eliminarConfiguracionDeId()}.
	 * Probamos que se puede eliminar un registro configuracion
	 */
	@Test
	public void testEliminarConfiguracionDeId() {
		Configuracion configuracion_result = configuracionService.adicionarConfiguracion(configuracion1);
		Assert.assertNotNull("El resultado devolvio null",
				configuracionService.obtenerConfiguracionDeId(configuracion_result.getId()));
		Assert.assertTrue("No se obtiene true al eliminar el objeto",
				configuracionService.eliminarConfiguracionDeId(configuracion_result.getId()));
		Assert.assertNull("Deberia obtenerse null al buscar la configuracion del mismo id eliminado",
				configuracionService.obtenerConfiguracionDeId(configuracion_result.getId()));
	}

}
