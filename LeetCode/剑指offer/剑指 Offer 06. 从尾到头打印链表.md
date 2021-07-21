#### [剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

难度简单

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

**示例 1：**

```
输入：head = [1,3,2]
输出：[2,3,1]
```

**限制：**

```
0 <= 链表长度 <= 10000
```

个人解法：很容易想到，利用栈先进后出的特性

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack=new LinkedList<>();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int n=stack.size();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=stack.pop();
        }
        return res;
    }
}//时间复杂度O(n),空间复杂度O(n)
```

或者 递归也不错，从后向前

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> list=new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        add(head);
        int n=list.size();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=list.get(i);
        }
        return res;
    }
    public void add(ListNode head){
        if(head==null)return;
        add(head.next);
        list.add(head.val);
    }
} // 时间复杂度O(n),空间复杂度O(n)
```

无非就是从后往前的想法，通过遍历知道了链表的长度也可以解决，同样是2次遍历