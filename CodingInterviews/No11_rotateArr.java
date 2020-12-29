/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-11 23:46:46
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-23 17:09:57
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No11_rotateArr {

    // 通过二分查找进行判断
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        
        // 我们不断的缩小查找范围，当查找范围的长度为1的时候返回，下面代码中也就是left等于right的时候。
        while(l < r) {
            int mid = l + ((r - l) >> 1);
            // 将 mid 与 最右值进行判断
            // 判断是在右区间(上升) 还是 左区间（下降）
            if(numbers[mid] == numbers[r]) {
                // 可能是 2 2 2 0 1 2 或 2 0 2 2 2 // 并不能知道是在左区间还是右区间
                // 也可能就是找到了 
                for (int i = l; i < r-1; i++) {
                    if(numbers[i] > numbers[i+1]) {
                        return numbers[i+1];
                    }
                }
                return numbers[l];
            } else if(numbers[mid] > numbers[r]) {//说明在右侧
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return numbers[l];
    } 
    
}
