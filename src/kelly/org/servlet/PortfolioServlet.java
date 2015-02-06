package kelly.org.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kelly.org.model.Portfolio;
import kelly.org.model.Stock;
import kelly.org.model.StockStatus;
import kelly.org.service.PortfolioService;
import kelly.org.dto.PortfolioDto;
import kelly.org.dto.PortfolioTotalStatus;
import kelly.org.exception.*;

public class PortfolioServlet extends AbstractAlgoServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("application/json");

		PortfolioTotalStatus[] totalStatus = portfolioService
				.getPortfolioTotalStatus();
		StockStatus[] stockStatusArray = portfolioService.getPortfolio()
				.getStocks();
		List<StockStatus> stockStatusList = new ArrayList<>();
		for (StockStatus ss : stockStatusArray) {
			if (ss != null)
				stockStatusList.add(ss);
		}

		PortfolioDto pDto = new PortfolioDto();
		pDto.setTitle(portfolioService.getPortfolio().getTitle());
		pDto.setTotalStatus(totalStatus);
		pDto.setStockTable(stockStatusList);
		resp.getWriter().print(withNullObjects().toJson(pDto));
	}
}