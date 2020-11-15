/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-15 16:34:09
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-15 18:31:15
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n || head == null) {
            return head;
        }
        ListNode headFirst = new ListNode(0);// 头结点
        headFirst.next = head;

        // head = pre;
        ListNode leftNode = headFirst;
        // n -= m;// 记录长度

        // 移动 m-1 步到反转的前一个
        int cnt = 1;
        for (; cnt < m; cnt++) {
            leftNode = leftNode.next;
        } // 至此 leftNode 指向交换的前一个 cnt = m

        head = leftNode.next;
        ListNode reHead = head;
        ListNode next = head;
        ListNode pre = null;

        for (; cnt <= n; cnt++) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        // 至此 已经到达 head 交换点右侧 , pre 指向 m 处点
        leftNode.next = pre;
        reHead.next = next;

        return headFirst.next;
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

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}