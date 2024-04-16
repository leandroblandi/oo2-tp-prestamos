package test;

import modelo.Cliente;
import modelo.excepciones.EntidadNoEncontradaException;
import negocio.ClienteAbm;

public class ClienteAbmTest {

	private static final ClienteAbm clienteAbm = new ClienteAbm();

	public static void main(String[] args) {

		Cliente cliente = null;
		try {
			cliente = clienteAbm.traer(44098528);
			System.out.printf("\nCliente %s", cliente);
		} catch (EntidadNoEncontradaException e) {
			e.printStackTrace();
		}
	}
}
