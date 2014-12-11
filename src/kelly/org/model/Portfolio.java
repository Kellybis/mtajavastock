package kelly.org.model;

import java.util.Date;

public class Portfolio {
	
	public static final int MAX_PORTFOLIO_SIZE = 5 ;
	
	private String title = "Show Portfolio";
	private Stock[] stocks;
	private StockStatus[] stocksStatus;
	private int portfolioSize = 0;
	
	/**
	 * Copy c'tor
	 * @param portfolio
	 */
	
	public Portfolio (Portfolio portfolio){
		
		portfolioSize = portfolio.portfolioSize;
		setTitle(portfolio.getTitle());
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		for(int i = 0; i < 3; i++)
		{
			stocks[i] = new Stock(portfolio.stocks[i]);
		}
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StockStatus[] getStocksStatus() {
		return stocksStatus;
	}

	public void setStocksStatus(StockStatus[] stocksStatus) {
		this.stocksStatus = stocksStatus;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	public Portfolio(){
		
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	}
	
	/**
	 * adding a new stock to the portfolio
	 * @param stock
	 */
	public void addStock(Stock stock){
		
		stocks[portfolioSize] = stock;
		portfolioSize++;
	}
	
	public Stock[] getStocks(){
		
		return stocks;
	}
	/**
	 * the method returns in html
	 * in bold : the stock's title and symbol
	 * not in bold : the value of the stock
	 * with spaces 
	 * Kelly Bismuth . December 2014
	 * @return
	 */
	public  String getHtmlString(){
		
		String str = new String();
		str+= "<h1>"+title+"</h1>";
		
		for(int i = 0; i<portfolioSize; i++){
			
			str+= stocks[i].getHtmlDescription();
		}
		return str;
		
	}
	
	/**
	 *  inner class:
	 * @author Kelly
	 *
	 */
	public class StockStatus{
		
		public static final int DO_NOTHING = 0;
		public static final int BUY = 1 ;
		public static final int SELL = 2 ;
		
		private String symbol;
		private float currentBid , currentAsk;
		private Date date ;
		private int recommendation;
		private int stockQuantity;
		
		/**
		 * copy c'tor
		 * @param stockStatus
		 */
        public StockStatus(StockStatus stockStatus){
           
        	setSymbol(stockStatus.getSymbol());
        	setCurrentBid(stockStatus.getCurrentBid());
        	setCurrentAsk(stockStatus.getCurrentAsk());
        	setDate(stockStatus.getDate());
        	setRecommendation(stockStatus.getRecommendation());
        	setStockQuantity(stockStatus.getStockQuantity());
			
		}
		
		public String getSymbol() {
			return symbol;
		}
		
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		
		public float getCurrentBid() {
			return currentBid;
		}
		
		public void setCurrentBid(float currentBid) {
			this.currentBid = currentBid;
		}
		
		public float getCurrentAsk() {
			return currentAsk;
		}
		
		public void setCurrentAsk(float currentAsk) {
			this.currentAsk = currentAsk;
		}
		
		public Date getDate() {
			return date;
		}
		
		public void setDate(Date date) {
			this.date = date;
		}
		
		public int getRecommendation() {
			return recommendation;
		}
		
		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
		}
		
		public int getStockQuantity() {
			return stockQuantity;
		}
		
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
		
		
		
		
	}

}
