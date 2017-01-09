/**
 * 
 */
package com.breakdark.certificados_parroquia_vc.model.Bautismo;

import java.util.Date;
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

	/**
	 * Busca bautismos segun los parametros enviados
	 * 
	 * @param libro
	 *            Número del libro de registro del bautismo
	 * @param partida
	 *            Número de partida del bautismo
	 * @param indicio_nombre
	 *            Indicio o parte del Nombre del bautizado
	 * @param tipo_fecha
	 *            tipo de fecha a buscar (<code>"bautismo"</code> o
	 *            <code>"nacimiento"</code>)
	 * @param fecha_desde
	 *            Fecha de inicio de la busqueda
	 * @param fecha_hasta
	 *            Fecha de finalización de la busqueda
	 * @return Una lista de objetos <code>Bautismo</code>, <code>null</code> si
	 *         existe algun error
	 */
	public List<Bautismo> buscarBautismos(String libro, Integer partida, String indicio_nombre, String tipo_fecha,
			Date fecha_desde, Date fecha_hasta) {
		return this.getBautismoDAO().findAll(libro, partida, indicio_nombre, tipo_fecha, fecha_desde, fecha_hasta);
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

	/**
	 * @param id Identificador del bautismo
	 * @return Un objeto <code>Bautismo</code>, <code>null</code> en el caso de que no exista
	 */
	public Bautismo obtenerBautismoDeId(Integer id) {
		return this.getBautismoDAO().findById(id);
	}

}
