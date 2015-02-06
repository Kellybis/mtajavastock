package kelly.org.exception;

/**
 * exception to be thrown when a stock already exists
 * 
 * @author Kelly
 *
 */
public class StockAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public StockAlreadyExistsException(String symbol) {
		super("Stock " + symbol + " already exists!");
	}

}
