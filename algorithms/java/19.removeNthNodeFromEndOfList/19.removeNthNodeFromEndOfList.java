/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-13 11:03:47
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-22 23:13:56
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        // 让 fast 指针先移动 n 步， 然后让 slow 指针 和 fast 一起移动
        ListNode pre = new ListNode(0);// 为啥不直接返回 head？因为可能被删除
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre;
        
        while(n != 0) {
            fast = fast.next;
            n--;
        }

        while(fast.next != null) {// 找到头
            fast = fast.next;
            slow = slow.next;
        }// 至此 到底
        slow.next = slow.next.next;
        return pre.next;
    }

    // 运用快慢链表
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode fast = pre;
        ListNode slow = pre;

        // 先走 n 步
        while(n != 0) {
            fast = fast.next;
            n--;
        }

        // 现在再让快慢指针一起运动
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return pre.next;
    }
    
}
// @lc code=end


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}