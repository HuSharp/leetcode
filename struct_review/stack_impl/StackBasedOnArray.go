package stack_impl

import "fmt"

/*
基于数组实现栈
 */
type ArrayStack struct {
	data []interface{}
	top int
}

func NewArrayStack(n int) *ArrayStack {
	return &ArrayStack{
		data: make([]interface{}, 0, n),
		top:  -1,
	}
}

func (stack *ArrayStack) IsEmpty() bool {
	if stack.top < 0 {
		return true
	}
	return false
}

func (stack *ArrayStack) Push(val interface{}) {
	if stack.top < 0 {
		stack.top = 0
	} else {
		stack.top++
	}
	// 判断是否超界
	if stack.top > len(stack.data)-1 {
		stack.data = append(stack.data, val)
	} else {
		stack.data[stack.top] = val
	}
}

func (stack *ArrayStack) Pop() interface{} {
	if stack.IsEmpty() {
		return nil
	}
	val := stack.data[stack.top]
	stack.top -= 1
	return val
}

func (stack *ArrayStack) Top() interface{} {
	if stack.IsEmpty() {
		return nil
	}
	return stack.data[stack.top]
}

func (stack *ArrayStack) Flush() {
	stack.top = -1
}

func (stack *ArrayStack) Print() {
	format := ""
	if stack.IsEmpty() {
		fmt.Println("empty stack")
	} else {
		for i := stack.top; i >= 0; i-- {
			format += fmt.Sprintf("[%+v] ", stack.data[i])
		}
	}
	fmt.Println(format)
}
