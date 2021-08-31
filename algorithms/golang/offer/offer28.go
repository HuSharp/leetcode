package offer


func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}

	var isSymmetricTwoNode func(root1, root2 *TreeNode) bool
	isSymmetricTwoNode = func(root1, root2 *TreeNode) bool {
		if root1 == nil && root2 == nil {
			return true
		}
		if root1 == nil || root2 == nil {
			return false
		}

		return root1.Val == root2.Val && isSymmetricTwoNode(root1.Left, root2.Right) &&
			isSymmetricTwoNode(root1.Right, root2.Left)
	}
	return isSymmetricTwoNode(root.Left, root.Right)
}

