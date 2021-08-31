package offer


func maxValue(grid [][]int) int {

	row := len(grid)
	col := len(grid[0])
	dp := make([][]int, row+1)
	for i := 0; i < row+1; i++ {
		dp[i] = make([]int, col+1)
	}
	////dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
	for i := 1; i <= row; i++ {
		for j := 1; j <= col; j++ {
			dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		}
	}
	return dp[row][col]
}
