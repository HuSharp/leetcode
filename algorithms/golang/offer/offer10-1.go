package offer


func fib(n int) int {
	if n == 0 || n == 1{
		return n
	}
	dp := [2]int{0, 1}
	for i := 2; i <= n; i++ {
		temp := (dp[0] + dp[1]) % 1000000007
		dp[1], dp[0] = temp, dp[1]
	}
	return dp[1]
}