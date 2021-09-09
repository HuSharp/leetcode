package queue

import "fmt"

type ListNode struct {
	Next *ListNode
	Val interface{}
}

type LinkedListQueue struct {
	head *ListNode
	tail *ListNode
	length int
}

func NewLinkedListQueue() *LinkedListQueue {
	return &LinkedListQueue{
		head:   nil,
		tail:   nil,
		length: 0,
	}
}

func (queue *LinkedListQueue) EnQueue(val interface{}) {
	node := &ListNode{
		Next: nil,
		Val:  val,
	}
	if queue.tail == nil {
		queue.head, queue.tail = node, node
	} else {
		queue.tail.Next = node
		queue.tail = node
	}
	queue.length++
}

func (queue *LinkedListQueue) DeQueue() interface{} {
	if queue.head == nil {
		return nil
	}
	val := queue.head.Val
	queue.head = queue.head.Next
	queue.length--
	return val
}

func (queue *LinkedListQueue) String() string {
	if queue.head == nil {
		return "empty queue"
	}
	result := "head"
	for cur := queue.head; cur != nil; cur = cur.Next {
		result += fmt.Sprintf("->%+v", cur.Val)
	}
	result += "->tail"
	return result
}
