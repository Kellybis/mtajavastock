package kelly.org;

public class Stock {
	
	private String symbol;
	private float Ask;
	private float  Bid;
	private java.util.Date date;
	
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
	
	public String getHtmlDescription(){
		String res = " <b>Symbol</b> :" + getSymbol() + " <b>Ask </b>: "+ getAsk() + "<b> Bid </b> : "+ getBid() + " <b>Date</b> : " +getDate()+"<br>";
		return res;
		
		
		
	}

}
