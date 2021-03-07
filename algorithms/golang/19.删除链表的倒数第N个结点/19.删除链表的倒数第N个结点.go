/*
 * @Descripttion:
 * @version:
 * @Author: HuSharp
 * @Date: 2021-03-07 11:34:37
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-03-07 16:54:36
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode.cn id=19 lang=golang
 *
 * [19] 删除链表的倒数第 N 个结点
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

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	if head == nil || n <= 0 {
		return head
	}

	// 利用头指针
	var pre *ListNode = &ListNode{Val: 0, Next: head}

	// 采用双指针
	fast, slow := pre, pre
	// fast 先走 n 步
	// for n != 0 {
	// 	fast = fast.Next
	// 	n--
	// }
	for i := 0; i < n; i++ {
		fast = fast.Next
	}

	for fast.Next != nil {
		slow = slow.Next
		fast = fast.Next
	}
	// 至此 slow 到达指定位置
	slow.Next = slow.Next.Next
	return pre.Next
}

type ListNode struct {
	Val  int
	Next *ListNode
}

// @lc code=end
