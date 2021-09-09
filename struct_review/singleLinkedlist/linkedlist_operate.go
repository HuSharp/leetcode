package singleLinkedlist


// 删除倒数第 n 个节点
func (list *LinkedList) DeleteBottomNodeByIndex(n int) {
	fast := list.head
	// 快指针先到达 n 处
	for i := 0; i < n; i++ {
		if fast == nil {
			return
		}
		fast = fast.Next
	}

	slow := list.head
	for fast != nil {
		slow = slow.Next
		fast = fast.Next
	}
	// 此时 slow 到达位置
	slow.Next = slow.Next.Next


}

// 翻转链表
func (list *LinkedList)ReverseLinkedList(node *ListNode) *ListNode {
	var pre, cur *ListNode
	cur = node
	for cur != nil {
		next := cur.Next
		cur.Next = pre
		pre = cur
		cur = next
	}
	return pre
}

