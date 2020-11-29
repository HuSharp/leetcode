import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-29 19:53:36
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-29 22:06:45
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    // 法0 ： 暴力解法来保证验证正确
    public int findKthLargest_0(int[] nums, int k) {
        Arrays.sort(nums);// ascending
        return nums[nums.length - k];
    }


    // 法一 最小堆
    public int findKthLargest_1(int[] nums, int k) {
        // 默认为最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();  
        
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            queue.poll();
        }

        return queue.peek();
    }

    // 法二 利用快排的 partition
    public int findKthLargest(int[] nums, int k) {
        // 荷兰国旗问题解决
        // int[] lm = new int[2];
        int pos = 0;
        int left = 0;
        int right = nums.length-1;
        k = nums.length - k;
        while(true) {
            pos = partition(nums, left, right);// 得到两边边界  

            if(pos == k) {
                return nums[pos];
            } else if(pos > k) {
                right = pos -1;
            } else {
                left = pos + 1;
            }
        }
    }

    private int partition(int[] arr, int l, int r) {
        swap(arr, l + (int)(Math.random() * (r-l+1)), r);// 进行随机
        int cur = l;
        int less = l - 1;
        int more = r;
        int pos = arr[r];
        while(cur < more) {
            if(arr[cur] < pos) {// 
                swap(arr, ++less, cur++);
            } else if(arr[cur] > pos) {
                swap(arr, cur, --more);
            } else {// 相等
                cur++;
            }
        }// cur == more ， pivot 为 arr[l]
        swap(arr, r, cur);// 将 第一个 和 当前位置 交换归位。
        // 返回等于范围
        // return new int[]{less+1, more};
        return cur;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

// 堆的实现


}
// @lc code=end

