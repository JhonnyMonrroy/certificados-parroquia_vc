package com.breakdark.certificados_parroquia_vc.model.Configuracion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * ConfiguracionDAO.java
 * 
 * @author BreakDark (Jhonny Monrroy)
 * @version 1.0 22 abr. 2017
 */
class ConfiguracionDAO {
	private SessionFactory sessionFactory;

	/**
	 * @return El sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            El sessionFactory a asignar
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Crea un registro de una <code>Configuracion</code> en la base de datos
	 * 
	 * @param configuracion
	 *            Objeto configuracion a registrar
	 * @return El id del objeto insertado en la base de datos, <code>null</code>
	 *         en el caso de que exista algun error.
	 */
	public Integer insert(Configuracion configuracion) {
		try {
			int id;
			Session session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			id = (Integer) session.save(configuracion);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene un listado de todos los objetos <code>Configuracion</code>
	 * registrados en la base de datos.
	 *
	 * @return En listado de objetos <code>Configuracion</code>
	 */
	public List<Configuracion> selectAll() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Configuracion.class);
		@SuppressWarnings("unchecked")
		List<Configuracion> configuraciones = (List<Configuracion>) criteria.list();
		session.getTransaction().commit();
		return configuraciones;
	}

	/**
	 * Obtiene una configuracion a partir de su id
	 * 
	 * @param id_configuracion
	 * @return Un objeto <code>Configuracion</code>, <code>null</code> si es que
	 *         no existe
	 */
	public Configuracion findById(Integer id_configuracion) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Configuracion.class).add(Restrictions.idEq(id_configuracion));
		Configuracion configuracion = (Configuracion) criteria.uniqueResult();
		session.getTransaction().commit();
		return configuracion;
	}

	/**
	 * Elimina un registro Configuracion de la base de datos
	 * 
	 * @param id_configuracion
	 */
	public void deleteById(Integer id_configuracion) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Configuracion configuracion = (Configuracion) session.createCriteria(Configuracion.class)
				.add(Restrictions.idEq(id_configuracion)).uniqueResult();
		session.delete(configuracion);
		session.getTransaction().commit();
	}

	/**
	 * Obtiene la ultima configuracion que este oficial
	 * 
	 * @return Un objeto <code>Configuracion</code>, <code>null</code> si es que
	 *         no existe
	 */
	public Configuracion findOficial() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Configuracion.class).add(Restrictions.eq("oficial", true));
		Configuracion configuracion = (Configuracion) criteria.addOrder(Order.desc("fecha")).setMaxResults(1)
				.uniqueResult();
		session.getTransaction().commit();
		return configuracion;
	}

}
