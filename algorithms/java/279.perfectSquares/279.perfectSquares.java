import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-01-28 22:18:14
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-01-28 22:43:04
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    // 实际上就是找 n 到 0 的 最短距离
    public int numSquares(int n) {

        List<Integer> squareLists = generateSquare(n);
        Queue<Integer> queue = new LinkedList<>();

        // 记录备忘录
        boolean[] marked = new boolean[n + 1];
        
        // 初值入队
        queue.add(n);
        marked[n] = true;// 标记为已经遍历
        
        // 记录当前层数
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                // 遍历所有 square 值
                for (int s : squareLists) {
                    int surplus = cur - s;
                    if (surplus < 0) {
                        break;// 到此为止
                    }
                    // 判断是否满足条件
                    if (surplus == 0) {
                        return level;
                    }
                    // 至此 表示不满足，还要继续
                    if (marked[surplus]) {// 若已经遍历过
                        continue;
                    }

                    marked[surplus] = true;
                    queue.add(surplus);
                }
            }
        }

        return n;// 至此 说明都没有，只能拆解为 1 1 1
    }

    // 进行整数 n 内的完全数生成
    public List<Integer> generateSquare(int n) {
        List<Integer> lists = new LinkedList<>();
        for (int i = 1; i * i <= n; i++) {
            lists.add(i * i);
        }

        return lists;
    }
}
// @lc code=end

