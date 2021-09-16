package binarytree

// BST Binary Search Tree 二叉搜索树
type BST struct {
	*BinaryTree
	//比对函数，0:v==nodeV,正数:v>nodeV,负数:v<nodeV
	compareFunc func(v, nodeV interface{}) int
}

func NewBST(rootVal interface{}, compareFunc func(val, nodeV interface{}) int) *BST {
	if compareFunc == nil {
		return nil
	}
	return &BST{
		BinaryTree:  NewBinaryTree(rootVal),
		compareFunc: compareFunc,
	}
}

func (tree *BST) Find(val interface{}) *Node {
	curNode := tree.root
	for curNode != nil {
		compareResult := tree.compareFunc(val, curNode.data)
		if compareResult == 0 {
			return curNode
		} else if compareResult > 0 {
			curNode = curNode.right
		} else {
			curNode = curNode.left
		}
	}
	return nil
}

func (tree *BST) Insert(val interface{}) bool {
	curNode := tree.root
	for curNode != nil {
		compareResult := tree.compareFunc(val, curNode.data)
		if compareResult == 0 {
			return false
		} else if compareResult > 0 {
			if curNode.right == nil {
				curNode.right = NewNode(val)
			}
			curNode = curNode.right
		} else {
			if curNode.left == nil {
				curNode.left = NewNode(val)
			}
			curNode = curNode.left
		}
	}
	return true
}

/*
	关于二叉查找树的删除操作，还有个非常简单、取巧的方法，
	就是单纯将要删除的节点标记为“已删除”，但是并不真正从树中将这个节点去掉。
	这样原本删除的节点还需要存储在内存中，比较浪费内存空间，
 */
func (tree *BST) Delete(val interface{}) bool {
	// 首先找到此节点。以及其父节点
	var parentNode, curNode *Node = nil, tree.root
	for curNode != nil {
		compareResult := tree.compareFunc(val, curNode.data)
		if compareResult == 0 {
			break
		} else if compareResult > 0 {
			parentNode = curNode
			curNode = curNode.right
		} else {
			parentNode = curNode
			curNode = curNode.left
		}
	}

	if curNode == nil { // 删除的节点不存在
		return false
	} else if curNode.right != nil && curNode.left != nil {// 有两个节点
		// 需要找到右子树最小节点
		minNode := curNode.right
		parentNode = curNode
		for minNode.left != nil {
			parentNode = minNode
			minNode = minNode.left
		}
		// 交换 minNode 和 curNode 数据
		curNode.data = minNode.data
		curNode = minNode// 之后就是删除 minNode 了
	}
	// 删除的节点是叶子节点或者仅有一个子节点
	var childNode *Node
	if curNode.right != nil {
		childNode = curNode.right
	} else if curNode.left != nil {
		childNode = curNode.left
	} else {
		childNode = nil
	}

	// 删除节点
	if parentNode == nil {// 说明为根节点
		tree.root = childNode
	} else if parentNode.left == curNode {
		parentNode.left = childNode
	} else {
		parentNode.right = childNode
	}
	return true
}

func (tree *BST) Min(root *Node) *Node {
	curNode := root
	for curNode != nil {
		curNode = curNode.left
	}
	return curNode
}


func (tree *BST) Max(root *Node) *Node {
	curNode := root
	for curNode.left != nil {
		curNode = curNode.left
	}
	return curNode
}

