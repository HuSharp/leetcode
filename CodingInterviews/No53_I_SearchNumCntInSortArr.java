/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-12 09:27:42
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-12 10:06:25
 * @@Email: 8211180515@csu.edu.cn
 */

package CodingInterviews;

public class No53_I_SearchNumCntInSortArr {
    // 二分查找找到点， 然后左右遍历找
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if(0 == r) {
            if(nums[0] == target) {
                return 1;
            }
        }

        int mid;
        while(l <= r) {
            mid = ((r - l) >> 1) + l;
            if(nums[mid] == target) {// 说明找到了， 那么便进行遍历
                int cnt = 1;
                for (int i = mid; i > 0; i--) {
                    if(nums[i] != nums[i-1]) {
                        break;
                    }
                    cnt++;
                }
                for (int i = mid; i < nums.length - 1; i++) {
                    if(nums[i] != nums[i+1]) {
                        break;
                    }
                    cnt++;
                }
                return cnt;
            } else if(nums[mid] < target) {// 说明在右区间
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return 0;
    }

    // 还可以采用 每次找到相等点中最左侧的点
    public int search_2(int[] nums, int target) {
        int targetLeft = binarySearch(nums, 0, nums.length-1, target);
        int targetRight = binarySearch(nums, 0, nums.length-1, target+1);

        return targetRight - targetLeft;
    }

    // 此二分目标是找到该点的最左侧的点
    private int binarySearch(int[] nums, int l, int r, int target) {

        int mid;
        while(l <= r) {
            mid = ((r - l) >> 1) + l;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid - 1] != target ) {
                    return mid;
                }
                r = mid - 1;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
}

