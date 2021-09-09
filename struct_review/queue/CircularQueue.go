package queue

// 循环队列 需要注意的是：确定好队空和队满的判定条件。
type CircularQueue struct {
	q []interface{}
	capacity int
	head int
	tail int
}

func NewCircularQueue(num int) *CircularQueue {
	if num == 0 {
		return nil
	}
	return &CircularQueue{}
}


