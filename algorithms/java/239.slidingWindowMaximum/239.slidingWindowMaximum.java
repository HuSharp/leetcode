import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-03 20:58:39
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-03 21:56:02
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    // 大顶堆法， 超过时间限制 
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        
        if (k > nums.length || k < 1){
            return new int[nums.length];
        }

        int[] ret = new int[nums.length - k + 1];
        // 大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(new maxComp());
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        ret[0] = heap.peek();


        int l = 0;
        int r = k;
        for (; r < nums.length; l++, r++) {
            heap.remove(nums[l]);// 移除左边
            heap.add(nums[r]);
            ret[l+1] = heap.peek();
        }
        return ret;
    }

    private class maxComp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
			return null;
		}
        LinkedList<Integer> qMax = new LinkedList<>();
        
        // 进行移动
        // 存入下标， 当大于
        // 从左至右 递减
        // 1、为空时，直接加入
        // 2、最右值比当前值大时，加入， 否则进行 popLast 直到为空或
        // 3、当窗口左边到达最左值时，进行pop出左值即可
    
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        for (int right = 0; right < nums.length; right++) {

            // 还未形成窗口
            // = 时， 为什么也要 pop? 
            // 因为后面来的数字不仅比前面的数字大，还比前面的数字后删除
            // （窗口 L 的移动是从左到右），
            // 因此前面被删除的数字已经没有机会再成为最大值了，删除即可。
            while(!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[right]) {
                qMax.pollLast();
            }
            qMax.addLast(right);
            // 判断是否有效
            if(qMax.peekFirst() == right-k) {
                qMax.pollFirst();
            }

            if(right >= k-1) {//开始形成窗口
                res[index++] = nums[qMax.peekFirst()];
            }
        }

        return res;
    }
}
// @lc code=end

