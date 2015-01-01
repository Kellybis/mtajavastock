package kelly.org.service;

import java.util.Calendar;
import java.util.Date;

import kelly.org.model.*;
import kelly.org.servlet.*;
import kelly.org.model.Portfolio;

public class PortfolioService {
	
	public Portfolio getPortfolio(){
				
		 		Portfolio myPortfolio = new Portfolio();
			
				myPortfolio.setTitle("Exercise 7 portfolio");
				myPortfolio.updateBalance(10000);
				
		 		
		 		
		 		//1
		 		Stock Stock1=new Stock();
		 		Stock1.setSymbol("PIH");
				Stock1.setAsk(12.4f);
				Stock1.setBid(13.1f);
				Stock1.setAsk(10f);
				Stock1.setBid(8.5f);
		 		
		 		Calendar c =Calendar.getInstance();
				c.set(2014, 10, 15, 0, 0,0);
				c.set(2014, 11, 15, 0, 0,0);
		 		Date date=c.getTime();
		 	    Stock1.setDate(date);
		 		myPortfolio.addStock(Stock1);
		 		
		  
		 		//2
		 		Stock Stock2=new Stock();
		 		Stock2.setSymbol("AAL");
				Stock2.setAsk(5.5f);
				Stock2.setBid(5.78f);
				Stock2.setAsk(30f);
				Stock2.setBid(25.5f);
	
		 		
		 		Calendar d =Calendar.getInstance();
				d.set(2014, 10, 15, 0, 0,0);
				d.set(2014, 11, 15, 0, 0,0);
		 		Date date2=d.getTime();
		 		Stock2.setDate(date2);
		 		myPortfolio.addStock(Stock2);
		 		
		 		//3
		 		Stock Stock3=new Stock();
		 		Stock3.setSymbol("CAAS");
				Stock3.setAsk(31.5f);
		        Stock3.setBid(31.2f);
				Stock3.setAsk(20f);
				Stock3.setBid(15.5f);
		
		 		
		 		Calendar e =Calendar.getInstance();
				e.set(2014, 10, 15, 0, 0,0);;
				e.set(2014, 11, 15, 0, 0,0);;
		 		Date date3=c.getTime();
		 		Stock3.setDate(date3);
		 		myPortfolio.addStock(Stock3);
		 		
				myPortfolio.buyStock("PIH", 20);
				myPortfolio.buyStock("AAL", 30);
				myPortfolio.buyStock("CAAS", 40);
				myPortfolio.sellStock("AAL", -1);
				myPortfolio.removeStock("CAAS");
				
						
		 		return myPortfolio;
		 	}
}
