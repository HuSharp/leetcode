package singleLinkedlist

import "fmt"

type ListNode struct {
	Next *ListNode
	Val interface{}
}

type LinkedList struct {
	head *ListNode
	length uint
}

func NewListNode(val interface{}) *ListNode {
	return &ListNode{
		Next: nil,
		Val:  val,
	}
}

func (node *ListNode) GetNext() *ListNode {
	return node.Next
}

func (node *ListNode) GetVal() interface{} {
	return node.Val
}

func NewLinkedList() *LinkedList {
	return &LinkedList{
		head:   NewListNode(0),
		length: 0,
	}
}

// 在某个节点后插入节点
func (list *LinkedList) InsertAfter(curNode *ListNode, val interface{}) bool {
	if curNode == nil {
		return false
	}
	newNode := NewListNode(val)
	oldNext := curNode.Next
	curNode.Next = newNode
	newNode.Next = oldNext
	list.length++
	return true
}

// 在某个前面后插入节点
func (list *LinkedList) InsertBefore(curNode *ListNode, val interface{}) bool {
	if nil == curNode || curNode == list.head {
		return false
	}
	pre := list.FindCurNodePreByVal(curNode.Val)
	if pre == nil {
		return false
	}
	newNode := NewListNode(val)
	pre.Next = newNode
	newNode.Next = curNode
	list.length++
	return true
}

// 通过值找到第一个等值节点
func (list *LinkedList) FindCurNodePreByVal(val interface{}) (pre *ListNode) {
	pre = list.head
	cur := pre.Next
	for cur.Val != val {
		if val == cur.Val {
			break
		}
		pre = cur
		cur = cur.Next
	}// 至此 找到当前节点
	if cur == nil {
		return nil
	}
	return pre
}

// 在链表首部插入节点
func (list *LinkedList) InsertToHead(val interface{}) bool {
	return list.InsertAfter(list.head, val)
}

// 在链表尾部插入节点
func (list *LinkedList) InsertToTail(val interface{}) bool {
	cur := list.head
	for cur != nil && cur.Next != nil {
		cur = cur.Next
	}
	return list.InsertAfter(cur, val)
}


// 通过索引查找节点
func (list *LinkedList) FindByIndex(index uint)	*ListNode {
	if index >= list.length {
		return nil
	}
	cur := list.head
	for index > 0 {
		if cur == nil {
			return nil
		}
		cur = cur.Next
		index--
	}
	return cur
}

// 删除传入的节点
func (list *LinkedList) DeleteNode(node *ListNode) bool {
	if node == nil {
		return false
	}
	pre := list.FindCurNodePreByVal(node.Val)
	if pre == nil {
		return false
	}
	pre.Next = node.Next
	return true
}

// 打印链表
func (list *LinkedList) Print() {
	cur := list.head
	format := ""
	for cur != nil {
		format += fmt.Sprintf("%+v", cur.GetVal())
		cur = cur.Next
		if cur != nil {
			format += "->"
		}
	}
	fmt.Println(format)
}


