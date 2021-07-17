### [剑指 Offer 42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

难度简单

##### 题目描述

> 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
>
> 要求时间复杂度为O(n)。

##### **示例1:**

> ```
> 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
> 输出: 6
> 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
> ```

##### **提示：**

- `1 <= arr.length <= 10^5`
- `-100 <= arr[i] <= 100`

注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/

##### 方法一：动态规划

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] f=new int[n];
        f[0]=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
            f[i]=Math.max(nums[i],f[i-1]+nums[i]);
            ans=Math.max(f[i],ans);
        }
        return ans;
    }
}//时间复杂度O(n),空间复杂度O(n)
```

##### 方法二：与动态规划思想类似，但换了种形式

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int sum=0,ans=nums[0];
        for(int num:nums){
           if(sum<=0){
               sum=num;
           }else{
               sum+=num;
           }
           ans=Math.max(ans,sum);
        }
        return ans;
    }
}//时间复杂度O(n),空间复杂度O(1)
```

##### 方法三：前缀和

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int sum=0;
        int min=0,max=-101;
        for(int i=0;i<n;i++){
           sum+=nums[i];
           max=Math.max(max,sum-min);
           min=Math.min(min,sum);
        }
        return max;
    }
}//时间复杂度O(n),空间复杂度O(1)
```

方法四：分治

```java
class Solution {
    public class State{
        int lSum,rSum,mSum,nSum;
        public State(int lSum,int rSum,int mSum,int nSum){
            this.lSum=lSum;
            this.rSum=rSum;
            this.mSum=mSum;
            this.nSum=nSum;
        }
    }
    public int maxSubArray(int[] nums) {
        return getSubSum(nums,0,nums.length-1).mSum;
    }
    public State getSubSum(int[] arr,int start,int end){
        if(start==end){
            return new State(arr[start],arr[start],arr[start],arr[start]);
        }
        int mid=start+end>>1;
        State a=getSubSum(arr,start,mid);
        State b=getSubSum(arr,mid+1,end);
        return pushUp(a,b);
    }
    public State pushUp(State a,State b){
        int lSum=Math.max(a.lSum,a.nSum+b.lSum);
        int rSum=Math.max(b.rSum,a.rSum+b.nSum);
        int mSum=Math.max(Math.max(a.rSum+b.lSum,a.mSum),b.mSum);
        int nSum=a.nSum+b.nSum;
        return new State(lSum,rSum,mSum,nSum);
    }
}//时间复杂度O(n),空间复杂度O(1ogn)
```

