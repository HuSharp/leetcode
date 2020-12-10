/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-07-11 12:56:59
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-02 18:36:07
 * @@Email: 8211180515@csu.edu.cn
 */
package Sort;

public class heapSorter {
	public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // 构成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        // 现在开始排序
        // 将大根堆的堆顶与最后一个数进行交换，然后再 heapSize-1, 并将前面的 heapify 调整成大根堆
        // 循环操作即可
        for (int i = arr.length-1; i >= 0; i--) {
            swap(arr, i, 0);// 交换
            heapify(arr, 0, i-1);
        }

	}
	
	public static void heapInsert(int[] arr, int index) {
		while(arr[index] > arr[(index-1)/2]) {//和父亲比
			swap(arr, index, (index-1)/2);
			index = (index-1)/2;
		}
	}
	
	// heapSize表示界 选出 index节点 与 其孩子最大值
	public static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		while(left < heapSize) {
			// 选出 儿子 最大值
			int largest = left + 1 < heapSize && arr[left] < arr[left+1]
					?  left +1 
					: left;
			// 和当前index 进行判断
			largest = arr[largest] > arr[index] ? largest : index;
			if(largest == index)
				break;//说明已经下降到最低点了
			swap(arr, index, largest);
			index = largest;
			left = index * 2 + 1;
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
