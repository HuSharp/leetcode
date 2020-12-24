

#### [剑指 Offer 33. 二叉搜索树的后序遍历序列](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)



输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

 

参考以下这颗二叉搜索树：

         5
        / \
       2   6
      / \
     1   3
     
    输入: [1,6,3,2,5]
    输出: false




划分左右子树： 遍历后序遍历的 [left, right] 区间元素，寻找 第一个大于根节点 的节点，索引记为 pos 。此时，可划分出左子树区间 [left, pos−1]、右子树区间 [pos, right −1] 、根节点索引 right 。
判断是否为二叉搜索树：

- 左子树区间 [left ,pos−1] 内的所有节点都应 < postorder[right] 。而最开始的**划分左右子树**的步骤已经保证左子树区间的正确性，因此只需要判断右子树区间即可。
- 右子树区间 [pos, right−1] 内的所有节点都应 > postorder[right] 。判断方式为遍历，当遇到  ≤postorder[right] 的节点则 return false

```java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null) {
            return true;
        }
        
        return verify(postorder, 0, postorder.length-1);
    }

    // 最后一个点为根节点， 从前往后进行判断，找到第一个比根节点大的点
    // 所找到的该点之前区间便为左子树， 之后便为右子树
    private boolean verify(int[] postorder, int left, int right) {
        if(left > right) {
            return true;
        }
        
        int pos = left;// 初始化
        while(postorder[pos] < postorder[right]) {
            pos++;
        }// 至此，找到大于末尾 root 的第一个
        // 也可能没有大于 root 的，那么就说明左侧全为 左子树
        // 因此不能采用以下的写法
        // for (int i = left; i < right; i++) {
        //     if(postorder[i] > postorder[right]) {
        //         // 找到左右子树分界点
        //         pos = i;
        //         break;
        //     }
        // }

        for (int i = pos+1; i < right; i++) {
            // 若 pos 之后的存在比 root 小的， 就返回 false
            if(postorder[i] < postorder[right]) {
                return false;
            }
        }
        
        return verify(postorder, left, pos-1) && verify(postorder, pos, right-1);
    }
}
```

值得注意的是：

pos 的值表示的是右子树与左子树的边界点，pos 应当随着 判断比根节点小 的值而右移，

- 首先将 pos 初始化为 left，是为确保可能没有小于 root 的值，此时左侧全为右子树

- 也可能没有大于 root 的，那么就说明左侧全为 左子树，那么到达 right 时止步，此时 pos 也会更新到此处。

```java
        int pos = left;// 初始化
        while(postorder[pos] < postorder[right]) {
            pos++;
        }// 至此，找到大于末尾 root 的第一个
        // 也可能没有大于 root 的，那么就说明左侧全为 左子树
        // 因此不能采用以下的写法，应当随着小于值更新，而非大于值
        // for (int i = left; i < right; i++) {
        //     if(postorder[i] > postorder[right]) {
        //         // 找到左右子树分界点
        //         pos = i;
        //         break;
        //     }
        // }
```

