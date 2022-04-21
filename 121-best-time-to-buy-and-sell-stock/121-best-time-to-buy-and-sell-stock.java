class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int cost = 0;
        int N = prices.length;
        int profit = 0;
        for(int i = 1; i < N; i++){
            cost = prices[i] - min;
            profit = (cost > profit) ? cost : profit;
            min = (min > prices[i]) ? prices[i]:min;
        }
        
        return profit;
    }
}