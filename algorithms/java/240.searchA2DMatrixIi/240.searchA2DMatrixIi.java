/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-28 13:00:43
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-04 18:48:17
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
    public boolean searchMatrix_1(int[][] matrix, int target) {
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

    // 法二：二分查找扩展方法
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        } 
        return searchMatrixHelper(matrix, 0, 0, matrix.length-1, matrix[0].length-1, matrix.length-1, matrix[0].length-1, target);
    }
    
    private boolean searchMatrixHelper(int[][] matrix, int x1, int y1, int x2, int y2, 
                            int xMax, int yMax, int target) {
        if(x1 > xMax || y1 > yMax) {
            return false;
        }

        // x 轴代表的是行， y 轴代表的是列
        // 若只有一个 那么就返回判断
        if(x1 == x2 && y1 == y2) {
            return matrix[x1][y1] == target;
        }

        // 取中值
        int centerX = (x1 + x2) >> 1;
        int centerY = (y1 + y2) >> 1;
        if(matrix[centerX][centerY] == target) {
            return true;
        }// 至此 表示需要划分矩阵
        // 若中间值比找寻值小， 那么舍弃左上矩阵
        if(matrix[centerX][centerY] < target) {
            // 右上
            return ( searchMatrixHelper(matrix, x1, centerY+1, centerX, y2, centerX, y2, target) 
            // 左下
            || searchMatrixHelper(matrix, centerX+1, y1, x2, centerY, x2, centerY, target)
            // 右下
            || searchMatrixHelper(matrix, centerX+1, centerY+1, x2, y2, x2, y2, target) );
        } else {// 说明中间值比找寻值大，那么舍弃右下矩阵
            // 左上
            return ( searchMatrixHelper(matrix, x1, y1, centerX, centerY, centerX, centerY, target)
            // 右上
            || searchMatrixHelper(matrix, x1, centerY+1, centerX, y2, centerX, y2, target) 
            // 左下
            || searchMatrixHelper(matrix, centerX+1, y1, x2, centerY, x2, centerY, target) );
            
        }
        
    }
}
// @lc code=end

