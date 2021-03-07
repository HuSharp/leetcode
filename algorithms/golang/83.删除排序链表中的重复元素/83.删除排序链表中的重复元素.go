/*
 * @Descripttion:
 * @version:
 * @Author: HuSharp
 * @Date: 2021-03-07 11:20:46
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-03-07 11:34:08
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode.cn id=83 lang=golang
 *
 * [83] 删除排序链表中的重复元素
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

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	if head.Next == nil {
		return head
	}
	cur := head
	for cur.Next != nil {
		if cur.Next.Val == cur.Val {
			cur.Next = cur.Next.Next
		} else {
			cur = cur.Next
		}
	}

	return head
}

type ListNode struct {
	Val  int
	Next *ListNode
}

// @lc code=end
