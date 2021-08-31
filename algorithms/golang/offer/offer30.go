package offer

import "math"

type MinStack struct {
	s stack
	minStack stack
}


/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{
		minStack: stack{math.MaxInt64},		// 需要加上最初的数
	}
}


func (this *MinStack) Push(x int)  {
	this.s.push(x)
	top := this.minStack.peek()
	this.minStack.push(min(top, x))
}


func (this *MinStack) Pop()  {
	this.s.pop()
	this.minStack.pop()
}


func (this *MinStack) Top() int {
	return this.s.peek()
}


func (this *MinStack) Min() int {
	return this.minStack.peek()
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Min();
 */
