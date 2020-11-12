import java.util.LinkedList;
import java.util.Queue;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-12 19:05:49
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-12 19:12:29
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start
class MyStack {
    private Queue<Integer> master = null;
    private Queue<Integer> slave = null;

    /** Initialize your data structure here. */
    public MyStack() {
        master = new LinkedList<>();
        slave = new LinkedList<>();
    }
    
    
    /** Push element x onto stack. */
    public void push(int x) {
        master.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(master.size() != 1) {
            slave.add(master.poll());
        }
        int res = master.poll();
        swap();
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        while(master.size() != 1) {
            slave.add(master.poll());
        }
        int res = master.poll();
        swap();
        master.add(res);
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return master.isEmpty() && slave.isEmpty();
    }

    private void swap() {
        Queue<Integer> tmp = master;
        master = slave;
        slave = tmp;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

