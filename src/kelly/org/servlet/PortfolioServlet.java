package kelly.org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kelly.org.model.Portfolio;
import kelly.org.model.Stock;
import kelly.org.service.PortfolioService;
import kelly.org.exception.*;

@SuppressWarnings("serial")

public class PortfolioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException,ServletException {
		resp.setContentType("text/html");
		
		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio1;
		try {
			portfolio1 = portfolioService.getPortfolio();
		} catch (StockAlreadyExistsException | PortfolioFullException
				| BalanceException | StockNotExistException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			portfolio1 = portfolioService.getPortfolio();
			resp.getWriter().println(portfolio1.getHtmlString());
		}
		 
	
		catch (PortfolioFullException e) {
			resp.getWriter().println("Dude - your portfolio is full!");
		}
		catch(StockAlreadyExistsException ee) {
			resp.getWriter().println("Dude - stock already exists.");			
		}
		catch (BalanceException eee){
			resp.getWriter().println("Negative Balance!");
		}
		catch (StockNotExistException eeee){
			resp.getWriter().println("The stock doesn't exist!");
			
		}
	}
}

	
	   

	

