package Sort;

public class smallNumValue {
	public static int mergeBegin(int[] arr) {
		if(arr == null || arr.length < 2)
			return -1;
		
		int res = smallNumSum(arr, 0, arr.length-1);
		return res;
	}
	
	public static int smallNumSum(int[] arr, int L, int R) {
		if(L == R)
			return 0;
		
		int mid = ((R-L)>>1) + L;//取中点
		
		return smallNumSum(arr, L, mid) + 
				smallNumSum(arr, mid+1, R) + 
				mergeNum(arr, L, mid, R);
	}
	
	public static int mergeNum(int[] arr, int l, int mid, int r) {
		int[] mergeHelp = new int[r-l+1];
		int i = l, j = mid+1;
		int pos = 0;//指示辅助数组的位置
		int res = 0;
		while(i<=mid && j<=r) {
			res += arr[i]<arr[j] ? arr[i]*(r-j+1) : 0;
			mergeHelp[pos++] = arr[i]<arr[j]?arr[i++]:arr[j++];//选小值
		}
		
		while(i<=mid) {
			mergeHelp[pos++] = arr[i++];
		}
		while(j<=r) {
			mergeHelp[pos++] = arr[j++];
		}
		//现已排好序
		for (int k = 0; k < mergeHelp.length; k++) {
			arr[l+k] = mergeHelp[k];
		}
		return res;
		
	}
}
