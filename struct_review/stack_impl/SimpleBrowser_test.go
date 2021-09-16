package stack_impl

import "testing"

func TestBrowser(t *testing.T) {
	b := NewBrowser()
	b.Open("www.qq.com")
	b.Open("www.baidu.com")
	b.Open("www.sina.com")
	if b.CanBack() {
		b.Back()
	}
	if b.CanForward() {
		b.Forward()
	}
	if b.CanBack() {
		b.Back()
	}
	if b.CanBack() {
		b.Back()
	}
	if b.CanBack() {
		b.Back()
	}
	b.Open("www.taobao.com")
	if b.CanForward() {
		b.Forward()
	}
}
