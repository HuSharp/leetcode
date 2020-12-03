/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-03 12:33:04
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-03 12:36:16
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    // 只要是上升点我就买
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
                if(prices[i+1] - prices[i] > 0) {
                    profit += (prices[i+1] - prices[i]);
                }
        }

        return profit;
    }
}
// @lc code=end

