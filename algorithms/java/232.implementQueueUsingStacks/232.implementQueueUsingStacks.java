import java.util.Stack;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-12 19:13:24
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-16 12:53:39
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {

    // 采用一个 master Stack 和 一个 Slave Stack
    Stack<Integer> pushStack = null;
    Stack<Integer> popStack = null;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        int res = pop();
        popStack.push(res);
        return res;
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    // 法二 采用一个作为压入栈， 一个作为弹出栈
    // 每次压入栈向弹出栈倾倒时， 全部倾倒， 且必须在 弹出栈为空时才能倾倒
    // Stack<Integer> pushStack = null;
    // Stack<Integer> popStack = null;

    // /** Initialize your data structure here. */
    // public MyQueue() {
    //     pushStack = new Stack<>();
    //     popStack = new Stack<>();
    // }
    
    // /** Push element x to the back of queue. */
    // public void push(int x) {
    //     pushStack.push(x);
    //     push2Pop();
    // }
    
    // /** Removes the element from in front of queue and returns that element. */
    // public int pop() {
    //     push2Pop();
    //     return popStack.pop();
    // }
    
    // /** Get the front element. */
    // public int peek() {
    //     push2Pop();
    //     return popStack.peek();
    // }
    
    // /** Returns whether the queue is empty. */
    // public boolean empty() {
    //     return (pushStack.isEmpty() && popStack.isEmpty()); 
    // }

    // // 倾倒函数
    // private void push2Pop() {
    //     if(popStack.isEmpty()) {
    //         while(!pushStack.isEmpty()) {
    //             popStack.push(pushStack.pop());
    //         }
    //     }
    // }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

