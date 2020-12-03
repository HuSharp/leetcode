/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-03 12:22:25
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-03 12:28:03
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    // 时刻记录当前的最小值， 将当前值与最小值求差值, 算出最大利润
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int curMin = prices[0];
        int profit = 0;// 保底为 0（当买当卖)
        for (int i = 0; i < prices.length; i++) {
            curMin = curMin < prices[i]? curMin : prices[i];
            profit = profit > (prices[i] - curMin) ? profit : (prices[i] - curMin);
        }
        return profit;
    }
}
// @lc code=end

