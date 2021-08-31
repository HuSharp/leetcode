package offer

func levelOrder32_2(root *TreeNode) (res [][]int){
	if root == nil {
		return
	}
	// 层次遍历
	queue := []*TreeNode{}
	queue = append(queue, root)
	for len(queue) != 0 {
		curNum := len(queue)
		resRow := []int{}
		for i := 0; i < curNum; i++ {
			curNode := queue[0]
			queue = queue[1:]

			resRow = append(resRow, curNode.Val)
			if curNode.Left != nil {
				queue = append(queue, curNode.Left)
			}
			if curNode.Right != nil {
				queue = append(queue, curNode.Right)
			}
		}
		res = append(res, resRow)
	}
	return
}