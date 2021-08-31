package offer

type stack []int

func (s *stack) push(val int) {
	*s = append(*s, val)
}

func (s *stack) pop() int {
	n := len(*s)
	res := (*s)[n-1]
	*s = (*s)[:n-1]
	return res
}

func (s *stack) peek() int {
	return (*s)[len(*s)-1]
}


type CQueue struct {
	in stack
	out stack
}


func Constructor() CQueue {
	return CQueue{}
}


func (this *CQueue) AppendTail(value int)  {
	this.in.push(value)
}


func (this *CQueue) DeleteHead() int {
	if len(this.out) != 0 {
		return this.out.pop()
	} else if len(this.in) != 0 {
		for len(this.in) != 0 {
			this.out.push(this.in.pop())
		}
		return this.out.pop()
	}
	return -1
}


/**
 * Your CQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AppendTail(value);
 * param_2 := obj.DeleteHead();
 */