/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-07-07 12:06:09
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-10 22:52:09
 * @@Email: 8211180515@csu.edu.cn
 */
package Sort;

public class bubbleSorter {
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		boolean flag = false;// 标志此时是否还有排序
		for (int end = arr.length - 1; end > 0; end--) {
			flag = false;
			for (int i = 0; i < end; i++)
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					flag = true;
				}
			if (!flag)
				break;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 5, 3, 4, 5, 21, 7, 32, 9, 10 };
		bubbleSort(A);
		printArr(A);
	}

	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
