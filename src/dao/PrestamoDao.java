package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import dao.util.BaseDao;
import modelo.Cliente;
import modelo.Prestamo;

public class PrestamoDao extends BaseDao<Prestamo> {

	public Prestamo traerSinCliente(long idObjeto) {
		Prestamo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Prestamo) session.get(Prestamo.class, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}

	// IMPOTANTE el armado del HQL
	public Prestamo traer(long idPrestamo) {
		Prestamo obj = null;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where p.idPrestamo=:idPrestamo";
			obj = (Prestamo) session.createQuery(hQL).setParameter("idPrestamo", idPrestamo).uniqueResult();
			Hibernate.initialize(obj.getCuotas());
		} finally {
			session.close();
		}
		return obj;
	}

	//IMPOTANTE el armado del HQL
	public List<Prestamo> traer(Cliente c) {
		List<Prestamo> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo p inner join fetch p.cliente c where c.idCliente=:idCliente";
			lista = session.createQuery(hQL, Prestamo.class).setParameter("idCliente", c.getIdCliente())
					.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public void actualizar(Prestamo objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

}
