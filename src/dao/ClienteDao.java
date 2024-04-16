package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.query.Query;

import dao.util.BaseDao;
import modelo.Cliente;

public class ClienteDao extends BaseDao<Cliente> {

	public Cliente traer(long idCliente) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente);
			Hibernate.initialize(objeto.getPrestamos());
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Cliente traer(int dni) {
		Cliente cliente = null;
		try {
			iniciaOperacion();
			cliente = (Cliente) session.createQuery("from Cliente c where c.dni"
					+ "= :dni").setParameter("dni", dni)
					.uniqueResult();
			Hibernate.initialize(cliente.getPrestamos());
		} finally {
			session.close();
		}
		return cliente;
	}
	
	public List<Cliente> traer() {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			iniciaOperacion();
			Query<Cliente> query = session.createQuery("from Cliente c order by "
					+ "c.apellido asc, c.nombre asc", Cliente.class);
					lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public Cliente traerClienteYPrestamos(long idCliente) {
		Cliente objeto = null;	
		try {
			iniciaOperacion();
			String hql = "from Cliente c where c.idCliente=:idCliente";
			objeto = (Cliente) session.createQuery(hql).setParameter("idCliente", idCliente).uniqueResult();
			Hibernate.initialize(objeto.getPrestamos());
		} finally {
			session.close();
		}
		return objeto;
	}
}
