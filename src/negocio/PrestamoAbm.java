package negocio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import dao.PrestamoDao;
import modelo.Cliente;
import modelo.Prestamo;
import modelo.excepciones.EntidadExistenteException;
import modelo.excepciones.EntidadNoEncontradaException;

/**
 * @author lblandi
 */
public class PrestamoAbm {

	private PrestamoDao prestamoDao;
	private ClienteAbm clienteAbm;

	public PrestamoAbm() {
		this.prestamoDao = new PrestamoDao();
		this.clienteAbm = new ClienteAbm();
	}

	public Set<Prestamo> traerPorCliente(long id) throws EntidadNoEncontradaException {
		Cliente clienteDb = clienteAbm.traer(id);
		return clienteDb.getPrestamos();
	}

	public Prestamo traer(long id) throws EntidadNoEncontradaException {
		Prestamo prestamo = prestamoDao.traer(id);

		if (prestamo == null) {
			throw new EntidadNoEncontradaException(id);
		}

		return prestamo;
	}

	public Prestamo traerSinCliente(long id) {
		return prestamoDao.traerSinCliente(id);
	}

	public int crear(double monto, double interes, int cantidadCuotas, LocalDate fecha, Cliente cliente)
			throws EntidadExistenteException, EntidadNoEncontradaException {
		// TODO: Realizar lógica de negocio
		Prestamo prestamo = Prestamo.builder()
				.monto(monto)
				.interes(interes)
				.cantidadCuotas(cantidadCuotas)
				.fecha(fecha)
				.cliente(cliente)
				.cuotas(new HashSet<>())
				.cancelado(false)
				.build();
		return prestamoDao.agregar(prestamo);
	}

	public void modificar(Prestamo obj) throws EntidadNoEncontradaException, Exception {
		Prestamo prestamoDb = prestamoDao.traer(obj.getIdPrestamo());

		if (prestamoDb == null) {
			throw new EntidadNoEncontradaException(obj.getIdPrestamo());
		}

		prestamoDao.actualizar(obj);
	}
}
