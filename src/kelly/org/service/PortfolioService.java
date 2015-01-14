package kelly.org.service;

import java.util.Calendar;
import java.util.Date;

import kelly.org.model.*;
import kelly.org.servlet.*;
import kelly.org.model.Portfolio;
import kelly.org.exception.*;

public class PortfolioService {

	public Portfolio getPortfolio() throws StockAlreadyExistsException, PortfolioFullException , BalanceException , StockNotExistException {
		
		Portfolio myPortfolio = new Portfolio();
		myPortfolio.setTitle("Exercise 9 ");
		myPortfolio.updateBalance(10000);
		
		//1
		Stock Stock1=new Stock();
		Stock1.setSymbol("PIH");
		Stock1.setAsk(10f);
		Stock1.setBid(8.5f);
		
		Calendar c =Calendar.getInstance();
		c.set(2014, 11, 15, 0, 0,0);
		Date date=c.getTime();
	    Stock1.setDate(date);
		myPortfolio.addStock(Stock1);
		
		//2
		Stock Stock2=new Stock();
		Stock2.setSymbol("AAL");
		Stock2.setAsk(30f);
		Stock2.setBid(25.5f);

		Calendar d =Calendar.getInstance();
		d.set(2014, 11, 15, 0, 0,0);
		Date date2=d.getTime();
		Stock2.setDate(date2);
		myPortfolio.addStock(Stock2);
		
		//3
		Stock Stock3=new Stock();
		Stock3.setSymbol("CAAS");
		Stock3.setAsk(20f);
		Stock3.setBid(15.5f);

		Calendar e =Calendar.getInstance();
		e.set(2014, 11, 15, 0, 0,0);;
		Date date3=c.getTime();
		Stock3.setDate(date3);
		myPortfolio.addStock(Stock3);
		
		/*
		 I add this stocks (4,5,6) to check the exceptions
		 */
		
		//4
			    Stock Stock4=new Stock();
				Stock4.setSymbol("SHIRAN");
				Stock4.setAsk(30f);
				Stock4.setBid(25.5f);

				Calendar d1 =Calendar.getInstance();
				d1.set(2014, 11, 15, 0, 0,0);
				Date date21=d1.getTime();
				Stock2.setDate(date21);
				myPortfolio.addStock(Stock4);
		
				myPortfolio.buyStock("PIH", 20);
				myPortfolio.buyStock("AAL", 30);
				myPortfolio.buyStock("CAAS", 40);
				
		//5
			    Stock Stock5=new Stock();
				Stock5.setSymbol("KELLY");
				Stock5.setAsk(30f);
				Stock5.setBid(25.5f);
		
				Calendar d11 =Calendar.getInstance();
				d11.set(2014, 11, 15, 0, 0,0);
				Date date211=d11.getTime();
				Stock2.setDate(date211);
				myPortfolio.addStock(Stock5);
		
				myPortfolio.buyStock("PIH", 20);
				myPortfolio.buyStock("AAL", 30);
				myPortfolio.buyStock("CAAS", 40);
		
		//6
		/*  --> portfolioFullException
	    Stock Stock6=new Stock();
		Stock6.setSymbol("ROTEM");
		Stock6.setAsk(30f);
		Stock6.setBid(25.5f);

		Calendar d111 =Calendar.getInstance();
		d111.set(2014, 11, 15, 0, 0,0);
		Date date2111=d111.getTime();
		Stock2.setDate(date2111);
		myPortfolio.addStock(Stock6);
		*/

		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS", 40);
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		
		/*Add to check exceptions*/
		//myPortfolio.buyStock("ABC", 20); --> stockNotExistException 
		//myPortfolio.buyStock("CAAS", 1000000); --> balanceException
		myPortfolio.addStock(Stock1); //--> stockAlreadyExistExeption
	
		return myPortfolio;
	}
}