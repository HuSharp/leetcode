package stack_impl

import "fmt"

// 利用栈， 实现浏览器的前进和后退
type Browser struct {
	forwardStack Stack
	backStack Stack
}

func NewBrowser() *Browser {
	return &Browser{
		forwardStack: NewArrayStack(32),
		backStack:    NewLinkedListStack(),
	}
}

func (browser *Browser) CanForward() bool {
	if browser.forwardStack.IsEmpty() {
		fmt.Printf("forward falied. forward stack is empty.\n")
		return false
	}
	return true
}

func (browser *Browser) CanBack() bool {
	if browser.backStack.IsEmpty() {
		fmt.Printf("back falied. back stack is empty.\n")
		return false
	}
	return true
}

func (browser *Browser) PushBack(addr string) {
	browser.backStack.Push(addr)
}

func (browser *Browser) Open(addr string) {
	browser.PushBack(addr)
	fmt.Printf("open new addr %+v\n", addr)
	browser.forwardStack.Flush()
}

func (browser *Browser) Forward() {
	if !browser.CanForward() {
		return
	}
	top := browser.forwardStack.Pop()
	browser.backStack.Push(top)
	fmt.Printf("forward to %+v\n", top)
}

func (browser *Browser) Back() {
	if !browser.CanBack() {
		return
	}
	top := browser.backStack.Pop()
	browser.forwardStack.Push(top)
	fmt.Printf("back to %+v\n", top)
}





