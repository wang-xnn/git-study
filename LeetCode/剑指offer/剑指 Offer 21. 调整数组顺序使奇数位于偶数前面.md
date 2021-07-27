#### [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)

难度简单

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

**示例：**

```
输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。
```

**提示：**

1. `0 <= nums.length <= 50000`
2. `1 <= nums[i] <= 10000`

方法一：前后指针

```java
class Solution {
    public int[] exchange(int[] nums) {
        int n=nums.length;
        if(n==0||n==1)return nums;
        int head=0,tail=n-1;
        while(head<tail){
            if(nums[head]%2==1){
                head++;
                continue;
            }
            if(nums[tail]%2==0){
                tail--;
                continue;
            }
            swap(nums,head,tail);
        }
        return nums;
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}//时间复杂度O(n),空间复杂度O(1)
```

方法二：快慢指针

```java
class Solution {
    public int[] exchange(int[] nums) {
        int n=nums.length;
        if(n==0||n==1)return nums;
        int slow=0,fast=0;
        while(fast<n){
            if(nums[fast]%2==1){
                swap(nums,slow,fast);
                slow++;
            }
            fast++;
        }
        return nums;
}
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}//时间复杂度O(n),空间复杂度O(1)
```

