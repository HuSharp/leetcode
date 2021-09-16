package binarytree

import "testing"

func TestBinaryTree_PreOrderTraverse(t *testing.T) {
	binaryTree := NewBinaryTree(1)
	binaryTree.root.left = NewNode(3)
	binaryTree.root.right = NewNode(4)
	binaryTree.root.right.left = NewNode(5)

	binaryTree.PreOrderTraverse()
}

func TestBinaryTree_InOrderTraverse(t *testing.T) {
	binaryTree := NewBinaryTree(1)
	binaryTree.root.left = NewNode(3)
	binaryTree.root.right = NewNode(4)
	binaryTree.root.right.left = NewNode(5)

	binaryTree.InOrderTraverse()
}


func TestBinaryTree_PostOrderTraverse(t *testing.T) {
	binaryTree := NewBinaryTree(1)
	binaryTree.root.left = NewNode(3)
	binaryTree.root.right = NewNode(4)
	binaryTree.root.right.left = NewNode(5)

	binaryTree.PostOrderTraverse()
}
