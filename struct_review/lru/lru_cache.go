package lru

import "fmt"

const (
	hostbit = uint64(^uint(0)) == ^uint64(0)
	LENGTH = 100
)

// 引入散列表（Hash table）来记录每个数据的位置，将缓存访问的时间复杂度降到 O(1)
type lruNode struct {
	prev *lruNode
	next *lruNode

	key int
	val int

	// hnext 指针是为了将结点串在散列表的拉链中。
	hnext *lruNode
}

// 采用 双向链表存取数据，散列表方便查询位置
type LRUCache struct {
	node []lruNode	// hash list

	head *lruNode
	tail *lruNode

	capacity int
	used int
}

// 头结点为指示节点
func Constructor(capacity int) LRUCache {
	cache := LRUCache{
		node:     make([]lruNode, LENGTH),
		head:     nil,
		tail:     nil,
		capacity: capacity,
		used:     0,
	}
	cache.head = &lruNode{
		prev:  nil,
		next:  cache.tail,
	}
	return cache
}


// get
func (lru *LRUCache) Get(key int) int {
	if lru.tail == nil {
		return -1
	}
	if node := lru.searchNode(key); node != nil {
		// 找到了 便移动到最前面
		lru.moveToHead(node)
		return node.val
	}
	return -1
}

func (lru *LRUCache) Put(key, val int) {
	// 1. 首次插入数据
	// 2. 插入数据不在 LRU 中
	// 3. 插入数据在 LRU 中
	// 4. 插入数据不在 LRU 中, 并且 LRU 已满
	if node := lru.searchNode(key); node != nil {
		// 找到了 便提高频率
		node.val = val
		fmt.Println("[Put] find: ", node.val)
		lru.moveToHead(node)
		return
	}
	// 不在 LRU
	lru.addNode(key, val)
	// 已满
	if lru.used > lru.capacity {
		lru.delNode()
	}
}

func (lru *LRUCache) addNode(key, val int) {
	newNode := &lruNode{
		key:   key,
		val:   val,
	}
	// 加入散列表的拉链中， 拉链并不采用lru
	hashPrevHead := &lru.node[hash(key)]
	for hashPrevHead.hnext != nil {
		hashPrevHead = hashPrevHead.hnext
	}
	hashPrevHead.hnext = newNode
	// 加入双向链表中
	lru.moveToHead(newNode)

	lru.used++
}

func (lru *LRUCache) delNode() {
	if lru.head == nil {
		return
	}
	// 需要删除最远的, 尾结点指向的就是最远的
	needDelNode := lru.tail.prev
	// 需要将其在双向链表和拉链中都删除
	needDelNode.prev.next = lru.tail
	lru.tail.prev = needDelNode.prev

	hashPrevHead := &lru.node[hash(needDelNode.key)]
	for hashPrevHead.hnext != nil {
		if hashPrevHead.hnext.key == needDelNode.key {
			break
		}
		hashPrevHead = hashPrevHead.hnext
	}
	hashPrevHead.hnext = needDelNode.hnext

	lru.used--
}

// 头指针
func (lru *LRUCache) moveToHead(node *lruNode)  {
	if lru.head.next == node {
		return
	}
	if lru.IsEmpty() {
		// 说明双向链表为空
		lru.head.next = node
		lru.tail = &lruNode{
			prev:  node,
			next:  nil,
		}
		node.next = lru.tail
		node.prev = lru.head
	} else {
		// 删掉之前的位置，做判断是因为：可能是新节点没有前置后置
		if node.prev != nil && node.next != nil {
			node.prev.next = node.next
			node.next.prev = node.prev
		}
		// 移到头结点后面
		lru.head.next.prev = node
		node.next = lru.head.next
		lru.head.next = node
		node.prev = lru.head

	}
}

func (lru *LRUCache) searchNode(key int) *lruNode {
	if lru.head == nil {
		return nil
	}
	// search
	temp := lru.node[hash(key)].hnext
	for temp != nil {
		if temp.key == key {
			return temp
		}
		temp = temp.next
	}
	return nil
}

func hash(key int) int {
	// 两个问题
	// 1. 扰动函数 2. 低位掩码
	// 扰动函数是为了：由于之后的低位掩码会把高位干掉
	// 高位和低位进行^位运算。这样不管是高位发生变化，还是低位发生变化都会造成其结果的中低位发生变化
	// 相当于一个“低位掩码”。
	// “与”操作的结果就是散列值的高位全部归零，只保留低位值，用来做数组下标访问
	// https://www.zhihu.com/question/20733617
	if hostbit {
		return (key ^ (key >> 32)) & (LENGTH - 1)
	} else {
		return (key ^ (key >> 16)) & (LENGTH - 1)
	}
}

func (lru *LRUCache) IsEmpty() bool {
	if lru.tail == lru.head.next {
		return true
	}
	return false
}

func (lru *LRUCache) PrintList() {
	format := ""
	if lru.IsEmpty() {
		fmt.Println("empty lru")
	} else {
		cur := lru.head.next
		for cur != lru.tail {
			format += fmt.Sprintf("[%+v, %+v] ", cur.key, cur.val)
			cur = cur.next
		}
	}
	fmt.Println(format)
}

func (lru *LRUCache) PrintHashList(key int) {
	format := fmt.Sprintf("key[%+v]'s hashList:", key)
	if lru.IsEmpty() {
		fmt.Println("empty lru")
	} else {
		node := lru.node[hash(key)].hnext
		for node != nil {
			format += fmt.Sprintf("[%+v, %+v] ", node.key, node.val)
			node = node.hnext
		}
	}
	fmt.Println(format)
}