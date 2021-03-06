#### [剑指 Offer 13. 机器人的运动范围](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

难度中等

地上有一个m行n列的方格，从坐标 `[0,0]` 到坐标 `[m-1,n-1]` 。一个机器人从坐标 `[0, 0] `的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

**示例 1：**

```
输入：m = 2, n = 3, k = 1
输出：3
```

**示例 2：**

```
输入：m = 3, n = 1, k = 0
输出：1
```

**提示：**

- `1 <= n,m <= 100`
- `0 <= k <= 20`

方法：dfs,还可以用bfs解答

```java
class Solution {
    int m,n,k,res;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m=m;
        this.n=n;
        this.k=k;
        visited=new boolean[m][n];
        res=0;
        dfs(0,0);
        return res;
    }
    public void dfs(int row,int column){
        int a=row/10+row%10,b=column/10+column%10;
        int num=a+b;
        if(row>=m || column>=n || num>k || visited[row][column]==true)return;
        res++;
        visited[row][column]=true;
        if(row<m)dfs(row+1,column);
        if(column<n)dfs(row,column+1); 
    }
}//时间复杂度O(mn),空间复杂度O(mn)
```

