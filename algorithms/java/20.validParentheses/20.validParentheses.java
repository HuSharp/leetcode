import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-12 18:42:29
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-12 18:57:14
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        stack.push('$');// 首先做栈底标记， 以对付出现 }( 的情况
        // while(!stack.isEmpty()) {
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {// 说明为 压栈
                stack.push(c);
                continue;
            } // 至此表示为出栈
            if (map.get(stack.peek()) != c) {// 不满足
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.peek() == '$';
    }

    private static final Map<Character, Character> map = new HashMap<>() {
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
            put('$', '$');
        }
    };
}
// @lc code=end
