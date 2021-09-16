package stack_impl

import (
	"fmt"
)


type ListNode struct {
	Next *ListNode
	Val interface{}
}

/*
基于链表实现栈
 */
type LinkedListStack struct {
	// 栈顶节点
	topNode *ListNode
}

func NewLinkedListStack() *LinkedListStack {
	return &LinkedListStack{nil}
}

func (stack *LinkedListStack) Push(val interface{}) {
	stack.topNode = &ListNode{
		Next: stack.topNode,
		Val:  val,
	}
}

func (stack *LinkedListStack) Pop() interface{} {
	if stack.IsEmpty() {
		return nil
	}
	val := stack.topNode.Val
	stack.topNode = stack.topNode.Next
	return val
}

func (stack *LinkedListStack) IsEmpty() bool {
	return stack.topNode == nil
}

func (stack *LinkedListStack) Top() interface{} {
	if stack.IsEmpty() {
		return nil
	}
	return stack.topNode.Val
}

func (stack *LinkedListStack) Flush() {
	stack.topNode = nil
}

func (stack *LinkedListStack) Print() {
	format := ""
	if stack.IsEmpty() {
		fmt.Println("empty stack")
	} else {
		cur := stack.topNode
		for cur != nil {
			format += fmt.Sprintf("[%+v] ", cur.Val)
			cur = cur.Next
		}
	}
	fmt.Println(format)
}
