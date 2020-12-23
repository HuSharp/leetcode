/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-11 23:46:46
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-12 09:29:18
 * @@Email: 8211180515@csu.edu.cn
 */
package CodingInterviews;

public class No11_rotateArr {

    public int minArray(int[] numbers) {
        
        int l = 0;
        int r = numbers.length - 1;
        int mid = ((r - l) >> 1) + l;

        // while(l < r) {
        //     if(numbers[mid] < numbers[r]) {// 说明 mid 位于右区间
        //         r  = mid;
        //     } else {// 说明 mid 位于左区间
        //         l = mid + 1;
        //     }
        // }// 但是此时还要考虑 == 情况 如 1 1 1 0 1
        // 直接采用顺序遍历即可

        while(l < r) {
            if(numbers[mid] == numbers[r] && numbers[mid] == numbers[l]) {
                for (int i = l; i < r; i++) {
                    if(numbers[i] > numbers[i+1]) {
                        return numbers[i+1];
                    }
                }
            } else if(numbers[mid] < numbers[r]) {// 说明 mid 位于右区间
                r  = mid;
            } else {// 说明 mid 位于左区间
                l = mid + 1;
            }
        }
        return numbers[l];
    }

    
}
