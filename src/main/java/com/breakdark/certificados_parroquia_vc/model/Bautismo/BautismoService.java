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

	/**
	 * Adiciona un Bautismo en la Base de Datos
	 * 
	 * @param bautismo
	 *            El objeto <code>Bautismo</code> a adicionar en la base de
	 *            datos.
	 * @return El objeto <code>Bautismo</code> con su id asignado en la base de
	 *         datos, <code>null</code> en el caso de que exista algun error.
	 */
	public Bautismo adicionarBautismo(Bautismo bautismo) {
		Integer id_bautismo = this.getBautismoDAO().insert(bautismo);
		if (id_bautismo != null) {
			Bautismo bautismo_result = this.getBautismoDAO().findById(id_bautismo);
			return bautismo_result;
		}
		return null;
	}

	/**
	 * Obtiene la lista de todos los bautismos registrados
	 * 
	 * @return Una lista de objetos <code>Bautismo</code>, <code>null</code> si
	 *         existe algun error
	 */
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
