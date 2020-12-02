import java.util.Arrays;
import java.util.Comparator;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-02 23:19:35
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-02 23:53:16
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
class Solution {

    private static class Program {
        int start;
        int end;
        
        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }

        // 首先生成排序区间
        Program[] programs = new Program[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            programs[i] = new Program(intervals[i][0], intervals[i][1]);
        }

        // 现在进行
        Arrays.sort(programs, new ProgramComparator());

        int end = programs[0].end;
        int cnt = 1;
        for (int i = 1; i < programs.length; i++) {
            if(programs[i].start < end) {
                continue;
            }
            end = programs[i].end;
            cnt++;
        }

        return intervals.length - cnt;
    }

    // 按照区间右侧进行升序排序， 越早结束越好
    private static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
}
// @lc code=end

