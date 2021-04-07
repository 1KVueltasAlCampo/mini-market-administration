package exceptions;

public class InvalidIDTypeException extends Exception{
	public InvalidIDTypeException() {
		super("The type of identification entered is not valid");
	}
}
