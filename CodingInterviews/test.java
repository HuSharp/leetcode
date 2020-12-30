/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-12-30 19:08:46
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-30 20:28:22
 * @@Email: 8211180515@csu.edu.cn
 */
public class test {
        // 采用归并实现
        public int reversePairs(int[] nums) {
            if(nums == null || nums.length < 2) {
                return 0;
            }

            int res = mergeSort(nums, 0, nums.length-1);
            
            return res;
        }

        private int mergeSort(int[] nums, int l, int r) {
            if(l == r) {
                return 0;
            }
            int mid = ((r - l) >> 1) + l;
            return mergeSort(nums, l, mid) +
                    mergeSort(nums, mid + 1, r) + 
                    whenMergeCnt(nums, l, mid, r);
        }

        // 在发生合并时，进行计数
        // eg 2 4 6 与  1 3 5 合并时
        // 对于 posL指向 2 ， posR指向 1  ，2 > 1 --->> num+(r - posR + 1)
        private int whenMergeCnt(int[] nums, int l, int mid, int r) {
            int[] mergeHelp = new int[r - l + 1];
            int posL = l;
            int posR = mid + 1;

            int res = 0;
            int pos = 0;
            printArr(nums, l, mid);
            printArr(nums, mid+1, r);
            while(posL <= mid && posR <= r) {
                if(nums[posL] > nums[posR]) {
                    // res += (posR - mid + 1);
                    res += (mid - posR + 1);
                }

                // 等于时候移动左边
                mergeHelp[pos++] = (nums[posL] <= nums[posR]) 
                                ? nums[posL++] 
                                : nums[posR++];
            }

            // 至此 至少将一个加载完毕
            while(posL <= mid) {
                // res += (posR - mid + 1);
                mergeHelp[pos++] = nums[posL++];
            }
            while(posR <= r) {
                mergeHelp[pos++] = nums[posR++];
            }
            // 尚且需要将 mergeHelp 移到
            for (int i = 0; i < mergeHelp.length; i++) {
                nums[l + i] = mergeHelp[i];
            }

            return res;
        }

        private void printArr(int[] nums, int l, int r) {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
}
