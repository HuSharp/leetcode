import java.util.HashSet;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-17 23:02:11
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-19 20:07:34
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    // 采用 Set 思想
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;

        HashSet<ListNode> set = new HashSet<>();
        while(curA != null) {
            set.add(curA);
            curA = curA.next;
        }
        while(curB != null) {
            if(set.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
        
    }


    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        // 先消除 A 和 B 的长度差， 然后让 长的 先走 长度差步
        // 可以转换为 先让长短一起走， 当短的走到头时， 再让短的指向长的头结点
        // 继续走， 当长的走到头时， 此时 短的现位置即为让长的先走的长度差步
        if(headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        } // 至此 得到短的路径长度
        boolean longIsA = false;
        if(curA != null) {//A 为长
            longIsA = true;
            curB = headA;
        } else {// B 为长
            curA = headB;
        }
        if(longIsA) {
            while(curA != null) {
                curA = curA.next;
                curB = curB.next;
            }// 至此， curB 指向 A 的开始点
            curA = headB;
            while(curA != curB && curA != null) {
                curA = curA.next;
                curB = curB.next;
            }
            if(curA == null) {
                return null;
            } else {
                return curA;
            }
        } else {
            while(curB != null) {
                curB = curB.next;
                curA = curA.next;
            }// 至此， curA 指向 B的开始点
            curB = headA;
            while(curB != curA && curB != null) {
                curA = curA.next;
                curB = curB.next;
            }
            if(curB == null) {
                return null;
            } else {
                return curB;
            }
        }
    }
    // 记录长度版本
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode cur1 = headA;
        ListNode cur2 = headB;

        int len = 0;
        while(cur1 != null) {
            cur1 = cur1.next;
            len++;
        }
        while(cur2 != null) {
            cur2 = cur2.next;
            len--;
        }// 至此 得到长度差值
        if (cur1 != cur2) { //说明不相交
            return null; 
        }
        cur1 = len > 0 ? headA : headB;
        cur2 = len <= 0 ? headA : headB;
        len = Math.abs(len);
        while(len != 0) {// 让长的遍历到结尾
            cur1 = cur1.next;
            len--;
        }
        while(cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;// 相等就返回该节点， 不等就返回 null
        
    }

    
}
// @lc code=end


public class ListNode {
    int val;
    ListNode next;
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}