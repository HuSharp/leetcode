package Sort;

public class RadixSorter {
    public static void radixSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        // 选出最大的数字
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        
        // 按照各个位数进行排序
        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(arr, i);
        }
    }

    /**
     * 计数排序-对数组按照"某个位数"进行排序
     *
     * @param arr
     * @param exp 指数
     */
    public static void countingSort(int[] arr, int exp) {
        if(arr.length <= 1) {
            return;
        }

        // 计算每个元素的个数
        int[] c = new int[10];
        for (int i = 0; i < arr.length; i++) {
            c[(arr[i] / exp) % 10]++;// 取下一位在某号桶中
        }
        // 计算排序后的位置
        // 通过上一个桶，得到自己的区间
        for (int i = 0; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        //临时数组 ， 存储排序之后的结果
        int[] tmp = new int[arr.length];
        for (int i = arr.length; i >= 0; i--) {
            tmp[c[(arr[i] / 10) % 10] - 1] = arr[i];
            c[(arr[i] / 10) % 10]--;   
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i];
        }
    }

}
