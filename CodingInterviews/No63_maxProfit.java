/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-11 23:30:20
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-11 23:34:52
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No63_maxProfit {
    // 只卖入一次
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
