package modelo.excepciones;

public class DocumentoInvalidoException extends Exception {

	private static final long serialVersionUID = 6311922213595282490L;

	public DocumentoInvalidoException(long id) {
		super(String.format("El documento ingresado es invalido: pertenece a la persona con id %d", id));
	}
}
