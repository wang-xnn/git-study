#### [剑指 Offer 29. 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)

难度简单

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

**示例 1：**

```
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
```

**示例 2：**

```
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
```

**限制**

- `0 <= matrix.length <= 100`
- `0 <= matrix[i].length <= 100`

方法：模拟，方向都是固定的，唯一的难点在于判断边界条件

```java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return new int[0];
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        int m=matrix.length,n=matrix[0].length;
        int[] res=new int[m*n];
        boolean[][] visited=new boolean[m][n];
        int index=0;
        int i=0,j=0;
        for(int k=0;k<m*n;k++){
            res[k]=matrix[i][j];
            visited[i][j]=true;
            int[] direction=directions[index%4];
            int a=direction[0],b=direction[1];
            if(i+a<0 || j+b<0 ||i+a>=m || j+b>=n || visited[i+a][j+b]==true){
                index++;
            }
            i+=directions[index%4][0];
            j+=directions[index%4][1];
        }
        return res;
    }
}//时间复杂度O(m*n),空间复杂度O(m*n)
```

还有一种想法是按层模拟