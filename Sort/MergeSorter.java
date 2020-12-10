/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-07-07 21:40:09
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-10 23:15:53
 * @@Email: 8211180515@csu.edu.cn
 */
package Sort;

public class MergeSorter {
	public static void mergeSortBegin(int[] arr) {
		if (arr == null || arr.length < 2)
			return;

		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int L, int R) {
		if (L == R)
			return;

		int mid = ((R - L) >> 1) + L;
		mergeSort(arr, L, mid);
		mergeSort(arr, mid + 1, R);

		merge(arr, L, mid, R);
	}

	private static void merge(int[] arr, int L, int mid, int R) {
		int[] mergeArr = new int[R - L + 1];
		int i = L;
		int j = mid + 1;

		int pos = 0;
		while (i <= mid && j <= R) {
			mergeArr[pos++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
		}

		// 最多有一个越界
		while (i <= mid) {
			mergeArr[pos++] = arr[i++];
		}
		while (j <= R) {
			mergeArr[pos++] = arr[j++];
		}
		for (pos = 0; pos < mergeArr.length; pos++) {
			arr[L + pos] = mergeArr[pos];
		}

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 20, 15, 14, 18, 21, 36, 40, 10 };
		mergeSortBegin(arr);
        printArr(arr);
    }
    
    private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
