package binarytree

import "testing"

var compareFunc = func(val, nodeVal interface{}) int {
	valInt := val.(int)
	nodeValInt := nodeVal.(int)

	if valInt > nodeValInt {
		return 1
	} else if valInt < nodeValInt {
		return -1
	} else {
		return 0
	}
}

func TestBST_Find(t *testing.T) {
	bst := NewBST(1, compareFunc)

	bst.Insert(3)
	bst.Insert(1)
	bst.Insert(2)
	bst.Insert(7)
	bst.Insert(5)

	t.Log(bst.Find(7))
}

func TestBST_Insert(t *testing.T) {
	bst := NewBST(1, compareFunc)

	bst.Insert(3)
	bst.Insert(1)
	bst.Insert(2)
	bst.Insert(7)
	bst.Insert(5)

	bst.InOrderTraverse()
}

func TestBST_Min(t *testing.T) {
	bst := NewBST(1, compareFunc)

	bst.Insert(3)
	bst.Insert(1)
	bst.Insert(2)
	bst.Insert(7)
	bst.Insert(5)

	t.Log(bst.Min(bst.root))
}

func TestBST_Max(t *testing.T) {
	bst := NewBST(1, compareFunc)

	bst.Insert(3)
	bst.Insert(1)
	bst.Insert(2)
	bst.Insert(7)
	bst.Insert(5)

	t.Log(bst.Max(bst.root))
}

func TestBST_DeleteA(t *testing.T) {
	bst := NewBST(1, compareFunc)

	bst.Insert(3)
	bst.Insert(2)
	bst.Insert(7)
	bst.Insert(5)

	t.Log(bst.Delete(7))

	bst.InOrderTraverse()
}

func TestBST_DeleteB(t *testing.T) {
	bst := NewBST(1, compareFunc)

	t.Log(bst.Delete(1))
	t.Log(bst.root)

	bst.InOrderTraverse()
}

func TestBST_DeleteC(t *testing.T) {
	bst := NewBST(1, compareFunc)

	bst.Insert(3)
	bst.Insert(2)
	bst.Insert(7)
	bst.Insert(5)

	t.Log(bst.Delete(1))

	bst.InOrderTraverse()
}

func TestBST_DeleteD(t *testing.T) {
	bst := NewBST(1, compareFunc)

	bst.Insert(3)
	bst.Insert(2)
	bst.Insert(5)

	t.Log(bst.Delete(1))

	bst.InOrderTraverse()
}
func TestBST_DeleteE(t *testing.T) {
	bst := NewBST(5, compareFunc)

	bst.Insert(3)
	bst.Insert(2)
	bst.Insert(4)
	bst.Insert(1)

	t.Log(bst.Delete(5))
	bst.InOrderTraverse()
}

func TestBST_DeleteF(t *testing.T) {
	bst := NewBST(5, compareFunc)

	bst.Insert(3)
	bst.Insert(2)
	bst.Insert(4)
	bst.Insert(1)

	t.Log(bst.Delete(2))
	bst.InOrderTraverse()
}

func TestBST_DeleteG(t *testing.T) {
	bst := NewBST(5, compareFunc)

	bst.Insert(3)
	bst.Insert(2)
	bst.Insert(4)
	bst.Insert(1)

	t.Log(bst.Delete(1))
	bst.InOrderTraverse()
}