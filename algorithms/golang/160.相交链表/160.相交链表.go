/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-03-05 00:33:02
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-03-05 00:44:17
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode.cn id=160 lang=golang
 *
 * [160] 相交链表
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

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	hA, hB := headA, headB
    if headA != headB {
		if headA == nil {
			headA = hB
		} else {
			headA = headA.Next
		}
		if headB == nil {
			headB = hA
		} else {
			headB = headB.Next
		}
	}
	return headA
}
// @lc code=end

