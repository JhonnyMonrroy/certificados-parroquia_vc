/**
 * 
 */
package com.breakdark.certificados_parroquia_vc.model.Bautismo;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

/**
 * Test para la clase BautismoService
 * 
 * @author BreakDark
 * @version 1.0
 */
public class BautismoServiceTest extends TestCase {

	private static BautismoService bautismoService;

	// elementos que seran parte de la prueba
	Bautismo bautismo;

	/**
	 * Se instancia la clase a probar
	 */
	@BeforeClass
	public static void iniciarClase() {
	}

	/**
	 * Cargamos los datos basicos para la prueba
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config_test.xml");
		bautismoService = (BautismoService) context.getBean("bautismoService");
		System.out.println(bautismoService);

		this.bautismo = new Bautismo();
		this.bautismo.setLibro("Libro Test");
		this.bautismo.setPagina(1234);
		this.bautismo.setPartida(123456);
		this.bautismo.setApellido_paterno("PATERNO_TEST");
		this.bautismo.setApellido_materno("MATERNO_TEST");
		this.bautismo.setNombres("NOMBRE1_TEST NOMBRE2_TEST");
		this.bautismo.setLugar_bautismo("LUGAR_BAUTISMO_TEST");
		this.bautismo.setFecha_bautismo(new Date()); // fecha actual
		this.bautismo.setLugar_nacimiento("LUGAR_NACIMIENTO_TEST");
		this.bautismo.setFecha_nacimiento(java.sql.Date.valueOf("1930-11-21")); // 21/11/1930
		this.bautismo.setPadre("PADRE DE FAMILIA_TEST");
		this.bautismo.setMadre("MADRE DE FAMILIA_TEST");
		this.bautismo.setPadrino("NOMBRE DEL PADRINO_TEST");
		this.bautismo.setMadrina("NOMBRE DE LA MADRINA_TEST");
		this.bautismo.setOficialia("NUMEROOFICIALIAREGISTROCIVIL_TEST");
		this.bautismo.setOficialia_libro("NUMERODELLIBRODELAOFICIALIA_TEST");
		this.bautismo.setOficialia_partida(12345678);
		this.bautismo.setParroco("NOMBRE PARROCO QUE OFICIALIZO EL BAUTISMO_TEST");
		this.bautismo.setNotas("NOTAS MARGINALES_TEST");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Verificamos que el bautismoService se ha instanciado correctamente
	 */
	@Test
	public void testInstanciaBautismoService() {
		Assert.assertNotNull("La clase bautismoService es Null", bautismoService);
	}

	/**
	 * Metodo test para
	 * {@link com.breakdark.certificados_parroquia_vc.model.Bautismo.BautismoService#adicionarBautismo(com.breakdark.certificados_parroquia_vc.model.Bautismo.Bautismo)}.
	 * Probamos que si se puede adicionar el objeto bautismo a la base de datos
	 */
	@Test
	public void testAdicionarBautismo() {
		// System.out.println(bautismo);
		Bautismo bautismo_test = bautismoService.adicionarBautismo(bautismo);
		Assert.assertNotNull("Al adicionar el bautismo retorna Null", bautismo_test);
		bautismo.setId(bautismo_test.getId());
		Assert.assertEquals("El bautismo de la base de datos es distinto al bautismo original.", bautismo,
				bautismo_test);
	}

	/**
	 * Metodo test para
	 * {@link com.breakdark.certificados_parroquia_vc.model.Bautismo.BautismoService#obtenerTodosLosBautismos()}.
	 * Probamos que se pueden obtener un list de todos los bautismos registrados
	 */
	@Test
	public void testObtenerTodosLosBautismos() {
		List<Bautismo> bautismos_test = bautismoService.obtenerTodosLosBautismos();
		Assert.assertNotNull("El listado es Null", bautismos_test);
		// si adicionamos un bautismo la lista deberia ser tamaño_original+1
		bautismoService.adicionarBautismo(bautismo);
		Assert.assertEquals("La lista no se incrementa al adicionar un nuevo bautismo.", bautismos_test.size() + 1,
				bautismoService.obtenerTodosLosBautismos().size());
	}

}
