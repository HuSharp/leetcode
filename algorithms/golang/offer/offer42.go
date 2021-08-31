package offer


func maxSubArray(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	dp, res := make([]int, len(nums)), nums[0]
	dp[0] = nums[0]
	for i := 0; i < len(nums); i++ {
		if dp[i-1] > 0 {
			dp[i] = dp[i-1] + nums[i]
		} else {
			dp[i] = nums[i]
		}
		res = max(res, dp[i])
	}
	return res
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}