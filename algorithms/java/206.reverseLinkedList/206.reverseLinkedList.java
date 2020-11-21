/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-13 10:43:40
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-20 13:29:25
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
    // 非递归版本
    public ListNode reverseList_Iter(ListNode head) {
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

    // 递归版本
    public ListNode reverseList_Recur(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;// 现在对 head 后面的点进行反转
         // 理解为返回的是已经反转过的部分的头指针
        ListNode reHeadNode = reverseList_Recur(next);// 对 next 进行反转
        // 至此反转完成， 需要 next 指针指向 head
        next.next = head;
        head.next = null;// head 加入到反转部分
        return reHeadNode;//返回反转部分的头指针
    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}