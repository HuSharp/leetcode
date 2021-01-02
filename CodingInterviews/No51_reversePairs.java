/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-10 23:57:58
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-31 12:02:46
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No51_reversePairs {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }

        int res = mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private int mergeSort(int[] nums, int l, int r) {
        if(l == r) {
            return 0;
        }

        int mid = ((r - l) >> 1) + l;
        return mergeSort(nums, l, mid) 
            + mergeSort(nums, mid+1, r) 
            + mergeNum(nums, l, mid, r);
    }

    private int mergeNum(int[] nums, int l, int mid, int r) {
        int[] mergeHelp = new int[r - l + 1];
        int i = l;
        int j = mid+1;

        int pos = 0;
        int resSum = 0;
        while(i <= mid && j <= r) {
            resSum += nums[i] > nums[j] ? (mid - i+1) : 0;
            mergeHelp[pos++] = nums[i] <= nums[j] 
                                ? nums[i++] 
                                : nums[j++];
        }

        while(i<=mid) {
			mergeHelp[pos++] = nums[i++];
		}
		while(j<=r) { 
			mergeHelp[pos++] = nums[j++];
        }
        
        // 至此 排序完成
        for (int k = 0; k < mergeHelp.length; k++) {
            nums[l+k] = mergeHelp[k];
        }
        return resSum;
    }
}
