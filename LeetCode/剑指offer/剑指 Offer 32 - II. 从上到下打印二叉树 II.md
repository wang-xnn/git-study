#### [剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

难度简单

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [9,20],
  [15,7]
]
```

**提示：**

1. `节点总数 <= 1000`

方法一：BFS

```JAVA
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null)queue.add(root);
        List<List<Integer>> ans=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode t=queue.poll();
                list.add(t.val);
                if(t.left!=null)queue.add(t.left);
                if(t.right!=null)queue.add(t.right);
            }
            ans.add(list);
        }
         return ans;
    }
    
}//时间复杂度O(n),空间复杂度O(n)
```

方法二：DFS

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
    Map<Integer,List<Integer>> map= new HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(0,root);
        for(int key:map.keySet()){
            List<Integer> list=map.get(key);
            ans.add(list);
        }
        return ans;
    }
    public void dfs(int index,TreeNode root){
        if(root==null)return;
        List<Integer> list=map.getOrDefault(index,new ArrayList<>());
        list.add(root.val);
        map.put(index,list);
        dfs(index+1,root.left);
        dfs(index+1,root.right);
    }
}//时间复杂度O(n),空间复杂度O(n)
```

