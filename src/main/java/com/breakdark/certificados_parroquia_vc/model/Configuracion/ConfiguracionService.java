package com.breakdark.certificados_parroquia_vc.model.Configuracion;

import java.util.List;

/**
 * ConfiguracionService.java
 * 
 * @author BreakDark (Jhonny Monrroy)
 * @version 1.0 23 abr. 2017
 */
public class ConfiguracionService {
	private ConfiguracionDAO configuracionDAO;

	/**
	 * Adiciona una Configuracion en la Base de Datos
	 * 
	 * @param configuracion
	 *            El objeto <code>Configuracion</code> a adicionar en la base de
	 *            datos.
	 * @return El objeto <code>Configuracion</code> con su id asignado en la
	 *         base de datos, <code>null</code> en el caso de que exista algun
	 *         error.
	 */
	public Configuracion adicionarConfiguracion(Configuracion configuracion) {
		Integer id_configuracion = this.configuracionDAO.insert(configuracion);
		if (id_configuracion != null) {
			Configuracion configuracion_result = this.configuracionDAO.findById(id_configuracion);
			return configuracion_result;
		}
		return null;
	}

	/**
	 * Obtiene la lista de todos las configuraciones registrados
	 * 
	 * @return Una lista de objetos <code>configuracion</code>,
	 *         <code>null</code> si existe algun error
	 */
	public List<Configuracion> obtenerTodasLasConfiguraciones() {
		return this.configuracionDAO.selectAll();
	}

	/**
	 * @param id
	 *            Identificador de la configuracion
	 * @return Un objeto <code>configuracion</code>, <code>null</code> en el
	 *         caso de que no exista
	 */
	public Configuracion obtenerConfiguracionDeId(Integer id) {
		return this.configuracionDAO.findById(id);
	}

	/**
	 * Obtiene la configuracion oficial
	 * 
	 * @return Un objeto <code>configuracion</code>, <code>null</code> en el
	 *         caso de que no exista
	 */
	public Configuracion obtenerConfiguracionOficial() {
		return this.configuracionDAO.findOficial();
	}

	/**
	 * Elimina la configuracion de Id
	 * 
	 * @param id
	 *            Identificador de la configuracion
	 * @return <code>true</code> si se elimino correctamente, <code>false</code>
	 *         en caso de que existiese algun error
	 */
	public boolean eliminarConfiguracionDeId(Integer id) {
		this.getConfiguracionDAO().deleteById(id);
		return this.getConfiguracionDAO().findById(id) == null;
	}

	/**
	 * @return El configuracionDAO
	 */
	public ConfiguracionDAO getConfiguracionDAO() {
		return configuracionDAO;
	}

	/**
	 * @param configuracionDAO
	 *            El configuracionDAO a asignar
	 */
	public void setConfiguracionDAO(ConfiguracionDAO configuracionDAO) {
		this.configuracionDAO = configuracionDAO;
	}
}
