package offer


func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
	var sameTree func(root1, root2 *TreeNode) bool
	sameTree = func(root1, root2 *TreeNode) bool {
		if root1 == nil && root2 == nil {
			return true
		} else if root1 != nil && root2 != nil {
			if root1.Val != root2.Val {
				return false
			}
			return sameTree(root1.Left, root2) || sameTree(root1.Right, root2)
		}
		return false
	}

	if root == nil && subRoot == nil {
		return true
	} else if root != nil {
		if sameTree(root, subRoot) {
			return true
		}
		return isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot)
	}
	return false
}