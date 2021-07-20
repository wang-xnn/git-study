#### [剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)

难度简单

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 `n` 级的台阶总共有多少种跳法。

答案需要取模 `1e9`+7（1000000007），如计算初始结果为：1000000008，请返回 1。

**示例 1：**

```
输入：n = 2
输出：2
```

**示例 2：**

```
输入：n = 7
输出：21
```

**示例 3：**

```
输入：n = 0
输出：1
```

**提示：**

- `0 <= n <= 100`

注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/

方法：与斐波那契数列相同，动态规划

```java
class Solution {
    public static final int model=1000000007;
    public int numWays(int n) {
        int a=1,b=2;
        if(n==1 || n==0)return a;
        while(n-2>0){
            int temp=a;
            a=b;
            b=(temp+b)%model;  
            n--;
        }
        return b;
    }
}}//时间复杂度O(n),空间复杂度O(1)
```

