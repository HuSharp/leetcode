package offer

type ListNode struct {
	Val int
	Next *ListNode
}

func reversePrint(head *ListNode) (res []int) {
	node := reverseNode(head)
	res = printNode(node)
	return
}

func reverseNode(head *ListNode) *ListNode {
	var pre, cur *ListNode = nil, head
	for cur != nil {
		next := cur.Next
		cur.Next = pre
		pre, cur = cur, next
	}
	return pre
}

func printNode(head *ListNode) (res []int) {
	for head != nil {
		res = append(res, head.Val)
		head = head.Next
	}
	return
}