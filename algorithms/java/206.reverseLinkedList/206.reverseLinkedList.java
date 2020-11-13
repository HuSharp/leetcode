/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-13 10:43:40
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-13 11:08:47
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = head.next;
        
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end
