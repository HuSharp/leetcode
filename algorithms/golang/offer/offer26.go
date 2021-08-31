package offer

func isSubStructure1(A *TreeNode, B *TreeNode) bool {
	if A == nil || B == nil{
		return false
	}
	return check(A, B) || check(A.Left, B) || check(A.Right, B)
}

// 需要注意的是 子树和子结构是不一样的
func check(A, B *TreeNode) bool {
	if B == nil {
		return true
	}
	if A == nil {
		return false
	}
	if A.Val == B.Val {
		return check(A.Left, B.Left) && check(A.Right, B.Right)
	}
	return false
}


func isSubStructure(root *TreeNode, subRoot *TreeNode) bool {
	var includeTree func(root1, root2 *TreeNode) bool
	includeTree = func(root1, root2 *TreeNode) bool {
		if root2 == nil {
			return true
		}
		if root1 == nil {
			return false
		}
		if root1.Val != root2.Val {
			return false
		}
		return includeTree(root1.Left, root2.Left) && includeTree(root1.Right, root2.Right)
	}

	if root == nil || subRoot == nil {
		return false
	} else if root != nil {
		if includeTree(root, subRoot) {
			return true
		}
		return isSubStructure(root.Left, subRoot) || isSubStructure(root.Right, subRoot)
	}
	return false
}