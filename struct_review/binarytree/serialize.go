package binarytree

import (
	"fmt"
	"strconv"
	"strings"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//序列化
func Serialize(root *TreeNode) string {
	str := ""
	if root == nil {
		str += "#!"
		return str
	}
	str += strconv.Itoa(root.Val)
	str += Serialize(root.Left)
	str += Serialize(root.Right)
	return str
}

var index = -1
//反序列化
func Deserialize(str string) *TreeNode {
	strArray := strings.Split(str,"!")
	node := &TreeNode{}
	index++
	//最后一个index截取后为空
	if strArray[index] != "#" {
		val, _ := strconv.Atoi(strArray[index])
		node.Val = val
		node.Left = Deserialize(str)
		node.Right = Deserialize(str)
	}
	return node
}

func print(root *TreeNode)  {
	if root == nil {
		return
	}
	fmt.Println(root.Val)
	print(root.Left)
	print(root.Right)


}