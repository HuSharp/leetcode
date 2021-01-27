import java.util.LinkedList;
import java.util.Queue;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-01-27 21:34:29
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-01-27 22:28:19
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start
class Solution {

    class Node {
        int x;
        int y;
        public Node() {
        }
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int m = 0;
    int n = 0;
    // BFS 采用 Queue 实现
    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        m = grid.length;// 行数
        n = grid[0].length;// 列数


        // 首先判断边界条件
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {//说明不能到达
            return -1;
        } 

        // 设置备忘录
        int[][] mem = new int[m][n];
        mem[0][0] = 1;// 首先将 (0, 0) 标记为已经遍历
        
        int[][] near8 = {{-1, -1}, {-1, 0}, {-1, 1}
                        , {0, -1},          {0, 1}
                        , {1, -1}, {1, 0}, {1, 1}};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));// 开始点入队

        int res = 0;// 返回长度初始化为 0
        while (!queue.isEmpty()) {
            int size = queue.size();// 记录当前 queue 中个数
            res++;

            // System.out.println(size);

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                int curX = cur.x;
                int curY = cur.y;
                
                // 判断是否满足条件
                if (curX == m-1 && curY == n-1) {
                    return res;
                }

                // 遍历 8 个点
                for (int j = 0; j < 8; j++) {
                        
                    int nextX = curX + near8[j][0];// 判断下一个行
                    int nextY = curY + near8[j][1];// 判断下一个列

                    if (!inGrid(nextX, nextY)) {
                        continue;
                    }
                    
                    if(mem[nextX][nextY] == 1) {// 在备忘录就跳过
                        continue;
                    }
                    if(grid[nextX][nextY] == 1) {// 在障碍就跳过
                        continue;
                    }

                    queue.add(new Node(nextX, nextY));// 加入队列
                    mem[nextX][nextY] = 1;// 放入备忘录

                }
            }
        }

        return -1;
    }


    private boolean inGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
// @lc code=end

