package kelly.org.exception;

/**
 * exception to be thrown when a stock doesn’t exist.

 * @author Kelly
 *
 */
public class StockNotExistException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public StockNotExistException(String symbol) {
		super("Stock " + symbol + " doesn't exist !");
	}

}
