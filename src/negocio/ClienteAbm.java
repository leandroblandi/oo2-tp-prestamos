package negocio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import dao.ClienteDao;
import modelo.Cliente;
import modelo.excepciones.DocumentoInvalidoException;
import modelo.excepciones.EntidadExistenteException;
import modelo.excepciones.EntidadNoEncontradaException;

/**
 * @author lblandi
 */
public class ClienteAbm {

	private ClienteDao clienteDao;

	public ClienteAbm() {
		this.clienteDao = new ClienteDao();
	}

	public List<Cliente> traer() {
		return clienteDao.traer();
	}

	public Cliente traer(long id) throws EntidadNoEncontradaException {
		Cliente cliente = clienteDao.traer(id);

		if (cliente == null) {
			throw new EntidadNoEncontradaException(id);
		}
		
		return cliente;
	}

	public Cliente traer(int dni) throws EntidadNoEncontradaException {
		Cliente cliente = clienteDao.traer(dni);

		if (cliente == null) {
			throw new EntidadNoEncontradaException(dni);
		}

		return cliente;
	}

	public int crear(String apellido, String nombre, int dni, LocalDate fechaNacimiento)
			throws EntidadExistenteException {
		Cliente clienteDb = clienteDao.traer(dni);
		
		if (clienteDb != null) {
			throw new EntidadExistenteException(dni);
		}
		
		Cliente cliente = Cliente.builder().apellido(apellido).nombre(nombre).dni(dni)
				.fechaDeNacimiento(fechaNacimiento).baja(false).prestamos(new HashSet<>()).build();
		return clienteDao.agregar(cliente);
	}

	public void modificar(Cliente obj) throws EntidadNoEncontradaException, DocumentoInvalidoException {

		Cliente clienteDb = traer(obj.getDni());

		if (clienteDb != null && !obj.equals(clienteDb)) {
			throw new DocumentoInvalidoException(clienteDb.getIdCliente());
		}

		clienteDao.actualizar(clienteDb);
	}

	public void eliminar(long id) throws EntidadNoEncontradaException {
		Cliente cliente = traer(id);
		clienteDao.eliminar(cliente);
	}
}
