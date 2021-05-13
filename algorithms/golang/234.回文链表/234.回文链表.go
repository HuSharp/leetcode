/*
 * @Descripttion:
 * @version:
 * @Author: HuSharp
 * @Date: 2021-03-09 08:35:01
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-03-11 09:16:53
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode.cn id=234 lang=golang
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
package main

import "fmt"

func isPalindrome(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}

	fast := head
	slow := fast
	var prev *ListNode = nil

	// 快慢指针
	if fast != nil && fast.Next != nil {
		prev = slow
		slow = slow.Next
		fast = fast.Next.Next
	}

	// 说明为偶数
	if fast != nil {
		prev = slow
		slow = slow.Next
	} // 至此 slow 到达右侧第一个，开始对比
	prev.Next = nil // 进行隔开

	// 对后面进行翻转, 开始对比
	slow = reverse(slow)
	secondEnd := slow
	for head != nil && slow != nil {
		if head.Val != slow.Val {
			return false
		}
		fmt.Println(head.Val)
		head = head.Next
		slow = slow.Next
	}
	// 对链表进行还原
	prev.Next = reverse(secondEnd)
	return true
}

func reverse(head *ListNode) *ListNode {
	var prev, cur *ListNode = nil, head

	for cur != nil {
		next := cur.Next
		cur.Next = prev
		prev = cur
		cur = next
	}
	return prev
}

func isPalindrome_array(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}

	vals := []int{}
	for head != nil {
		vals = append(vals, head.Val)
		head = head.Next
	}

	// 双指针分别从前后判断
	n := len(vals)
	for i, v := range vals[:n/2] {
		if v != vals[n-i-1] {
			return false
		}
	}
	return true
}

type ListNode struct {
	Val  int
	Next *ListNode
}

// @lc code=end
