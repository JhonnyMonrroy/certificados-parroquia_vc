package com.breakdark.certificados_parroquia_vc.model.Bautismo;

import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

class BautismoDAO {

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
	 * Crea un registro de un <code>Bautismo</code> en la base de datos
	 *
	 * @param bautismo
	 *            Objeto bautismo a registrar
	 * @return El id del objeto insertado en la base de datos, <code>null</code> en
	 *         el caso de que exista algun error.
	 */
	public Integer insert(Bautismo bautismo) {
		try {
			int id;
			// parseamos a mayusculas
			bautismo.setLibro(bautismo.getLibro().toUpperCase());
			bautismo.setApellido_paterno(bautismo.getApellido_paterno().toUpperCase());
			bautismo.setApellido_materno(bautismo.getApellido_materno().toUpperCase());
			bautismo.setNombres(bautismo.getNombres().toUpperCase());

			Session session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			id = (Integer) session.save(bautismo);
			// Bautismo bautismo_result = (Bautismo) session.save(bautismo);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene un listado de todos los objetos <code>Bautismo</code> registrados en
	 * la base de datos.
	 *
	 * @return En listado de objetos <code>Bautismo</code>
	 */
	public List<Bautismo> selectAll() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Bautismo.class);
		@SuppressWarnings("unchecked")
		List<Bautismo> bautismos = (List<Bautismo>) criteria.list();
		session.getTransaction().commit();
		return bautismos;
	}

	/**
	 * Obtiene un bautismo a partir de su id
	 *
	 * @param id_bautismo
	 * @return Un objeto <code>Bautismo</code>, <code>null</code> si es que no
	 *         existe
	 */
	public Bautismo findById(Integer id_bautismo) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Bautismo.class).add(Restrictions.idEq(id_bautismo));
		Bautismo bautismo = (Bautismo) criteria.uniqueResult();
		session.getTransaction().commit();
		return bautismo;
	}

	/**
	 * Elimina un registro Bautismo de la base de datos
	 *
	 * @param id_bautismo
	 */
	public void deleteById(Integer id_bautismo) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Bautismo bautismo = (Bautismo) session.createCriteria(Bautismo.class).add(Restrictions.idEq(id_bautismo))
				.uniqueResult();
		session.delete(bautismo);
		session.getTransaction().commit();
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
	public List<Bautismo> findAll(String libro, Integer partida, String indicio_nombre, String tipo_fecha,
			Date fecha_desde, Date fecha_hasta) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Bautismo.class);
		if (libro != null) {
			// criteria.add(Restrictions.eq("libro", libro.toUpperCase()));
			criteria.add(Restrictions.like("libro", "%" + libro + "%"));
		}
		if (partida != null) {
			// criteria.add(Restrictions.eq("partida", partida));
			// criteria.add(Restrictions.like("partida", partida + "%"));
			criteria.add(Restrictions.sqlRestriction("(partida) like '" + partida + "%'"));
		}
		if (indicio_nombre != null) {
			// en sqlite la concatenacion es con ||
			// criteria.createAlias("(apellido_paterno||' '||apellido_materno||'
			// '||nombres", "nombre_completo)");
			// criteria.add(Restrictions.like("nombre_completo", "%" +
			// indicio_nombre.toUpperCase() + "%"));
			criteria.add(Restrictions.sqlRestriction("(apellido_paterno||' '||apellido_materno||' '||nombres) like '%"
					+ indicio_nombre.toUpperCase() + "%'"));
		}
		if (fecha_desde != null && fecha_hasta != null) {
			criteria.add(Restrictions.between(tipo_fecha.equals("bautismo") ? "fecha_bautismo" : "fecha_nacimiento",
					fecha_desde, fecha_hasta));
		}
		criteria.addOrder(Order.asc("apellido_paterno"));
		@SuppressWarnings("unchecked")
		List<Bautismo> bautismos = (List<Bautismo>) criteria.list();
		session.getTransaction().commit();
		return bautismos;
	}

	/**
	 * Actualiza el bautismo segun el id enviado
	 *
	 * @param bautismo
	 *            Bautismo a actualizar
	 * @return Un objeto Bautismo, <code>null</code> en el caso de que ocurriese
	 *         algun error
	 */
	public Bautismo save(Bautismo bautismo) {
		try {
			// parseamos a mayusculas
			bautismo.setApellido_paterno(bautismo.getApellido_paterno().toUpperCase());
			bautismo.setApellido_materno(bautismo.getApellido_materno().toUpperCase());
			bautismo.setNombres(bautismo.getNombres().toUpperCase());

			Session session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.update(bautismo);
			// Bautismo bautismo_result = (Bautismo) session.save(bautismo);
			session.getTransaction().commit();
			return bautismo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
