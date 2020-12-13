/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-13 10:34:27
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-13 11:24:32
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    // 整数反转
    public int reverse(int x) {
        // 2147483647
        // -2147483648
        // 由于负数最大为 1 0000...000 = -x31*2^31 + x30*2^30 + x29*2^29...+x0*2^0
        // 负数的二进制由最大无符号数 - 负数的模
        // eg -128 = 256 - 128 = 128 = 1000 0000
        // 这是和时钟一样， 计算机中的 129 表示 -127 相当于以模 256 为一圈，
        //      顺时针的 129 与 逆时针的 127 一致
        // 回到最大负数， 由于是 1111...1111 - 01000..000 
        // 正数最大为  0 111...111
        // 负数最大为  1 000...000, 即 若看作无符号数，比正数大一

        int res = 0;
        while(x != 0) {
            int last = x % 10;// 取最后一位
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE/10 && last > 7)) {
                return 0;
            }
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MAX_VALUE/10 && last < -8)) {
                return 0;
            }
            

            res = res * 10 + last;
            x /= 10;
        }

        return res;
    }
}
// @lc code=end

