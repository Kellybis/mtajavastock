package kelly.org;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StockDetailsServlet extends HttpServlet{

		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		resp.setContentType("text/html");
		
	
		
		
		//PIH
		Stock stockDetails1 = new Stock() ;
		stockDetails1.setSymbol("PIH");
		stockDetails1.setAsk(12.4f);
		stockDetails1.setBid(13.1f);
		
		Calendar c = Calendar.getInstance();
		c.set(2014, 10, 15);
		Date d1 = c.getTime();
		stockDetails1.setDate(c.getTime());
		
	
		resp.getWriter().println(stockDetails1.getHtmlDescription());
		
		//AAL
		
		Stock stockDetails2 = new Stock() ;
		stockDetails2.setSymbol("AAL");
		stockDetails2.setAsk(5.5f);
		stockDetails2.setBid(5.78f);
		
		c = Calendar.getInstance();
		c.set(2014, 10, 15);
		Date date2 = c.getTime();
		stockDetails2.setDate(date2);
		
		
		resp.getWriter().println(stockDetails2.getHtmlDescription());
	
		//CAAS
		Stock stockDetails3 = new Stock() ;
		stockDetails3.setSymbol("CAAS");
		stockDetails3.setAsk(31.5f);
		stockDetails3.setBid(31.2f);
		
		c = Calendar.getInstance();
		c.set(2014, 10, 15);
		Date date3 = c.getTime();
		stockDetails3.setDate(date3);
		
	
		resp.getWriter().println(stockDetails3.getHtmlDescription());
		
		
		}
		}


