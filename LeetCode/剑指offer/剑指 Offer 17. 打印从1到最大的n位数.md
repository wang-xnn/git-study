#### [剑指 Offer 17. 打印从1到最大的n位数](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

难度简单

输入数字 `n`，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

**示例 1:**

```
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9] 
```

说明：

- 用返回一个整数列表来代替打印
- n 为正整数

方法：不是对这个简单的题目，是针对变化，大树越界问题

```java
class Solution {
    StringBuilder sb=new StringBuilder();
    int nine=0,n,start;
    char[] num,loop={'0','1','2','3','4','5','6','7','8','9'};
    public int[] printNumbers(int n) {
        this.n=n;
        num=new char[n];
        start=n-1;
        dfs(0);
        res.deleteCharAt(res.length()-1);
        return sb.toString();
    }
    public void dfs(int k){
        if(k==n){
            String s=String.valueOf(num).substring(start);
            if(!s.equals("0"))sb.append(s+",");
            if(n-start==nine)start--;
            return;
        }
        for(char x:loop){
            if(x=='9')nine++;
            num[k]=x;
            dfs(k+1);
        }
        nine--;
    }
}//时间复杂度O(10^n),空间复杂度O(10^n)
```

