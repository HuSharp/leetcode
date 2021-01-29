import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2021-01-29 22:02:54
 * @LastEditors: HuSharp
 * @LastEditTime: 2021-01-29 23:06:30
 * @@Email: 8211180515@csu.edu.cn
 */
/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);// 全部放入哈希表
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);//!!!!没想到啊
        
        // 采用经典 BFS 实现
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        Set<String> mem = new HashSet<>(); 
        mem.add(beginWord);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();// 当前值
                
                // 若只剩最后一步
                if (changeWordOnlyNeedOne(cur, endWord, queue, mem, wordSet)) {
                    return level + 1;
                }
            }
        }// 至此，表示没有
        return 0;
    }

    // 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
    private boolean changeWordOnlyNeedOne(String curWord, String endWord, 
                                Queue<String> queue, Set<String> mem, Set<String> wordSet) {
        char[] charArr = curWord.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            // 对 endWord 进行判断
            char curCh = charArr[i];
            // 按照 26 个字母分别对当前字符串的每个字符进行更改，来与 wordSet 进行判断
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == curCh) {
                    continue;
                }
                charArr[i] = j;
                String changeStr = String.valueOf(charArr);
                // 若位于 wordSet 中
                if (wordSet.contains(changeStr)) {
                    if (changeStr.equals(endWord)) {
                        return true;
                    }
                    // 现在判断备忘录
                    if (mem.contains(changeStr)) {
                        continue;
                    }
                    // 至此表示不相等， 也不在备忘录中
                    queue.add(changeStr);
                    mem.add(changeStr);
                }
            }
            // 此时， 将当前更改的字符恢复， 并开始判断下一个
            charArr[i] = curCh;
        }// 至此，若还未返回 true ，那么说明没有需要字符
        return false;
    }
}
// @lc code=end

