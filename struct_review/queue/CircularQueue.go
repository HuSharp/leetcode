package queue

import "fmt"

// 循环队列 需要注意的是：确定好队空和队满的判定条件。
// 数组实现 就不需要进行迁移
type CircularQueue struct {
	q []interface{}
	capacity int
	head int
	tail int
}

func NewCircularQueue(n int) *CircularQueue {
	if n == 0 {
		return nil
	}
	return &CircularQueue{
		q:        make([]interface{}, n),
		capacity: n,
		head:     0,
		tail:     0,
	}
}

// 队列为空的判断条件仍然是 head == tail
func (queue *CircularQueue) IsEmpty() bool {
	if queue.head == queue.tail {
		return true
	}
	return false
}

// 队满时，(tail+1)%n=head
// 即 tail 是不存储数据的
func (queue *CircularQueue) IsFull() bool {
	if queue.head == (queue.tail+1)%queue.capacity {
		return true
	}
	return false
}

func (queue *CircularQueue) EnQueue(val interface{}) bool {
	if queue.IsFull() {
		return false
	}
	queue.q[queue.tail] = val
	queue.tail = (queue.tail+1) % queue.capacity
	return true
}

func (queue *CircularQueue) DeQueue() interface{} {
	if queue.IsEmpty() {
		return nil
	}
	val := queue.q[queue.head]
	queue.head = (queue.head+1) % queue.capacity
	return val
}

func (queue *CircularQueue) String() string {
	if queue.IsEmpty() {
		return "empty queue"
	}
	result := "head"
	var i = queue.head
	for {
		result += fmt.Sprintf("->%+v", queue.q[i])
		i = (i+1) % queue.capacity
		if i == queue.tail {
			break
		}
	}
	result += "<-tail"
	return result
}



