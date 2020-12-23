#### [剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)



可参看博主二分法探究的 Blog

因为这道题说了，他本来是一个递增排序的数组，然后经过了一次旋转。一想到排序数组的查找，第一个应该想到的是二分法。



#### 算法流程：

- 初始化： 声明 left, right 双指针分别指向 nums 数组左右两端；

- 循环二分： 设 ` mid = l + ((r - l) >> 1); `为每次二分的中点，可分为以下三种情况：

  - 当 nums[m] > nums[right] 时： m 一定在 左排序数组 中，即旋转点 x 一定在 [m+1,right] 闭区间内，因此执行 l = mid + 1；

  - 当 nums[m] < nums[right] 时： m 一定在 右排序数组 中，即旋转点 x 一定在[left ,m] 闭区间内，因此执行  r = mid;

  - 当 nums[m]=nums[j] 时： 无法判断 m 在哪个排序数组中，即无法判断旋转点 x 在 [left,m] 还是 [m+1,right] 区间中。

    此时采用直接顺序遍历判断

    ```java
    for (int i = l; i < r-1; i++) {
        if(numbers[i] > numbers[i+1]) {
            return numbers[i+1];
        }
    }
    return numbers[l];
    ```

    

> 为什么本题二分法不用 nums[m] 和 nums[left] 作比较？
>
> 二分目的是判断 m 在哪个排序数组中，从而缩小区间。而在 nums[m] > nums[i] 情况下，无法判断 m 在哪个排序数组中。本质上是由于 j 初始值肯定在右排序数组中； i 初始值无法确定在哪个排序数组中。举例如下：
>
>     对于以下两示例，当 i=0,j=4,m=2 时，有 nums[m] > nums[i] ，而结果不同。
>     [1,2,3,4,5] 旋转点 x=0 ： m 在右排序数组（此示例只有右排序数组）；
>     [3,4,5,1,2] 旋转点 x=3 ： m 在左排序数组。
>





由于 ` numbers[mid] == numbers[r] `时，可能是 2 2 2 0 1 2 或 2 0 2 2 2 ，即并不能知道是在左区间还是右区间，因此对于区间的缩减不能用 l = mid - 1   r = mid + 1。

```java
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
```

