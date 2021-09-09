package sort

// 插入排序
// 插入到合适位置
func InsertionSort(a []int, n int) {
	if n <= 1 {
		return
	}
	for i := 1; i < n; i++ {
		value := a[i]
		// 查找要插入的位置并移动数据，
		j := i-1
		for ; j >= 0; j-- {
			if a[j]	> value {
				a[j+1] = a[j]
			} else {
				break
			}
		}
		a[j+1] = value
	}
}
