package kelly.org.exception;

public class IllegalQuantityException extends Exception {

	private static final long serialVersionUID = 1L;

	public IllegalQuantityException() {
		super("Quantity must be positive!");
	}

	public IllegalQuantityException(String message) {
		super(message);
	}
}
