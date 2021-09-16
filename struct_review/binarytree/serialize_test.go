package binarytree

import "testing"

func TestSerialize(t *testing.T) {
	root := &TreeNode{
		Val:   10,
		Left:  nil,
		Right: nil,
	}
	root.Left = &TreeNode{
		Val:   15,
		Left:  nil,
		Right: nil,
	}
	root.Right = &TreeNode{
		Val:   20,
		Left:  nil,
		Right: nil,
	}
	print(root)
	str := Serialize(root)
	print(Deserialize(str))
}
