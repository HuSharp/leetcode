package queue

import "fmt"

type ArrayQueue struct {
	q []interface{}
	capacity int
	head int
	tail int
}

func NewArrayQueue(n int) *ArrayQueue {
	return &ArrayQueue{
		q:        make([]interface{}, n),
		capacity: n,
		head:     0,
		tail:     0,
	}
}

func (queue *ArrayQueue) EnQueue(val interface{}) bool {
	if queue.tail == queue.capacity {
		// 此时判断是否需要进行数据搬移
		if queue.head == 0 {// 此时说明数据已经占满了
			return false
		}
		// 进行搬移
		for i := queue.head; i < queue.tail; i++ {
			queue.q[i-queue.head] = queue.q[i]
		}
		// 更新一下两个指针
		queue.head, queue.tail = 0, queue.tail-queue.head
	}
	queue.q[queue.tail] = val
	queue.tail++
	return true
}

func (queue *ArrayQueue) DeQueue() interface{} {
	if queue.head == queue.tail {
		return nil
	}
	val := queue.q[queue.head]
	queue.head++
	return val
}

func (queue *ArrayQueue) String() string {
	if queue.head == queue.tail {
		return "empty queue"
	}
	result := "head"
	for i := queue.head; i <= queue.tail-1; i++ {
		result += fmt.Sprintf("->%+v", queue.q[i])
	}
	result += "->tail"
	return result
}
