package heap

import "fmt"

/*
堆排序分为两步
1.建堆
	建堆分为两个思路：
		1. 从下而上，从 1-n 插入 n 个数据
		2. 从上而下。因此只用关注非叶子节点
2.排序
	由于现在是大顶堆，因此每次取堆顶，放到下标为 n 的位置
	然后对剩下 n-1 进行重新构建成堆
 */

// build a heap
func (heap *Heap) buildHeap() {
	// heapify from the last parent node
	for i := heap.count/2; i >= 1; i-- {
		heap.heapifyUpToDown(i, heap.count)
	}
}

// HeapSort by ascend, a index begin from 1, has n elements
func (heap *Heap) HeapSort()  {
	heap.buildHeap()

	k := heap.count
	for k > 1 {
		// 然后相当于移除最大元素，进行自顶向下的堆化
		heap.a[k], heap.a[1] = heap.a[1], heap.a[k]
		k--
		heap.heapifyUpToDown(1, k)
	}
}


/*
	堆是一个完全二叉树；
	堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
	数组中下标为 i 的节点的
		左子节点，就是下标为 i∗2 的节点，
		右子节点就是下标为 i∗2+1 的节点，
		父节点就是下标为 i/2 的节点。
 */
type Heap struct {
	a  []int		// 数组，从下标 1 开始存储数据
	capacity int	// 堆可以存储的最大数据个数
	count int		// 堆中已经存储的数据个数
}

func NewHeap(capacity int) *Heap {
	heap := &Heap{
		a:        make([]int, capacity+1),
		capacity: capacity,
		count:    0,
	}
	return heap
}

//top-max heap -> heapify from down to up
func (heap *Heap) Insert(data int) {
	if heap.count == heap.capacity {
		return
	}
	heap.count++
	heap.a[heap.count] = data

	cur := heap.count
	parent := cur/2
	for parent > 0 && heap.a[parent] < heap.a[cur] {
		heap.a[parent], heap.a[cur] = heap.a[cur], heap.a[parent]
		cur = parent
		parent = cur/2
	}
}

// 交换 删除顶端节点和完全二叉树最后一个节点
func (heap *Heap) removeMax() {
	if heap.count == 0 {
		return
	}

	heap.a[1], heap.a[heap.count] = heap.a[heap.count], heap.a[1]
	heap.count--
	heap.heapifyUpToDown(1, heap.count)
}

// heapify from up to down，界限为下标 curPos 到 n 的位置
func (heap *Heap) heapifyUpToDown(curPos, n int) {
	for {
		maxIndex := curPos
		if curPos*2 <= n && heap.a[curPos] < heap.a[curPos*2] {
			maxIndex = curPos * 2
		}
		if curPos*2+1 <= n && heap.a[maxIndex] < heap.a[curPos*2+1] {
			maxIndex = curPos * 2 + 1
		}
		if maxIndex == curPos {
			break
		}
		heap.a[curPos], heap.a[maxIndex] = heap.a[maxIndex], heap.a[curPos]
		curPos = maxIndex
	}
}

func (heap *Heap) Print() {
	format := ""
	for i := 1; i <= heap.count; i++ {
		format += fmt.Sprintf("%+v ", heap.a[i])
	}
	fmt.Println(format)
}