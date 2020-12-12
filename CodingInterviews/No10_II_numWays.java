/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-12 11:24:24
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-12 11:24:33
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No10_II_numWays {
    public int numWays_1(int n) {
        if(n==0 || n== 1) {
            return 1;
        } 

        if(n== 2) {
            return 2;
        } 

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = ( dp[i-1] + dp[i-2] ) % 1000000007;
        }
        return dp[n];
    }

    public int numWays(int n) {
        if(n==0 || n== 1) {
            return 1;
        } 

        if(n== 2) {
            return 2;
        } 

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            int temp = ( dp[0] + dp[1] ) % 1000000007;
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
}
