package sort


// 桶排序
func BucketSort(a []int)  {
	if len(a) <= 1 {
		return
	}
	max := getMax(a)
	buckets := make([][]int, len(a))

	for i := 0; i < len(a); i++ {
		index := a[i] * (len(a)-1)	/ max	// 均分到桶中
		buckets[index] = append(buckets[index], a[i])
	}
	tempPos := 0
	// 对每个桶进行快排
	for i := 0; i < len(a); i++ {
		QuickSort(buckets[i])
		copy(a[tempPos:], buckets[i])
		tempPos += len(buckets[i])
	}
}

// 获取待排序数组中的最大值
func getMax(a []int) int {
	max := a[0]
	for i := 0; i < len(a); i++ {
		if a[i] > max {
			max = a[i]
		}
	}
	return max
}

// 桶排序的简单实现
func BucketSortSimple(arr []int)  {
	if len(arr) <= 1 {
		return
	}
	// 构成一个长度为最大值的数组
	buckets := make([]int, len(arr)+1)
	for i := 0; i < len(arr); i++ {
		buckets[arr[i]]++
	}
	c := make([]int,0)
	for i:=0; i<len(buckets); i++{
		for buckets[i] != 0 {
			c = append(c, i)
			buckets[i]--
		}
	}
	copy(arr, c)
}