/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-13 11:48:55
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-01-23 11:08:26
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */ 

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return null;
        }
        ListNode l3 = new ListNode(0);
        ListNode sum = l3;// 保存头结点
        int add = 0;
        // 直接加到底， 没有就补 0 
        while(l1 != null || l2 != null) {
            int x1 = l1 == null ? 0 : l1.val;
            int x2 = l2 == null ? 0 : l2.val;
            int lSum = x1 + x2 + add;

            add = lSum / 10;// 判断进位
            lSum %= 10;// 当前位

            l3.next = new ListNode(lSum);
            l3 = l3.next;
            
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // 对于 999 + 1 的情况，需要向前
        // 即最后一位需要进位
        if(add == 1) {
            l3.next = new ListNode(1);
        }
        return sum.next;
    }
}

// @lc code=end

