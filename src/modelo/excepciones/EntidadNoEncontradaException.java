package modelo.excepciones;

public class EntidadNoEncontradaException extends Exception {

	private static final long serialVersionUID = 4943858642900358400L;

	public EntidadNoEncontradaException(long id) {
		super(String.format("La entidad con id %d no existe", id));
	}

	public EntidadNoEncontradaException(int dni) {
		super(String.format("La entidad con dni %d no existe", dni));
	}

}
