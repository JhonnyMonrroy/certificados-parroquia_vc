/**
 * 
 */
package com.breakdark.certificados_parroquia_vc.model.Bautismo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author BreakDark
 *
 */
public class BautismoTest {
	private static Bautismo bautismo;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bautismo = new Bautismo();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.breakdark.certificados_parroquia_vc.model.Bautismo.Bautismo#getNombreCompleto()}.
	 */
	@Test
	public void testGetNombreCompleto() {
		bautismo.setApellido_paterno("Perez");
		bautismo.setApellido_materno("Ramirez");
		bautismo.setNombres("Ines Andrea");
		Assert.assertEquals("Las Cadenas son distintas", "Perez Ramirez Ines Andrea", bautismo.getNombreCompleto());
		bautismo.setApellido_paterno("Perez");
		bautismo.setApellido_materno(null);
		bautismo.setNombres("Ines Andrea");
		Assert.assertEquals("Las Cadenas son distintas", "Perez Ines Andrea", bautismo.getNombreCompleto());
		bautismo.setApellido_paterno(null);
		bautismo.setApellido_materno("Ramirez");
		bautismo.setNombres("Ines Andrea");
		Assert.assertEquals("Las Cadenas son distintas", "Ramirez Ines Andrea", bautismo.getNombreCompleto());
		bautismo.setApellido_paterno("Perez");
		bautismo.setApellido_materno("Ramirez");
		bautismo.setNombres("Andrea");
		Assert.assertEquals("Las Cadenas son distintas", "Perez Ramirez Andrea", bautismo.getNombreCompleto());
		bautismo.setApellido_paterno("Perez");
		bautismo.setApellido_materno(null);
		bautismo.setNombres("Ines");
		Assert.assertEquals("Las Cadenas son distintas", "Perez Ines", bautismo.getNombreCompleto());
		bautismo.setApellido_paterno(null);
		bautismo.setApellido_materno("Rojas");
		bautismo.setNombres("Ines");
		Assert.assertEquals("Las Cadenas son distintas", "Rojas Ines", bautismo.getNombreCompleto());
	}

}
