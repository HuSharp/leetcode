

#### [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，
也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。



### 法一 Set 法

时间空间都为 O(n）

```java
    public int findRepeatNumber_1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else{
                return nums[i];
            }
        }
        return 0;
    }
```



### 法二 与下标值匹配法

重头扫描数组，遍历到下标为 i 时 ，取出此处数值，判断是否与下标值匹配

- 不匹配：就交换到匹配的 nums[i] 位置，若发现 nums[i] 位置已经存在相应值了，那么说明是重复的，返回该值即可。
- 匹配：就遍历下一个

```java
    // 一直交换数组当前值与索引位置值，直到索引与当前值相等时，再向后移
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            
            while(nums[i] != i) {
                if(nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            
        }
        return -1;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
```

