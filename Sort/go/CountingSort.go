package sort

import "math"

func CountingSort(a []int)  {
	if len(a) <= 1 {
		return
	}
	max := math.MinInt32
	for i := range a {
		if a[i] > max{
			max = a[i]
		}
	}
	// 构建桶
	buckets := make([]int, max+1)
	for i := range a {
		buckets[a[i]]++
	}
	// 转化为记录 buckets[k] 里存储小于等于分数 k 的元素个数
	for i := 1; i <= max; i++ {
		buckets[i] += buckets[i-1]
	}

	temp := make([]int, len(a))
	for i := len(a)-1; i >= 0; i-- {
		index := buckets[a[i]] - 1	// 取当前的元素需要放的位置
		temp[index] = a[i]
		buckets[a[i]]--				// 将 buckets[k] 里存储值减去当前元素值
	}
	copy(a, temp)
}
