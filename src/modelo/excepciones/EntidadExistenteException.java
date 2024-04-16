package modelo.excepciones;

public class EntidadExistenteException extends Exception {

	private static final long serialVersionUID = 5206004531106220953L;

	public EntidadExistenteException(long id) {
		super(String.format("La entidad con id %d ya existe", id));
	}

	public EntidadExistenteException(int dni) {
		super(String.format("La entidad con dni %d ya existe", dni));
	}
}
