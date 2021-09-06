package sort

import (
	"math/rand"
	"time"
)

func QuickSort(arr []int)  {
	if arr == nil || len(arr) < 2 {
		return
	}
	quickSort(arr, 0, len(arr)-1)
}

func quickSort(arr []int, left, right int)  {
	if left >= right {
		return
	}
	// 将首个数字进行 swap
	rand.Seed(time.Now().Unix())	// 为伪随机
	swapPosition := rand.Intn(right-left+1)
	arr[left], arr[left+swapPosition] = arr[left+swapPosition], arr[left]
	
	// 得到 partition 位置
	p := partition(arr, left, right)
	quickSort(arr, left, p[0]-1)
	quickSort(arr, p[1]+1, right)
}

func partition(arr []int, left, right int) []int {
	// 最左侧为 pivot
	i, j := left, right+1
	pos := left + 1	// 指示当前位置
	for pos < j {
		if arr[pos] < arr[left] {
			i++
			arr[pos], arr[i] = arr[i], arr[pos]
			pos++
		} else if arr[pos] > arr[left] {
			j--	// 注意此时 pos 不动，因为不一定比 arr[left] 小
			arr[j], arr[pos] = arr[pos], arr[j]
		} else {	// 说明相等
			pos++
		}
	}
	arr[i], arr[left] = arr[left], arr[i]	// 交换到等于区
	return []int{i, j-1}
}