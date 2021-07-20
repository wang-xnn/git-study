#### [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

难度简单485

找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

**示例 1：**

```
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
```

**限制：**

```
2 <= n <= 100000
```

方法：原地数组

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]==i){
                i++;
                continue;
            }
            if (nums[nums[i]]==nums[i]) return nums[i];
            int tmp=nums[i];
            nums[i]=nums[tmp];
            nums[tmp]=tmp;

        }
        return -1;
    }
}//时间复杂度O(n),空间复杂度O(1)
```

> 它考察的是程序员的沟通能力，先问面试官要时间/空间需求！！！
> 只是时间优先就用字典，
> 还有空间要求，就用指针+原地排序数组，
> 如果面试官要求空间O(1)并且不能修改原数组，还得写成二分法！！！`

