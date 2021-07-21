#### [剑指 Offer 12. 矩阵中的路径](https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/)

难度中等

给定一个 `m x n` 二维字符网格 `board` 和一个字符串单词 `word` 。如果 `word` 存在于网格中，返回 `true` ；否则，返回 `false` 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。

![img](https://assets.leetcode.com/uploads/2020/11/04/word2.jpg)

 

**示例 1：**

```
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
```

**示例 2：**

```
输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
```

**提示：**

- `1 <= board.length <= 200`
- `1 <= board[i].length <= 200`
- `board` 和 `word` 仅由大小写英文字母组成 

**注意：**本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/

方法：回溯+剪枝

正常的回溯时间会超时，必须要提前判断什么情况肯定不满足，然后终止，减少时间

个人超时解法，未解出，笨比代码

```java
class Solution {
    char[][] board;
    boolean[][] isUsed;
    int m,n,s;
    public boolean exist(char[][] _board, String word) {
        board=_board;
        m=board.length;
        n=board[0].length;
        s=word.length();
        if(m*n<s)return false;
        isUsed=new boolean[m][n];
        boolean flag=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    isUsed[i][j]=true;
                    boolean a=path(i,j,1,word);
                    isUsed[i][j]=false;
                    if(a==true){
                        flag=true;
                    }
                }
            }
        }
        return flag;
    }
    public boolean path(int i,int j,int k,String word){
        if(i >= m || i < 0 || j >= n || j < 0 ) return false;
        if(k==s)return true;
        boolean a=false,b=false,c=false,d=false;
        if(i>0 && isUsed[i-1][j]==false && word.charAt(k)==board[i-1][j]){
            isUsed[i-1][j]=true;
            a=path(i-1,j,k+1,word);
            isUsed[i-1][j]=false;
        }
        if(i<m-1 && isUsed[i+1][j]==false && word.charAt(k)==board[i+1][j]){
            isUsed[i+1][j]=true;
            b=path(i+1,j,k+1,word);
            isUsed[i+1][j]=false;
        }
        if(j>0 && isUsed[i][j-1]==false && word.charAt(k)==board[i][j-1]){
            isUsed[i][j-1]=true;
            c=path(i,j-1,k+1,word);
            isUsed[i][j-1]=false;
        }
        if(j<n-1 && isUsed[i][j+1]==false && word.charAt(k)==board[i][j+1]){
            isUsed[i][j+1]=true;
            d=path(i,j+1,k+1,word);
            isUsed[i][j+1]=false;
        }
        return a || b || c || d;
    }
}
```

修改后

```java
class Solution {
    char[][] board;
    boolean[][] isUsed;
    int m,n,s;
    char[] words;
    public boolean exist(char[][] _board, String word) {
        board=_board;
        m=board.length;
        n=board[0].length;
        words=word.toCharArray();
        s=words.length;
        if(m*n<s)return false;
        isUsed=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(path(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean path(int i,int j,int k){
        if(i >= m || i < 0 || j >= n || j < 0 || words[k]!=board[i][j] || isUsed[i][j]) return false;
        if(k==s-1)return true;
        isUsed[i][j]=true;
        boolean res=path(i-1,j,k+1)||path(i+1,j,k+1)||path(i,j-1,k+1)||path(i,j+1,k+1); 
        isUsed[i][j]=false;
        return res;
    }
}//时间复杂度O(3^k *m*n)，空间复杂度O(2m*n+k)
```

