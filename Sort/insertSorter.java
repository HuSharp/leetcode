/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-07-07 20:28:29
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-10 23:06:16
 * @@Email: 8211180515@csu.edu.cn
 */
package Sort;

public class insertSorter {
	public static void insertionSort(int[] arr) {
		if(arr == null || arr.length<2)
			return;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i-1; j >= 0 && arr[j+1]<arr[j]; j--) {
				swap(arr, j, j+1);
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}  
	
	
	public static void main(String[] args) {
		int[] A = new int[]{1, 5, 3, 4, 5, 21, 7, 32, 9, 10};
		insertionSort(A);
		printArr(A);
	}
	
	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
