/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-12 19:15:38
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-12 19:16:37
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {

    // 采用两个栈进行操作， 一个为普通栈， 一个为存最小值栈
    Stack<Integer> stack = null;
    Stack<Integer> storeStack = null;

    // /** initialize your data structure here. */
    // public MinStack() {
    //     stack = new Stack<>();
    //     storeStack = new Stack<>();
    // }

    // public void push(int x) {
    //     stack.push(x);
    //     if (!storeStack.isEmpty() && storeStack.peek() > x) {
    //         storeStack.push(x);
    //     } else {
    //         if (storeStack.isEmpty()) {
    //             storeStack.push(x);
    //         } else {
    //             storeStack.push(storeStack.peek());
    //         }
    //     }
    // }

    // public void pop() {
    //     stack.pop();
    //     storeStack.pop();
    // }

    // public int top() {
    //     return stack.peek();
    // }

    // public int getMin() {
    //     return storeStack.peek();
    // }

    // 法二 getMin 采用不重复值
    public MinStack() {
        stack = new Stack<>();
        storeStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (storeStack.isEmpty() || x <= getMin()) {
            storeStack.push(x);
        }
    }

    public void pop() {
        int popValue = stack.pop();
        if (popValue == getMin()) {
            storeStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return storeStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
// @lc code=end
