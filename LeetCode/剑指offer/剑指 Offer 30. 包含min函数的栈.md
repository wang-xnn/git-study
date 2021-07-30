#### [剑指 Offer 30. 包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

难度简单

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

**示例:**

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```

**提示：**

1. 各函数的调用总次数不超过 20000 次

方法一：辅助栈

```java
class MinStack {
    Deque<Integer> stack1,stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty()||stack2.peek()>=x){
            stack2.push(x);
        }
    }
    
    public void pop() {
        if(stack1.pop().equals(stack2.peek())){
            stack2.pop();
        }
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();

    }
}
//时间复杂度O（1),空间复杂度O（n)
```

方法二：新建包含最小值的链表结构

```java
class MinStack {
    Node head;
    /** initialize your data structure here. */
    public MinStack() {
       
    }
    
    public void push(int x) {
        if(head==null)head=new Node(x,x,null);
        else head=new Node(x,Math.min(head.min,x),head);
    }
    
    public void pop() {
        head=head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int min() {
        return head.min;
    }
    private class Node{
        private int val;
        private int min;
        private Node next;
        public Node(int val,int min,Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }
}//时间复杂度O（1),空间复杂度O（n)

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
```

