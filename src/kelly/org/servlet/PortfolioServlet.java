package kelly.org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kelly.org.model.Portfolio;
import kelly.org.model.Stock;
import kelly.org.service.PortfolioService;

@SuppressWarnings("serial")

public class PortfolioServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
	resp.setContentType("text/html");
	
	PortfolioService portfolioService = new PortfolioService();
	Portfolio portfolio1 = portfolioService.getPortfolio();
	Portfolio portfolio2= new Portfolio(portfolio1);
	
   /**
    * Print portfolio1 details
    */
	resp.getWriter().println(portfolio1.getHtmlString());
	
	}
	
}
