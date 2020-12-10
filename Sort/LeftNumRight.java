package Sort;

public class LeftNumRight {
	
	public static void Sort(int[] arr, int num, int L, int R) {
		int i = L-1;//小于num位置
		int j = R+1;//大于num位置
		int pos = 0;//指示当前位置
		while(pos < j) {
			if(arr[pos] < num) {// 将小于num的值交换到小于区域的右边一个
				swap(arr, pos++, ++i);
			}else if(arr[pos] > num) {
				swap(arr, pos, --j);//此处pos不用移动，是因为交换过来的是待定区内容，不一定比它小
			}else {
				pos++;
			}
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
}
