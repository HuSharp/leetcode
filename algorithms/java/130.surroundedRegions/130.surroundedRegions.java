/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-02-03 21:57:56
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-03 22:51:00
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    // 采用 dfs ，对于边界的标记为 # 待遍历到的时候，再将其所有化为 O
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = (i == 0 || j == 0 || i == m-1 || j == n-1);
                // 只看边界， 并从边界开始进行感染
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, m, n, i, j);
                }
            }
        }

        // 至此 遍历完毕
        // 将边界感染的改为 O， 将原本为 O 的改为 X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs(char[][] board, int m, int n, int i, int j) {
        // 边界
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (board[i][j] == 'X') {
            return;
        }

        // 表示已经遍历过
        if (board[i][j] == '#') {
            return;
        }

        // 首先将当前值改为 #
        board[i][j] = '#';

        for (int[] d : direction) {
            dfs(board, m, n, i + d[0], j + d[1]);
        }
    }
}
// @lc code=end

