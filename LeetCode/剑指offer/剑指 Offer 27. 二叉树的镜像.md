#### [剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)

难度简单

请完成一个函数，输入一个二叉树，该函数输出它的镜像。

**示例 1：**

```
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
```

**限制：**

```
0 <= 节点个数 <= 1000
```

注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/

方法：

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
       if(root==null)return root;
       return dfs(root);
    }
    public TreeNode dfs(TreeNode root){
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=dfs(root.right);
        root.right=dfs(temp);
        return root;
    }
   
}//时间复杂度O(n),空间复杂度O(1)
```

