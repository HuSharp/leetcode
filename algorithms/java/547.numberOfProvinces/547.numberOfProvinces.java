/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-02-02 21:38:51
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-02-02 22:19:26
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 ) {
            return 0;
        }
        
        int len = isConnected.length;
        int res = 0;

        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {//若该城市还未被访问， 那么进行 DFS
                DFS(isConnected, len, i, visited);
                res++;
            }
        }
        return res;
    }

    private void DFS(int[][] isConnected, int len, int cur, boolean[] visited) {
        for (int i = 0; i < len; i++) {
            // 若有连接， 且还没有访问， 那么继续 DFS
            if (isConnected[cur][i] == 1 && !visited[i]) {
                visited[i] = true; 
                DFS(isConnected, len, i, visited);
            }
        }
    }
}
// @lc code=end

