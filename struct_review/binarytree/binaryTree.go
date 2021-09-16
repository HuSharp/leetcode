package binarytree

import (
	"Go_Project_Stu/leetcode/struct_review/stack_impl"
	"fmt"
)

type BinaryTree struct {
	root *Node
}

func NewBinaryTree(rootV interface{}) *BinaryTree {
	return &BinaryTree{NewNode(rootV)}
}

// 中序
/* stack + 左子链
当栈空时就数目遍历完毕，跳出循环遍历
 */
func (tree *BinaryTree) InOrderTraverse() {
	stack := stack_impl.NewArrayStack(32)

	format := ""
	curNode := tree.root
	// 找到左子链
	for {
		for curNode != nil {
			stack.Push(curNode)
			curNode = curNode.left
		}
		if stack.IsEmpty() {
			break
		}
		node := stack.Pop()
		format += fmt.Sprintf("%+v ", node.(*Node).data)
		curNode = node.(*Node).right
	}
	fmt.Println(format)
}


func (tree *BinaryTree) PreOrderTraverse() {
	// 采用 stack 实现
	stack := stack_impl.NewArrayStack(32)

	stack.Push(tree.root)
	format := ""
	for !stack.IsEmpty() {
		curNode := stack.Pop()
		format += fmt.Sprintf("%+v ", curNode.(*Node).data)
		if curNode.(*Node).right != nil {
			stack.Push(curNode.(*Node).right)
		}
		if curNode.(*Node).left != nil {
			stack.Push(curNode.(*Node).left)
		}
	}
	fmt.Println(format)
}


// 后序：由于先序是 根左右， 而后序是 左右根。因此先入栈，再用个栈pop出来
func (tree *BinaryTree) PostOrderTraverse() {
	// 采用 stack 实现
	stack := stack_impl.NewArrayStack(32)
	reverseStack := stack_impl.NewArrayStack(32)

	stack.Push(tree.root)
	format := ""
	for !stack.IsEmpty() {
		curNode := stack.Pop()
		reverseStack.Push(curNode)
		if curNode.(*Node).left != nil {
			stack.Push(curNode.(*Node).left)
		}
		if curNode.(*Node).right != nil {
			stack.Push(curNode.(*Node).right)
		}
	}

	for !reverseStack.IsEmpty() {
		curNode := reverseStack.Pop()
		format += fmt.Sprintf("%+v ", curNode.(*Node).data)
	}
	fmt.Println(format)
}
