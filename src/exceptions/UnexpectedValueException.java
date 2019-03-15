package exceptions;

public class UnexpectedValueException extends Exception {

	public UnexpectedValueException(int value1, int value2) {
		super("El valor ("+value1+") no correspon al valor esperat ("+ value2+")");
	}

	public UnexpectedValueException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
