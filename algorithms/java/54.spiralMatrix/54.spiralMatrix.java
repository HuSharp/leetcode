import java.util.LinkedList;
import java.util.List;

import org.graalvm.compiler.lir.amd64.AMD64Move.LeaDataOp;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-11-28 13:33:29
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-11-28 13:48:57
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    List<Integer> res = new LinkedList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        printMatrix(matrix, 0, matrix.length-1, 0, matrix[0].length-1);
        
        return res;
    }

    private void printMatrix(int[][] matrix, int upRow, int downRow, int leftCol, int rightCol) {
        if(upRow > downRow || leftCol > rightCol) {
            return;
        }
        int posRow = upRow;
        int posCol = leftCol;
        // 考虑一行和一列
        if(upRow == downRow) {//一行
            while(posCol != rightCol) {
                res.add(matrix[posRow][posCol++]);
            }
            res.add(matrix[posRow][posCol]);
            return;
        }
        if(leftCol == rightCol) {//一列
            while(posRow != downRow) {
                res.add(matrix[posRow++][posCol]);
            }
            res.add(matrix[posRow][posCol]);
            return;
        }

        while(posCol != rightCol) {
            res.add(matrix[posRow][posCol++]);
        }
        while(posRow != downRow) {
            res.add(matrix[posRow++][posCol]);
        }
        while(posCol != leftCol) {
            res.add(matrix[posRow][posCol--]);
        }
        while(posRow != upRow) {
            res.add(matrix[posRow--][posCol]);
        }
        printMatrix(matrix, upRow+1, downRow-1, leftCol+1, rightCol-1);
    }
}
// @lc code=end

