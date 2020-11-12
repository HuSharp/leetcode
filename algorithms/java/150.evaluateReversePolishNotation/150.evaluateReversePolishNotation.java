/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-12 17:34:00
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-12 17:34:09
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();

        int master = 0;// 主操作数
        int slave = 0;
        int pos = 0;// 指示 tokens 当前位置
        String curToken = null;
        
        while(pos < tokens.length) {
            curToken = tokens[pos];
            switch (curToken) {
                case "+":
                    slave = stack.pop();
                    master = stack.pop();
                    master += slave;
                    break;
                case "-":
                    slave = stack.pop();
                    master = stack.pop();
                    master -= slave;
                    break;
                case "*":
                    slave = stack.pop();
                    master = stack.pop();
                    master *= slave;
                    break;
                case "/":
                    slave = stack.pop();
                    master = stack.pop();
                    master /= slave;
                    break;
                default:
                    master = Integer.valueOf(curToken);
                    break;
            }
            stack.push(master);
            pos++;
        }

    return stack.pop();
    }
}
// @lc code=end

