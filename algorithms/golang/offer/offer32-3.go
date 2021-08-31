package offer


func levelOrder32_3(root *TreeNode) (res [][]int){
	if root == nil {
		return
	}
	// 层次遍历
	queue := []*TreeNode{}
	queue = append(queue, root)
	direction := -1	// 1 表示从左到右
	for len(queue) != 0 {
		curNum := len(queue)
		resRow := []int{}
		direction *= -1
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
		if direction == 1 {
			res = append(res, resRow)
		} else {
			reverse := []int{}
			for i := 0; i < curNum; i++ {
				reverse = append(reverse, resRow[curNum-i-1])
			}
			res = append(res, reverse)
		}
	}
	return
}