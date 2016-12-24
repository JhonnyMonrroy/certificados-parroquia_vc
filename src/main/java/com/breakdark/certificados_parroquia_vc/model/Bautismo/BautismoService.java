/**
 * 
 */
package com.breakdark.certificados_parroquia_vc.model.Bautismo;

import java.util.List;

/**
 * @author BreakDark
 * @version 1.0
 */
public class BautismoService {
	private BautismoDAO bautismoDAO;

	public void adicionarBautismo(Bautismo bautismo) {
		this.getBautismoDAO().insert(bautismo);
	}

	public List<Bautismo> obtenerTodosLosBautismos() {
		return this.getBautismoDAO().selectAll();
	}

	// METODOS GET Y SET
	/**
	 * @return El bautismoDAO
	 */
	public BautismoDAO getBautismoDAO() {
		return bautismoDAO;
	}

	/**
	 * @param bautismoDAO
	 *            El bautismoDAO a asignar
	 */
	public void setBautismoDAO(BautismoDAO bautismoDAO) {
		this.bautismoDAO = bautismoDAO;
	}
}
