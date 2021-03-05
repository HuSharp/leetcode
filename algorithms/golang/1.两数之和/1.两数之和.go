/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-03-04 08:58:47
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-03-05 00:06:17
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	m := make(map[int]int)// 记录 val 与 index 的映射
	for i := 0; i < len(nums); i++ {
		another := target - nums[i]
		if _, ok := m[another]; ok {
			return []int{m[another], i}
		}
		m[nums[i]] = i
	}
	return nil


}

// @lc code=end

