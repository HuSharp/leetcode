package offer


func numWays(n int) int {
	if n==0 || n== 1 {
		return 1
	}
	if n == 2 {
		return 2
	}
	dp := [2]int{1, 2}
	for i := 2; i < n; i++ {
		temp := (dp[0] + dp[1]) % 1000000007
		dp[1], dp[0] = temp, dp[1]
	}
	return dp[1]
}