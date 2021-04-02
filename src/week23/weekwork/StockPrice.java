package week23.weekwork;

import org.junit.Test;

public class StockPrice {
	
	/**
	 * Problem 1)
	 * 
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day. You want to maximize your profit by choosing a single day to
	 * buy one stock and choosing a different day in the future to sell that stock.
	 * 
	 * Return the maximum profit you can achieve from this transaction. If you
	 * cannot achieve any profit, return 0.
	 * 
	 * Example 1:
	 * 
	 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
	 * and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2
	 * and selling on day 1 is not allowed because you must buy before you sell.
	 * 
	 * Constraint: Solve using Single Pass with constant space
	 */
	
	@Test
	public void eg1() {
		int[] prices= {7,1,5,3,6,4,2};
		System.out.println(maxprofie(prices));
	}
	
	@Test
	public void eg2() {
		int[] prices= {7,6,4,3,1};
		System.out.println(maxprofie(prices));
	}
	
	@Test
	public void eg3() {
		int[] prices= {1,2,3,4,5};
		System.out.println(maxprofie(prices));
	}
	
	private int maxprofie(int[] prices) {
		int minPrice = prices[0];
        int maxProfit = 0;
        for(int price:prices){
            minPrice = Math.min(minPrice,price);
            maxProfit = Math.max(maxProfit,price-minPrice);
        }
        return maxProfit;
	}

}
