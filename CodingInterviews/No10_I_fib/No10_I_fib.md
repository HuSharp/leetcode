[剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

[剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)

[70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

以上几题均差不多思路



### 题目  斐波那契数列

写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

```
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
```

斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。





**代码如下**

采用动态规划：每次对 1000000007 进行取余就行

```java
class Solution {
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
}
```

**优化空间**：通过两个变量保存每次需要动态规划的数值即可。

```java
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
```

