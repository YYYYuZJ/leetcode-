class Solution6 {
//    you are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//
//
//    Example 1:
//
//    Input: prices = [7,1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//    问题关键是在一个随机序列里找到一个最大差值，并要求小数在前大数在后
//    一维的动态规划思想，
//    动态规划思想核心就是，你为了解决某一次子问题计算出来的结果，对后续所有待处理的子问题都有帮助
//    设d[i]为第i个元素可能取得的最大差值maxprofit，那么d[i + 1] = d[i] + a[i] - a[i + 1]
//    但是这里面有一个很重要的点，就是不能当天卖，{7,6,4,3,1}，像这个序列，按照这种思想推测，得到的d[] = {-1 0 2 3 5},
//    所以我们不能从前往后推，要从后往前推，记d[i]为prices[i]及后面所有元素在内的最大值，这样对于每日一天的最大盈利，我们只需计算
//      d[i + 1] - prices[i]
    public int maxProfit(int[] prices) {
        int MaxPrice = 0;
        int ans = 0;
        for(int i = prices.length - 1; i >= 0; i--){
            if((MaxPrice - prices[i]) > ans) ans = MaxPrice - prices[i];
            if(prices[i] > MaxPrice) MaxPrice = prices[i];
        }
        return ans;
    }
}
