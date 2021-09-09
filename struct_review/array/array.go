package array

import (
	"errors"
	"fmt"
)

type Array struct {
	data []int
	length uint
}

// 为数组初始化内存
func NewArray(capacity uint) *Array {
	if capacity == 0 {
		return nil
	}
	return &Array{
		data:   make([]int, capacity, capacity),
		length: 0,
	}
}

func (arr *Array) Len() uint {
	return arr.length
}

// 判断索引是否越界
func (arr *Array) isIndexOutRange(index uint) bool {
	if index >= uint(cap(arr.data)) {
		return true
	}
	return false
}

// 通过索引查找数组，索引范围 [0, n-1]
func (arr *Array) Find(index uint) (int, error) {
	if arr.isIndexOutRange(index) {
		return 0, errors.New("out of index range")
	}
	return arr.data[index], nil
}

// 插入数值到索引 index
func (arr *Array) Insert(index uint, val int) error {
	if arr.Len() == uint(cap(arr.data)) {
		return errors.New("full array")
	}
	if index != arr.Len() && arr.isIndexOutRange(index) {
		return errors.New("out of range")
	}
	// 向后移
	for i := arr.Len(); i > index; i-- {
		arr.data[i] = arr.data[i-1]
	}
	arr.data[index] = val
	arr.length++
	return nil
}

func (arr *Array) InsertToTail(val int) error {
	return arr.Insert(arr.Len(), val)
}

// 删除
func (arr *Array) Delete(index uint) (int, error) {
	if arr.isIndexOutRange(index) {
		return 0, errors.New("out of range")
	}
	val := arr.data[index]
	for i := index; i < arr.Len() - 1; i++ {
		arr.data[i] = arr.data[i+1]
	}
	arr.length--
	return val, nil
}

//打印数列
func (this *Array) Print() {
	var format string
	for i := uint(0); i < this.Len(); i++ {
		format += fmt.Sprintf("[%+v] ", this.data[i])
	}
	fmt.Println(format)
}