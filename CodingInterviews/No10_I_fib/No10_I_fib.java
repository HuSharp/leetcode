/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-12 11:00:58
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-12 11:01:07
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No10_I_fib {
    public int fib_1(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i<=n; i++) {      
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007 ;
        }
        
        return dp[n];
    }

    public int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        int temp = 0;
        for(int i = 2; i<=n; i++) {  
            temp = (dp[0] + dp[1]) % 1000000007;
            dp[0] = dp[1];
            dp[1] = temp; 
        }
        return dp[1];
    }
}
