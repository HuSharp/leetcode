/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-03-05 00:01:25
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-03-05 00:33:53
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode.cn id=2 lang=golang
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type ListNode struct {
	Val int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{Val: 0} // 头指针
	n1, n2, carry := 0, 0, 0
	current := head
	for l1 != nil || l2 != nil || carry != 0 {
		if l1 == nil {
			n1 = 0
		} else {
			n1 = l1.Val
			l1 = l1.Next
		}

		if l2 == nil {
			n2 = 0
		} else {
			n2 = l2.Val
			l2 = l2.Next
		}

		current.Next = &ListNode{Val : (n1 + n2 + carry) % 10}
		current = current.Next
		carry = (n1 + n2 + carry) / 10
	}

	return head.Next
}
// @lc code=end

