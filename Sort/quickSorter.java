package Sort;

public class quickSorter {
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;

		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			int[] p = partition(arr, l, r);// p[0]是第一个位置
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}

	// 最右侧为pivot
	public static int[] partition(int[] arr, int l, int r) {
		int i = l - 1;
		int j = r;
		int pos = l;// 指示当前位置
		while (pos < j) {
			if (arr[pos] < arr[r]) {
				swap(arr, pos++, ++i);
			} else if (arr[pos] > arr[r]) {
				swap(arr, pos, --j);
			} else {
				pos++;
			}
		}
		swap(arr, j, r);// 交换pivot到等于区域

		// 返回等于范围
		return new int[] { i + 1, j };
	}

	// 最左侧为 pivot
	public static int[] partition_l(int[] arr, int l, int r) {
		int i = l;
		int j = r ;
		int pos = l+1;// 指示当前位置
		while (pos < j) {
			if(arr[pos] < arr[l]) {
				swap(arr, pos++, ++i);
			} else if(arr[pos] > arr[l]){
				swap(arr, pos, --j);
			} else {
				pos++;
			}
		}
		swap(arr, j, l);
		return new int[] {i+1, j};
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 20, 15, 14, 18, 21, 36, 40, 10 };
		quickSort(arr);
		System.out.println();

	}

}
