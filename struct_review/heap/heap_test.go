package heap

import "testing"

func TestHeap_HeapSort(t *testing.T) {
	heap := NewHeap(32)

	heap.Insert(9)
	heap.Insert(6)
	heap.Insert(3)
	heap.Insert(1)
	heap.Insert(5)

	heap.HeapSort()
	heap.Print()
}

func TestStandardHeap(t *testing.T) {
	StandardHeap()
}