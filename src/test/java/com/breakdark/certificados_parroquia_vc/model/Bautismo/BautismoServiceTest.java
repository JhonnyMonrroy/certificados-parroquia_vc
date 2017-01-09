/**
 * 
 */
package com.breakdark.certificados_parroquia_vc.model.Bautismo;

import java.io.File;
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
	Bautismo bautismo1;
	Bautismo bautismo2;
	Bautismo bautismo3;

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
		// eliminar la base de datos de prueba antes de iniciar los test
		File test_db = new File("data//parroquia_test.sqlite");
		Assert.assertTrue("No se pudo eliminar la base de datos de prueba", test_db.delete());
		// cargamos el bautismoService
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config_test.xml");
		bautismoService = (BautismoService) context.getBean("bautismoService");

		// datos de prueba
		this.bautismo1 = new Bautismo();
		this.bautismo1.setLibro("Libro Test");
		this.bautismo1.setPagina(1234);
		this.bautismo1.setPartida(123456);
		this.bautismo1.setApellido_paterno("PATERNO_TEST");
		this.bautismo1.setApellido_materno("MATERNO_TEST");
		this.bautismo1.setNombres("NOMBRE1_TEST NOMBRE2_TEST");
		this.bautismo1.setLugar_bautismo("LUGAR_BAUTISMO_TEST");
		this.bautismo1.setFecha_bautismo(new Date()); // fecha actual
		this.bautismo1.setLugar_nacimiento("LUGAR_NACIMIENTO_TEST");
		this.bautismo1.setFecha_nacimiento(java.sql.Date.valueOf("1930-11-21")); // 21/11/1930
		this.bautismo1.setPadre("PADRE DE FAMILIA_TEST");
		this.bautismo1.setMadre("MADRE DE FAMILIA_TEST");
		this.bautismo1.setPadrino("NOMBRE DEL PADRINO_TEST");
		this.bautismo1.setMadrina("NOMBRE DE LA MADRINA_TEST");
		this.bautismo1.setOficialia("NUMEROOFICIALIAREGISTROCIVIL_TEST");
		this.bautismo1.setOficialia_libro("NUMERODELLIBRODELAOFICIALIA_TEST");
		this.bautismo1.setOficialia_partida(12345678);
		this.bautismo1.setParroco("NOMBRE PARROCO QUE OFICIALIZO EL BAUTISMO_TEST");
		this.bautismo1.setNotas("NOTAS MARGINALES_TEST");

		this.bautismo2 = new Bautismo();
		this.bautismo2.setLibro("Libro Test");
		this.bautismo2.setPagina(1234);
		this.bautismo2.setPartida(123456);
		this.bautismo2.setApellido_paterno("PATERNO_TEST");
		this.bautismo2.setApellido_materno("MATERNO_TEST");
		this.bautismo2.setNombres("NOMBRE1_TEST NOMBRE2_TEST");
		this.bautismo2.setLugar_bautismo("LUGAR_BAUTISMO_TEST");
		this.bautismo2.setFecha_bautismo(new Date()); // fecha actual
		this.bautismo2.setLugar_nacimiento("LUGAR_NACIMIENTO_TEST");
		this.bautismo2.setFecha_nacimiento(java.sql.Date.valueOf("1930-11-21")); // 21/11/1930
		this.bautismo2.setPadre("PADRE DE FAMILIA_TEST");
		this.bautismo2.setMadre("MADRE DE FAMILIA_TEST");
		this.bautismo2.setPadrino("NOMBRE DEL PADRINO_TEST");
		this.bautismo2.setMadrina("NOMBRE DE LA MADRINA_TEST");
		this.bautismo2.setOficialia("NUMEROOFICIALIAREGISTROCIVIL_TEST");
		this.bautismo2.setOficialia_libro("NUMERODELLIBRODELAOFICIALIA_TEST");
		this.bautismo2.setOficialia_partida(12345678);
		this.bautismo2.setParroco("NOMBRE PARROCO QUE OFICIALIZO EL BAUTISMO_TEST");
		this.bautismo2.setNotas("NOTAS MARGINALES_TEST");

		this.bautismo3 = new Bautismo();
		this.bautismo3.setLibro("Libro Test");
		this.bautismo3.setPagina(1234);
		this.bautismo3.setPartida(123456);
		this.bautismo3.setApellido_paterno("PATERNO_TEST");
		this.bautismo3.setApellido_materno("MATERNO_TEST");
		this.bautismo3.setNombres("NOMBRE1_TEST NOMBRE2_TEST");
		this.bautismo3.setLugar_bautismo("LUGAR_BAUTISMO_TEST");
		this.bautismo3.setFecha_bautismo(new Date()); // fecha actual
		this.bautismo3.setLugar_nacimiento("LUGAR_NACIMIENTO_TEST");
		this.bautismo3.setFecha_nacimiento(java.sql.Date.valueOf("1930-11-21")); // 21/11/1930
		this.bautismo3.setPadre("PADRE DE FAMILIA_TEST");
		this.bautismo3.setMadre("MADRE DE FAMILIA_TEST");
		this.bautismo3.setPadrino("NOMBRE DEL PADRINO_TEST");
		this.bautismo3.setMadrina("NOMBRE DE LA MADRINA_TEST");
		this.bautismo3.setOficialia("NUMEROOFICIALIAREGISTROCIVIL_TEST");
		this.bautismo3.setOficialia_libro("NUMERODELLIBRODELAOFICIALIA_TEST");
		this.bautismo3.setOficialia_partida(12345678);
		this.bautismo3.setParroco("NOMBRE PARROCO QUE OFICIALIZO EL BAUTISMO_TEST");
		this.bautismo3.setNotas("NOTAS MARGINALES_TEST");
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
		Bautismo bautismo_test = bautismoService.adicionarBautismo(bautismo1);
		Assert.assertNotNull("Al adicionar el bautismo retorna Null", bautismo_test);
		bautismo1.setId(bautismo_test.getId());
		Assert.assertEquals("El bautismo de la base de datos es distinto al bautismo original.", bautismo1,
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
		bautismoService.adicionarBautismo(bautismo1);
		Assert.assertEquals("La lista no se incrementa al adicionar un nuevo bautismo.", bautismos_test.size() + 1,
				bautismoService.obtenerTodosLosBautismos().size());
	}

	/**
	 * Metodo test para
	 * {@link com.breakdark.certificados_parroquia_vc.model.Bautismo.BautismoService#buscarBautismos()}.
	 * Probamos que se pueden buscar bautismos segun los parametros enviados
	 */
	@Test
	public void testBuscarBautismos() {
		// datos de prueba
		bautismo1.setLibro("Libro 1");
		bautismo1.setPartida(123);
		bautismo1.setApellido_paterno("PEREZ");
		bautismo1.setApellido_materno("POMA");
		bautismo1.setNombres("JUAN JOSE");
		bautismo1.setFecha_bautismo(java.sql.Date.valueOf("1986-05-23"));
		bautismo1.setFecha_nacimiento(java.sql.Date.valueOf("1980-09-11"));

		bautismo2.setLibro("Libro 2");
		bautismo2.setPartida(666);
		bautismo2.setApellido_paterno("PEREZ");
		bautismo2.setApellido_materno("RAMOS");
		bautismo2.setNombres("INES");
		bautismo2.setFecha_bautismo(java.sql.Date.valueOf("1993-12-25"));
		bautismo2.setFecha_nacimiento(java.sql.Date.valueOf("1990-11-15"));

		bautismoService.adicionarBautismo(bautismo1);
		bautismoService.adicionarBautismo(bautismo2);

		// buscamos solo por el numero del libro
		Assert.assertNotNull("El resultado devolvio null",
				bautismoService.buscarBautismos("Libro inexistente", null, null, null, null, null));
		Assert.assertEquals("No deberia obtenerse bautismos", 0,
				bautismoService.buscarBautismos("Libro inexistente", null, null, null, null, null).size());
		Assert.assertTrue("Deberia obtenerse bautismos",
				bautismoService.buscarBautismos("Libro 2", null, null, null, null, null).size() > 0);
		Assert.assertEquals("Deberia obtenerse el bautismo1", bautismo1,
				bautismoService.buscarBautismos("Libro 1", null, null, null, null, null).get(0));

		// buscamos solo por el numero de partida
		Assert.assertNotNull("El resultado devolvio null",
				bautismoService.buscarBautismos(null, 123, null, null, null, null));
		Assert.assertEquals("No deberia obtenerse bautismos", 0,
				bautismoService.buscarBautismos(null, 999, null, null, null, null).size());
		Assert.assertTrue("Deberia obtenerse bautismos",
				bautismoService.buscarBautismos(null, 666, null, null, null, null).size() > 0);
		Assert.assertEquals("Deberia obtenerse el bautismo1", bautismo1,
				bautismoService.buscarBautismos(null, 123, null, null, null, null).get(0));

		// buscamos solo por el indicio del nombre
		Assert.assertNotNull("El resultado devolvio null",
				bautismoService.buscarBautismos(null, null, "poMa", null, null, null));
		Assert.assertEquals("No deberia obtenerse bautismos", 0,
				bautismoService.buscarBautismos(null, null, "RICARDO", null, null, null).size());
		Assert.assertTrue("Deberia obtenerse bautismos, en este caso mas de 1 bautismo",
				bautismoService.buscarBautismos(null, null, "peRe", null, null, null).size() > 1);
		Assert.assertEquals("Deberia obtenerse el bautismo1", bautismo1,
				bautismoService.buscarBautismos(null, null, "perez poma juan jose", null, null, null).get(0));

		// buscamos solo por la fecha de bautismo
		Assert.assertNotNull("El resultado devolvio null",
				bautismoService.buscarBautismos(null, null, null, "bautismo", null, null));
		Assert.assertTrue("Deberian obtenerse todos los bautismos",
				bautismoService.buscarBautismos(null, null, null, "bautismo", null, null).size() == 2);
		Assert.assertEquals("No deberia obtenerse bautismos", 0, bautismoService.buscarBautismos(null, null, null,
				"bautismo", java.sql.Date.valueOf("1980-01-01"), java.sql.Date.valueOf("1985-01-01")).size());
		Assert.assertEquals("No deberia obtenerse bautismos", 0, bautismoService.buscarBautismos(null, null, null,
				"bautismo", java.sql.Date.valueOf("1999-01-01"), java.sql.Date.valueOf("2016-01-01")).size());
		Assert.assertTrue("Deberia obtenerse bautismos, en este caso mas de 1 bautismo",
				bautismoService.buscarBautismos(null, null, null, "bautismo", java.sql.Date.valueOf("1980-01-01"),
						java.sql.Date.valueOf("2016-01-01")).size() > 1);
		Assert.assertEquals("Deberia obtenerse el bautismo1", bautismo1, bautismoService.buscarBautismos(null, null,
				null, "bautismo", java.sql.Date.valueOf("1982-01-01"), java.sql.Date.valueOf("1990-01-01")).get(0));

		// buscamos solo por la fecha de nacimiento
		Assert.assertNotNull("El resultado devolvio null",
				bautismoService.buscarBautismos(null, null, null, "nacimiento", null, null));
		Assert.assertTrue("deberia obtenerse todos los bautismos",
				bautismoService.buscarBautismos(null, null, null, "nacimiento", null, null).size() == 2);
		Assert.assertEquals("No deberia obtenerse bautismos", 0, bautismoService.buscarBautismos(null, null, null,
				"nacimiento", java.sql.Date.valueOf("1980-01-01"), java.sql.Date.valueOf("1980-04-01")).size());
		Assert.assertEquals("No deberia obtenerse bautismos", 0, bautismoService.buscarBautismos(null, null, null,
				"nacimiento", java.sql.Date.valueOf("1999-01-01"), java.sql.Date.valueOf("2016-01-01")).size());
		Assert.assertTrue("Deberia obtenerse bautismos, en este caso mas de 1 bautismo",
				bautismoService.buscarBautismos(null, null, null, "nacimiento", java.sql.Date.valueOf("1980-01-01"),
						java.sql.Date.valueOf("2016-01-01")).size() > 1);
		Assert.assertEquals("Deberia obtenerse el bautismo1", bautismo1, bautismoService.buscarBautismos(null, null,
				null, "nacimiento", java.sql.Date.valueOf("1980-01-01"), java.sql.Date.valueOf("1980-12-31")).get(0));

		// Pruebas de busquedas mixtas
		Assert.assertNotNull("El resultado devolvio null",
				bautismoService.buscarBautismos("Libro 1", 666, "poma", "nacimiento", null, null));
		Assert.assertEquals("No deberia obtenerse bautismos", 0,
				bautismoService.buscarBautismos("Libro 1", 666, "poma", "nacimiento", null, null).size());
		Assert.assertEquals("No deberia obtenerse bautismos", 0,
				bautismoService.buscarBautismos("Libro 3", 999, "romero", "nacimiento",
						java.sql.Date.valueOf("1980-01-01"), java.sql.Date.valueOf("1980-04-01")).size());
		Assert.assertEquals("No deberia obtenerse bautismos", 0, bautismoService.buscarBautismos(null, null, "poma",
				"nacimiento", java.sql.Date.valueOf("1999-01-01"), java.sql.Date.valueOf("2016-01-01")).size());
		Assert.assertTrue("Deberia obtenerse bautismos, en este caso mas de 1 bautismo",
				bautismoService.buscarBautismos(null, null, "perez", "bautismo", java.sql.Date.valueOf("1980-01-01"),
						java.sql.Date.valueOf("2016-01-01")).size() > 1);
		Assert.assertEquals("Deberia obtenerse bautismos, en este caso el bautismo2", bautismo2,
				bautismoService.buscarBautismos("Libro 2", null, null, "bautismo", java.sql.Date.valueOf("1980-01-01"),
						java.sql.Date.valueOf("2016-12-31")).get(0));
		Assert.assertEquals("Deberia obtenerse el bautismo1", bautismo1,
				bautismoService.buscarBautismos("Libro 1", 123, "perez poma juan jose", "nacimiento",
						java.sql.Date.valueOf("1980-01-01"), java.sql.Date.valueOf("1980-12-31")).get(0));
	}

	/**
	 * Metodo test para
	 * {@link com.breakdark.certificados_parroquia_vc.model.Bautismo.BautismoService#obtenerBautismoDeId()}.
	 * Probamos que se puede obtener un bautismo segun su id
	 */
	@Test
	public void testObtenerBautismoDeId() {
		// datos de prueba
		bautismo1.setLibro("Libro 1");
		bautismo1.setPartida(123);
		bautismo1.setApellido_paterno("PEREZ");
		bautismo1.setApellido_materno("POMA");
		bautismo1.setNombres("JUAN JOSE");
		bautismo1.setFecha_bautismo(java.sql.Date.valueOf("1986-05-23"));
		bautismo1.setFecha_nacimiento(java.sql.Date.valueOf("1980-09-11"));

		Bautismo bautismo_result = bautismoService.adicionarBautismo(bautismo1);

		Assert.assertNotNull("El resultado devolvio null",
				bautismoService.obtenerBautismoDeId(bautismo_result.getId()));
		Assert.assertEquals("El bautismo obtenido es distinto al registrado con el id enviado", bautismo1,
				bautismo_result);

		Assert.assertNull("Deberia obtenerse null con un id negativo", bautismoService.obtenerBautismoDeId(-1));
	}
}
