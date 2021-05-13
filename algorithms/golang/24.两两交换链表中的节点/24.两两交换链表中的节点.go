/*
 * @Descripttion:
 * @version:
 * @Author: HuSharp
 * @Date: 2021-03-08 08:48:10
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-03-08 09:17:59
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode.cn id=24 lang=golang
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
// 递归版本
func swapPairs_rec(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	// 进行交换。主要两个两个进行判断，分为 head 和 newHead
	newHead := head.Next
	head.Next = swapPairs(newHead.Next)
	newHead.Next = head
	return newHead
}

func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	dummyNode := &ListNode{Val: 0, Next: head}
	cur := dummyNode
	if cur.Next != nil && cur.Next.Next != nil {
		node1 := cur.Next
		node2 := node1.Next

		cur.Next = node2
		node1.Next = node2.Next
		node2.Next = node1

		cur = node1
	} /// 至此都到达了相应位置
	return dummyNode.Next
}

type ListNode struct {
	Val  int
	Next *ListNode
}

// @lc code=end

