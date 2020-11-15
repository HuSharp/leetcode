/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-15 14:40:51
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-15 14:41:19
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    // 普通版本
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if(l1 == null ) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }
        while(l1 != null) {
            l3.next = l1;
            l3 = l3.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            l3.next = l2;
            l3 = l3.next;
            l2 = l2.next;
        }

        return head.next;
    }
    // 递归版本
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; 
    }
}