package kelly.org.model;

import java.util.Date;

import kelly.org.model.Portfolio.ALGO_RECOMMENDATION;
import kelly.org.*;

public class StockStatus extends Stock {

	public ALGO_RECOMMENDATION recommendation;
	public int stockQuantity;

	// constructor
	public StockStatus(String symbol, float bid, float ask, Date date,
			ALGO_RECOMMENDATION recommendation, int stockQuantity) {
		super(ask, bid, symbol, (java.sql.Date) date);
		this.recommendation = recommendation;
		this.stockQuantity = stockQuantity;
	}
	public StockStatus(Stock stock){
		super(stock);
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		this.stockQuantity = 0;
	}

	public StockStatus() {
		super();
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		this.stockQuantity = 0;
	}

	// copy constructor
	public StockStatus(StockStatus stockStatus) {
		super(stockStatus);
		this.recommendation = stockStatus.getRecommendation();
		this.stockQuantity = stockStatus.getStockQuantity();
	}

	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}