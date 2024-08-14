class Solution7 {
//    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
//    However, you can buy it then immediately sell it on the same day.
//    Find and return the maximum profit you can achieve.
//    Example 1:
//    Input: prices = [7,1,5,3,6,4]
//    Output: 7
//    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//    Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//    Total profit is 4 + 3 = 7.
//
//    Example 2:
//    Input: prices = [1,2,3,4,5]
//    Output: 4
//    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//    Total profit is 4.
//
//    Example 3:
//    Input: prices = [7,6,4,3,1]
//    Output: 0
//    Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

//    Constraints:
//
//            1 <= prices.length <= 3 * 104
//            0 <= prices[i] <= 104

//分成多个不相交的子区间，每个子区间首尾的差值即为产出，要想让总产出最大化，需要保证每个子区间单调不减
//计算所有的单调不减子区间的差值之和，并且这些子区间互不相交
//所以每一次买进的时间一定是在a[i]<a[i-1]的第i个位置上，对应的，卖出上一只股票的时间也是在i - 1天如果一直在亏钱，那么这支股票就不要买，否则就加上

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;//记录当前总盈利
        int sub_profit = -prices[0];//记录当前这支股票是否盈利
        for(int i = 1; i < n; i++){
            if((prices[i] < prices[i-1])||i == n - 1){
                if(prices[i] < prices[i-1]){
                    sub_profit += prices[i - 1];
                }
                else{
                    sub_profit += prices[i];
                }
                if(sub_profit > 0){
                    profit += sub_profit;
                }
                sub_profit = -prices[i];
            }
        }
        return profit;
    }
    public int maxProfit2(int[] prices) {
        //上一种思路很正确，但还是把简单的问题复杂化了,关键是prices[n - 1] - prices[0] =prices[1] - prices[0] + prices[2] - prices[1]...
        //prices[n - 1] - prices[n - 2]基于这个等式，我们只需将所有的正项相加就可以了，这就保证了我们买走了所有赚钱的股票。
        int n = prices.length;
        int profit = 0;//记录当前总盈利
        for(int i = 1; i < n; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
