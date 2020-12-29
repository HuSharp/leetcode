/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-16 19:05:50
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-16 19:11:15
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No4_findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length;

        while(x <= matrix.length && y <= matrix[0].length && y >= 0) {
            if(matrix[x][y] == target) {
                return true;
            } else if(matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }

        return false;
    }
}
