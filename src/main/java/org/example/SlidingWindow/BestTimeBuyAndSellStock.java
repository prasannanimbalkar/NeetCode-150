package org.example.SlidingWindow;

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class BestTimeBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0; // No profit can be made with less than 2 prices
        }

        int minPrice = prices[0]; // Initialize min price to the first price
        int maxProfit = 0; // Initialize max profit to 0

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // Update min price if current price is lower
                minPrice = prices[i];
            } else {
                // Calculate profit if sold at current price and update max profit if higher
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit; // Return the maximum profit found
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Maximum Profit: " + maxProfit(prices2));
    }
}


//We start by checking if the prices array is valid for making a profit (it should have at least two prices).
//The minPrice is initially set to the first price in the array.
//As we iterate through the array, we update the minPrice whenever a lower price is found.
//We calculate the potential profit at each price (current price - minPrice) and update the maxProfit if this potential profit is greater than the current maxProfit.
//Finally, we return the maxProfit.
