#### [930. 和相同的二元子数组](https://leetcode-cn.com/problems/binary-subarrays-with-sum/)

难度中等

题目描述

> 给你一个二元数组 `nums` ，和一个整数 `goal` ，请你统计并返回有多少个和为 `goal` 的 **非空** 子数组。
>
> **子数组** 是数组的一段连续部分。

 **示例 1：**

```
输入：nums = [1,0,1,0,1], goal = 2
输出：4
解释：
有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
```

**示例 2：**

```
输入：nums = [0,0,0,0,0], goal = 0
输出：15
```

 **提示：**

> `1 <= nums.length <= 3 * 104`
>
> `nums[i]` 不是 `0` 就是 `1`
>
> `0 <= goal <= nums.length`

解题思路：前缀和+哈希表/双指针

**方法一：前缀和+哈希表**

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        int[] sums=new int[n+1];
        for(int i=1;i<=n;i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int sum:sums){
            int val=sum-goal;
            if(map.containsKey(val)){
                res+=map.get(val);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
```

- 时间复杂度：O(n)
- 空间复杂度：O(n)

**方法二：双指针**

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        int res=0;
        for(int i=0,l1=0,l2=0,s1=0,s2=0;i<n;i++){
            s1+=nums[i];
            s2+=nums[i];
            while(l1<=i && s1>goal)s1-=nums[l1++];
            while(l2<=i && s2>=goal)s2-=nums[l2++];
            res+=l2-l1;
        }
        return res;
    }
}

```

- 时间复杂度：O(n)
- 空间复杂度：O(1)