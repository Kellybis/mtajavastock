package kelly.org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kelly.org.model.Portfolio;
import kelly.org.model.Stock;
import kelly.org.service.PortfolioService;

public class PortfolioServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	resp.setContentType("text/html");
	
	PortfolioService portfolioService = new PortfolioService();
	Portfolio portfolio = portfolioService.getPortfolio();
	Stock[] stocks = portfolio.getStocks();
	
	Portfolio portfolio2= new Portfolio(portfolio);
	
	portfolio2.setTitle("Portfolio#2");
	
	portfolio2.getStocks()[2].setBid((float) 55.55);
	
   /**
    * Print portfolio details
    */
	resp.getWriter().println(portfolio.getHtmlString());
	
	/**
	 * print portfolio2 details
	 */
	resp.getWriter().println(portfolio2.getHtmlString());

	}

	private void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}
}
