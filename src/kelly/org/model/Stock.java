package kelly.org.model;

/**
 * defining the stock parameters
 * @author Kelly
 *
 */

public class Stock {
	
	private String symbol;
	private float Ask;
	private float  Bid;
	private java.util.Date date;
	
	/**C'tor*/
	public Stock(Stock stock){
		
		setSymbol(stock.getSymbol());
		setAsk(stock.getAsk());
		setBid(stock.getBid());
		setDate(stock.getDate());
	}
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public float getAsk() {
		return Ask;
	}
	
	public void setAsk(float ask) {
		Ask = ask;
	}
	
	public float getBid() {
		return Bid;
	}
	
	public void setBid(float bid) {
		Bid = bid;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	/**
	 * the method returns in html
	 * in bold : the stock's title and symbol
	 * not in bold : the value of the stock
	 * with spaces 
	 * Kelly Bismuth . December 2014
	 * @return
	 */
	public String getHtmlDescription(){
		String res = " <b>Symbol</b> :" + getSymbol() + " <b>Ask </b>: "+ getAsk() + "<b> Bid </b> : "+ getBid() + " <b>Date</b> : " +getDate()+"<br>";
		return res;
		
		
		
	}

}
