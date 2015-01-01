package kelly.org.model;
import java.sql.Date;

/**
 * defining the stock parameters
 * @author Kelly, Ddecember 2014
 *
 */

public class Stock {
	
	private String symbol;
	private float ask;
	private float  bid;
	private java.util.Date date;
	
	
	public String getSymbol() {
 		return symbol;
 	}
 	public void setSymbol(String symbol) {
 		this.symbol = symbol;
 	}
 	public float getAsk() {
 		return ask;
 	}
 	public void setAsk(float ask) {
 		this.ask = ask;
 	}
 	public float getBid() {
 		return bid;
 	}
 	public void setBid(float bid) {
 		this.bid = bid;
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
	public Stock(Stock stock){
 		setSymbol(stock.getSymbol());
 		setAsk(stock.getAsk());
 		setBid(stock.getBid());
 		date=new Date (stock.date.getTime());
 		
 	}
 	public Stock() {
 		// TODO Auto-generated constructor stub
 	}
 }


