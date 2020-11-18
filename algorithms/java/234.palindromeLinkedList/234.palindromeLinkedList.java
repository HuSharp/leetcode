import java.util.Deque;
import java.util.LinkedList;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-18 12:06:20
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-18 12:57:16
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    // public boolean isPalindrome(ListNode head) {
    //     // 新建一个链表， 将旧链表赋值到上面 
    //     // 进行翻转后判断, 
    //     if(head == null) {
    //         return false;
    //     }
    //     ListNode reHead = head;
    //     ListNode cur = head;
    //     ListNode reCur = reHead;
    //     while(cur != null) {
    //         reCur.next = cur;
    //         reCur = reCur.next;
    //         cur = cur.next;
    //     }
    //     reCur = reHead;// 再指向开头
    //     ListNode pre = reHead;
    //     ListNode next = reHead;
    //     while(reCur != null) {
    //         next = reCur.next;
    //         reCur.next = pre;
    //         pre = reCur;
    //         reCur = next;
    //     }// 至此， pre 已经指向最后一个
    //     // 因此开始同时遍历判断
    //     while(pre != null && head != null && pre == head  ) {
    //         pre = pre.next;
    //         head = head.next;
    //     }
    //     if(pre == null && head == null) {
    //         return true;
    //     }
    //     return false;
    // }

    // 全部压入到栈
    public boolean isPalindrome_1(ListNode head) {
        // 采用栈 
        // 进行翻转后判断, 
        if(head == null) {
            return true;
        }
        ListNode cur = head;
        Deque<Integer> stack = new LinkedList<>();
        while(cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        // 此时 stack 中逆序放置， 现在进行对比判断
        cur = head;
        while(!stack.isEmpty()) {
            if(stack.pop() != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
    
    // 快慢指针。 压入右半部分
    public boolean isPalindrome_2(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        Deque<Integer> stack = new LinkedList<>();
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }// 至此 slow 位于对称轴两侧或者对称轴上 
        // 压入右半部分后， 再与左半部分进行对比
        while(slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }// 至此 压入完
        fast = head;
        // 弹出栈中所有点，与左半部分进行对比
        while(!stack.isEmpty()) {
            if(stack.pop() != fast.val) {
                return false;
            }
            fast = fast.next;
        }
        return true;
    }

    // 法三， 将右半部分进行翻转
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }// 至此 slow 位于对称轴两侧或者对称轴上 
        // 进行翻转
        ListNode cur = slow;// slow 保存当前点
        ListNode pre = null;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }// 至此 pre 指向最后一个点， 
        // 开始从最后一个点开始读
        fast = head;
        cur = pre;
        boolean isTrue = true;
        // 此处是 fast 继续
        while(cur != null && fast != null) {
            if(cur.val != fast.val) {
                isTrue = false;
                break;
            }
            cur = cur.next;
            fast = fast.next;
        }
        // 进行恢复
        cur = pre;
        pre = null;
        while(cur != null) {
            // 此处是翻转
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        pre.next = fast;
        return isTrue;
    }
}
// @lc code=end


public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}