package Sort;

public class MaxGap {
	public static int maxGap(int[] arr) {
		if(arr == null || arr.length < 2){
			return 0;
		}
		
		int len = arr.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		if(min == max)
			return 0;
		
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];
		int[] mins = new int[len + 1]; 
		
		int nowBucket = 0;
		for (int i = 0; i < len; i++) {
			nowBucket = bucket(arr[i], len, min, max);
			maxs[nowBucket] = hasNum[i] ? Math.max(arr[i], maxs[nowBucket]) : arr[i];
			mins[nowBucket] = hasNum[i] ? Math.min(arr[i], maxs[nowBucket]) : arr[i];
			hasNum[nowBucket] = true;
		}
		
		int res = 0;
		int lastMax = maxs[0];//初始为前一个的最小值
		for (int i = 1; i <= len; i++) {
			if(hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		
		return res;
	}
	
	// 知道该数来自哪个桶
	public static int bucket(int num, int len, int min, int max) {
		return ((num-min)*len / (max-min));
	}
	
}
