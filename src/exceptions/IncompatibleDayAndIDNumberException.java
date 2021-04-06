package exceptions;

public class IncompatibleDayAndIDNumberException extends Exception{
	public IncompatibleDayAndIDNumberException() {
		super("Due to the day, this person cannot enter because his identification number is not valid");
	}
}
