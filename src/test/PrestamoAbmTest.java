package test;

import java.util.Set;

import modelo.Prestamo;
import modelo.excepciones.EntidadNoEncontradaException;
import negocio.PrestamoAbm;

public class PrestamoAbmTest {

	private static final PrestamoAbm prestamoAbm = new PrestamoAbm();

	public static void main(String[] args) {

		int idCliente = 2;
		Set<Prestamo> prestamos = null;
		try {
			prestamos = prestamoAbm.traerPorCliente(idCliente);
			System.out.printf("\nPrestamos de cliente con id %d: %s", idCliente, prestamos);
		} catch (EntidadNoEncontradaException e) {
			e.printStackTrace();
		}
	}
}
