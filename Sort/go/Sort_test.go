package sort

import (
	"fmt"
	"math/rand"
	"testing"
	"time"
)

func TestBubbleSort(t *testing.T) {
	arr := []int{1,5,9,6,3,7,5,10}
	fmt.Println("排序前：",arr)
	BubbleSort(arr, len(arr))
	fmt.Println("排序后：",arr)
}

func TestSelectionSort(t *testing.T) {
	arr := []int{1,5,9,6,3,7,5,10}
	fmt.Println("排序前：",arr)
	SelectionSort(arr, len(arr))
	fmt.Println("排序后：",arr)
}

func TestInsertionSort(t *testing.T) {
	arr := []int{1,5,9,6,3,7,5,10}
	fmt.Println("排序前：",arr)
	InsertionSort(arr, len(arr))
	fmt.Println("排序后：",arr)
}

func TestMergeSort(t *testing.T) {
	arr := []int{1,5,9,6,3,7,5,10}
	fmt.Println("排序前：",arr)
	MergeSort(arr)
	fmt.Println("排序后：",arr)
}

func TestQuickSort(t *testing.T) {
	arr := []int{1,5,9,6,3,7,5,10}
	fmt.Println("排序前：",arr)
	QuickSort(arr)
	fmt.Println("排序后：",arr)
}

func TestSelectionSort2(t *testing.T) {
	left, right := 0, 10
	mapNum := make([]int, 20)
	for i := 0; i < 10000; i++ {
		rand.Seed(time.Now().UnixNano())	// 为伪随机
		swapPosition := rand.Intn(right-left+1)
		mapNum[swapPosition] = 1
	}
	fmt.Println(mapNum)
}

func TestBucketSort(t *testing.T) {
	a := []int{1,6,3,5,8,6,4}
	BucketSort(a)
	t.Log(a)
}

func TestCountingSort(t *testing.T) {
	arr := []int{5, 4}
	CountingSort(arr)
	t.Log(arr)

	arr = []int{5, 4, 3, 2, 1}
	CountingSort(arr)
	t.Log(arr)
}