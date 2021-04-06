package exceptions;

public class InvalidIDTypeException extends Exception{
	public InvalidIDTypeException() {
		super("El tipo de identificacion ingresado no es valido");
	}
}
