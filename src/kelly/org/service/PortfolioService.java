package kelly.org.service;

import java.util.Calendar;
import java.util.Date;

import kelly.org.model.*;
import kelly.org.servlet.*;
import kelly.org.model.Portfolio;

public class PortfolioService {
	
	public Portfolio getPortfolio(){
		
	Portfolio myPortfolio = new Portfolio();
	
	//PIH
			Stock stockDetails1 = new Stock() ;
			stockDetails1.setSymbol("PIH");
			stockDetails1.setAsk(12.4f);
			stockDetails1.setBid(13.1f);
			
			Calendar c = Calendar.getInstance();
			c.set(2014, 10, 15, 0, 0, 0);
			Date d1 = c.getTime();
			stockDetails1.setDate(c.getTime());
			
			myPortfolio.addStock(stockDetails1);
			
	//AAL		  
			
			Stock stockDetails2 = new Stock() ;
			stockDetails2.setSymbol("AAL");
			stockDetails2.setAsk(5.5f);
			stockDetails2.setBid(5.78f);
			
			c = Calendar.getInstance();
			c.set(2014, 10, 15, 0, 0, 0);
			Date date2 = c.getTime();
			stockDetails2.setDate(date2);
			
			myPortfolio.addStock(stockDetails2);
			
		
	//CAAS	
			Stock stockDetails3 = new Stock() ;
			stockDetails3.setSymbol("CAAS");
			stockDetails3.setAsk(31.5f);
			stockDetails3.setBid(31.2f);
			
			c = Calendar.getInstance();
			c.set(2014, 10, 15, 0, 0, 0);
			Date date3 = c.getTime();
			stockDetails3.setDate(date3);
			
		
			myPortfolio.addStock(stockDetails3);
			return myPortfolio;
			
	}
      

}
