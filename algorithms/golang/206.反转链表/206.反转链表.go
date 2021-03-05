/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-03-05 08:32:56
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-03-05 09:05:21
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode.cn id=206 lang=golang
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
	var tmp *ListNode
	for head != nil {
		next := head.Next
		head.Next = tmp
		tmp = head
		head =  next
	}
	return tmp
}
// @lc code=end

