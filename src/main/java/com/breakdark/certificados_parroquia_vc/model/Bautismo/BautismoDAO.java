package com.breakdark.certificados_parroquia_vc.model.Bautismo;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	 */
	public void insert(Bautismo bautismo) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(bautismo);
		session.getTransaction().commit();
	}

	/**
	 * Obtiene un listado de todos los objetos <code>Bautismo</code> registrados
	 * en la base de datos.
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

	// /**
	// * Este es el metodo que se utiliza para inicializar la conecci&oacute;n a
	// * la base de datos
	// *
	// * @param ds
	// * Confiuración de la base de datos
	// */
	// public void setDataSource(DataSource ds);
	//
	// /**
	// * Crea un registro de un <code>Bautismo</code> en la base de datos
	// *
	// * @param bautismo
	// * Objeto bautismo a registrar
	// */
	// public void create(Bautismo bautismo);
	//
	// /**
	// * Obtiene un objeto <code>Bautismo</code> de la base de datos a partir de
	// * su id.
	// *
	// * @param id
	// * El identificador del Bautismo a obtener
	// * @return Un objeto <code>Bautismo</code> con la información ya
	// registrada,
	// * <code>null</code> en el caso de que no exista.
	// */
	// public Bautismo getBautismo(Integer id);
	//
	// /**
	// * Obtiene un listado de todos los objetos <code>Bautismo</code>
	// registrados
	// * en la base de datos.
	// *
	// * @return En listado de objetos <code>Bautismo</code>
	// */
	// public List<Bautismo> listBautismos();
	//
	// /**
	// * Elimina un registro <code>Bautismo</code> de la base de datos.
	// *
	// * @param id
	// * El identificador del Bautismo a obtener
	// */
	// public void delete(Integer id);
	//
	// /**
	// * Actualiza la informaci&oacute; de un objeto <code>Bautismo</code>.
	// *
	// * @param bautismo
	// * Objeto <code>Bautismo</code> a actualizar.
	// * @return Un objeto <code>Bautismo</code> con la información actualizada,
	// * <code>null</code> en el caso de que ocurra algun error.
	// */
	// public Bautismo update(Bautismo bautismo);
}
