package kelly.org.model;


import java.util.Date;

import kelly.org.exception.PortfolioFullException;
import kelly.org.exception.StockAlreadyExistsException;
import kelly.org.exception.BalanceException;
import kelly.org.exception.StockNotExistException;


public class Portfolio {

	public enum ALGO_RECOMMENDATION{DO_NOTHING,BUY,SELL};
	private static final int MAX_PORTFOLIO_SIZE =5;
	private String title=" Kelly's Portfolio ! ";
	private StockStatus[] stocksStatus;
	private int portfolioSize=0;
	private float balance=0;
	


	public Portfolio(){
		
		stocksStatus=new StockStatus[MAX_PORTFOLIO_SIZE];
	}
		
	/**
	 * My copy constructor
	 * @param Portfolio
	 */
	
	public Portfolio(Portfolio portfolio){
		
		setTitle(portfolio.getTitle());
		portfolioSize=portfolio.portfolioSize;
		setBalance(portfolio.getBalance());

		stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];

				for(int i = 0; i < portfolioSize; i++)
					{
						stocksStatus[i]=new StockStatus(portfolio.stocksStatus[i]);
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

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	/**
	 * adding a new stock to the portfolio.
	 * @param stock
	 */


	public void addStock(Stock stock) throws PortfolioFullException, StockAlreadyExistsException{
		
		for(int i=0;i<portfolioSize;i++){
			if(stock.getSymbol().equals(stocksStatus[i].getSymbol())){
				System.out.println("you already have "+stock.getSymbol()+" stock, please enter another stock symbol.");
				
				break;
			}
		}

		if (portfolioSize >= (MAX_PORTFOLIO_SIZE)){

			System.out.println("can't add new stock,portfolio can only have "+ MAX_PORTFOLIO_SIZE+" stocks!");
			}
		

		else if(portfolioSize< MAX_PORTFOLIO_SIZE){
			
			stocksStatus[portfolioSize] = new StockStatus();
			
						stocksStatus[portfolioSize].setAsk(stock.getAsk());
						stocksStatus[portfolioSize].setBid(stock.getBid());
						stocksStatus[portfolioSize].setSymbol(stock.getSymbol());
						stocksStatus[portfolioSize].setDate(stock.getDate());
     					stocksStatus[portfolioSize].setRecommendation(ALGO_RECOMMENDATION.DO_NOTHING);
						stocksStatus[portfolioSize].setStockQuantity(0);
						portfolioSize++;
			System.out.println("Stock "+stocksStatus[portfolioSize-1].getSymbol()+" added successfuly!");
		}
	}

	public void removeStock (String symbol) throws StockNotExistException{

		if (placeOfStock(symbol)== -2){
			System.out.println("The stock "+symbol+ " doesn't exsit in your portfolio. Please enter a valid stock symbol. ");
		
		}
		
		else if (placeOfStock(symbol)!= -2)
		{
			sellStock(symbol, -1);

			if(placeOfStock(symbol)!= (portfolioSize-1))
			{
				stocksStatus[placeOfStock(symbol)]=stocksStatus[portfolioSize-1];
				stocksStatus[portfolioSize-1]=null;
			}
			
			else if(placeOfStock(symbol)==(portfolioSize-1))
			{
				 
				stocksStatus[portfolioSize-1]=null;
			}
			portfolioSize--;
			System.out.println("Stock " + symbol +" removed successfuly!");
			 
		}
	
	}

	/**
	 * this method sells  stocks.
	 * @return
	 */
	public void sellStock(String symbol, int quantity)
	{
		
		if(placeOfStock(symbol)==-2){
			System.out.println("There is no stock with that name , please enter a valid name. ");
			 
		}
		
		else if(stocksStatus[placeOfStock(symbol)].getStockQuantity()>=quantity&&(quantity!=-1)){
			
			balance=balance+(quantity * stocksStatus[placeOfStock(symbol)].getBid());
			stocksStatus[placeOfStock(symbol)].setStockQuantity(stocksStatus[placeOfStock(symbol)].getStockQuantity()-quantity);
			System.out.println("The stock "+symbol+" sold successfuly");
			
		}
		
		else if(stocksStatus[placeOfStock(symbol)].getStockQuantity()<quantity && placeOfStock(symbol)!=-2 ){
			System.out.println("Not enough stocks to sell ");
			
		}

		else if(quantity==(-1)){
			
			balance=balance+(stocksStatus[placeOfStock(symbol)].getStockQuantity() * stocksStatus[placeOfStock(symbol)].getBid());
			stocksStatus[placeOfStock(symbol)].setStockQuantity(0);
			System.out.println("The stock "+symbol+" sold successfuly(all)");
			
		}
		
		else if(quantity<(-1)){
			System.out.println("this quantity is not legal, please enter a quantity bigger than 0");
		
		}
		
	}

	/**
	 * this method buys stocks.
	 * @return
	 */
	public void buyStock(String symbol,int quantity) throws BalanceException{
	
		if(placeOfStock(symbol)==-2){
			
			System.out.println("There is no stock with that name, please enter valid name. ");
			
		}
		if(quantity<-1){
			
			System.out.println("This quantity is not legal, please enter a quantity bigger than 0");
			
		}

		else if(balance<stocksStatus[placeOfStock(symbol)].getAsk()*quantity){
			
			System.out.println("Not enough balance to complete purchase");
			
		}
		
		else if (balance>=stocksStatus[placeOfStock(symbol)].getAsk()*quantity){

			balance=balance-stocksStatus[placeOfStock(symbol)].getAsk()*quantity;
			stocksStatus[placeOfStock(symbol)].setStockQuantity(stocksStatus[placeOfStock(symbol)].getStockQuantity()+quantity);
			System.out.println("You bought the stock "+symbol+" !");
			
		}
		
		else if(quantity==-1)
		{
			quantity=(int) (balance/stocksStatus[placeOfStock(symbol)].getAsk());
			balance=stocksStatus[placeOfStock(symbol)].getAsk()-quantity;
			stocksStatus[placeOfStock(symbol)].setStockQuantity(stocksStatus[placeOfStock(symbol)].getStockQuantity()+quantity);
			System.out.println("You bought the stock"+symbol+" !");
		
		}

		
	}

	/**
	 * this method returns total value of all stocks.
	 * @return
	 */
	public float getStocksValue(){
		
		float valueOfAllStocks=0;
		
		for (int i=0; i<portfolioSize;i++){
			
			if(stocksStatus[i]!=null){
				
				valueOfAllStocks=(stocksStatus[i].getBid()*stocksStatus[i].getStockQuantity())+valueOfAllStocks;
			}
		}
		return valueOfAllStocks;
	}

	/**
	 *  this method returns value of balance.
	 * @return
	 */
	public float getCurrentBalance(){
		
		return balance;
	}

	/**
	 * this method returns the sum of all stocks's value and portfolio balance.
	 * @return
	 */
	public float getTotalValue(){
		
		float totalValue;
		totalValue=getStocksValue()+getCurrentBalance();
		return totalValue;
		
	}


	/**
	 * this method checks if there is a stock in our portfolio and where.
	 * @param symbol
	 * @return
	 */
	public int placeOfStock(String symbol){
		
		int index=-2;
		
		for(int i=0;i<portfolioSize;i++){
			
			if(stocksStatus[i]!=null){
				
				if (stocksStatus[i].getSymbol().equals(symbol)){ 
			
				index=i;
				break;
				}
			}
		}
		return index;
	}


	public  Stock[] getStocks(){
		
		return stocksStatus;
	}

	/**
	 * the method returns in html: 
	 * in bold: the title of the stock
	 * in bold: stock symbol
	 * not in bold - the value of the Stock
	 * with spaces
	 * Kelly Bismuth. December 2014
	 * @return
	 */
	public String getHtmlString(){
		
		String retVal = new String();
		retVal += "<h1>"+title+"</h1>";
		
		for (int i = 0; i < portfolioSize; i++) {
			
			retVal += stocksStatus[i].getHtmlDescription();
		}
		
		retVal+="<b>Total Portfolio Value: </b>"+getTotalValue()+"$, "+"<b>Total Stocks Value: </b>"+ getStocksValue()+"$, "+"<b>Balance: </b>"+getCurrentBalance()+"$. "; 
		return retVal;
	}

	/**
	 * this method updates the balance.
	 * @param amount
	 * @return
	 */
	
	public float updateBalance(float amount){
		
		if(amount>0){
			
			balance= balance+amount;
		}
		
		else if (balance+amount<0){
			
			balance=0;
		}
		
		else if(amount==0){
			
			System.out.println("The value of the balance has not changed!");
		}

		return balance; 
	}


}