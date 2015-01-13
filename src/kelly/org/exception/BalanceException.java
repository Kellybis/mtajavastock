package kelly.org.exception;

/**
 * Exception to be thrown when the portfolio balance becomes
negative
 * @author Kelly
 *
 */
public class BalanceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BalanceException() {
		
		super(" Negative balance " );
	}
		  
}
