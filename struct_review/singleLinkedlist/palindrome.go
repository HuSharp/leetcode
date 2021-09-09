package singleLinkedlist


// 找到链表中间节点，将前半部分转置，再从中间向左右遍历对比
func isPalindrome(list *LinkedList) bool {
	listLen := list.length
	if listLen == 0 {
		return false
	}
	if listLen == 1 {
		return true
	}

	var isPalindrome = true
	fast, slow := list.head, list.head
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}// 至此 slow 到达中点
	midNodeNext := slow.Next
	// 进行翻转
	midNode := list.ReverseLinkedList(midNodeNext)
	head := list.head
	// 进行对比
	for midNode != nil && head != nil {
		if midNode.Val != head.Val {
			isPalindrome = false
			break
		}
		midNode = midNode.Next
		head = head.Next
	}
	// 复原
	list.ReverseLinkedList(midNodeNext)
	slow.Next = midNodeNext

	return isPalindrome
}