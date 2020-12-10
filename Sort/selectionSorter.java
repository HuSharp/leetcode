/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-07-07 13:05:17
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-10 22:56:13
 * @@Email: 8211180515@csu.edu.cn
 */
package Sort;

public class selectionSorter {

	public static void selectionSort(int[] arr) {
		if(arr == null || arr.length<2){
			return;
		}
		
		for (int i = 0; i < arr.length-1; i++) {
			int minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j:minIndex;
			}
			swap(arr, i, minIndex);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{1, 5, 3, 4, 5, 21, 7, 32, 9, 10};
		selectionSort(A);
		printArr(A);
	}
	
	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
