/*
 * @Descripttion:
 * @version:
 * @Author: HuSharp
 * @Date: 2021-03-05 09:05:55
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-03-06 12:03:02
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode.cn id=21 lang=golang
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
package leetcode

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {

	l3 := &ListNode{Val: 0}
	head := l3
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			l3.Next = l1
			l1 = l1.Next
		} else {
			l3.Next = l2
			l2 = l2.Next
		}
	}

	for l1 != nil {
		l3.Next = l1
		l1 = l1.Next
	}
	for l2 != nil {
		l3.Next = l2
		l2 = l2.Next
	}

	return head.Next
}

// @lc code=end
