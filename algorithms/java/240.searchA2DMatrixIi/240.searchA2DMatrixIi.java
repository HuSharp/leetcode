/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-28 13:00:43
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-28 13:16:33
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    // 从 右上到左下
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 0 || matrix[0].length < 0) {
            return false;
        } 

        int m = matrix.length;
        int n = matrix[0].length;

        // 从右上开始
        int curRow = 0;
        int curCol = n-1;

        while(curRow < m && curCol > -1 && matrix[curRow][curCol] != target) {
            if(matrix[curRow][curCol] < target) {//大于就向下
                curRow++;
            } else {// 小于就向左
                curCol--;
            }
        }
        if(curRow == m || curCol == -1) {
            return false;
        }
        return true;
    }
}
// @lc code=end

