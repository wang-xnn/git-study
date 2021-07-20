#### [剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

难度简单

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 `appendTail` 和 `deleteHead` ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，`deleteHead` 操作返回 -1 )

**示例 1：**

```
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

**示例 2：**

```
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
```

**提示：**

- `1 <= values <= 10000`
- `最多会对 appendTail、deleteHead 进行 10000 次调用`

方法：

```java
class CQueue {
    public Deque<Integer> stack1;
    public Deque<Integer> stack2;

    public CQueue() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
```

这道题值得注意的是stack的构造方式，是直接使用stack还是`Deque`接口下的`linkedlist`了



> 如果使用**Stack**的方式来做这道题，会造成速度较慢； 原因的话是Stack继承了Vector接口，而Vector底层是一个**Object[]数组**，那么就要考虑**空间扩容和移位**的问题了。 可以使用`LinkedList`来做Stack的容器，因为LinkedList实现了Deque接口，所以Stack能做的事LinkedList都能做，其本身结构是个双向链表，扩容消耗少。 但是我的意思不是像100%代码那样直接使用一个LinkedList当做队列，那确实是快，但是不符题意。
>
> `AbstractList<-AbstractSequentialList<-LinkedList`
>
> `AbstractList<-Vector<-Stack`
>
> LinkedList直接继承于AbstractSequentialList，也就是直接继承于顺序表抽象类，这个有序表抽象类继承于列表抽象类(AbstractList)。 AbstractList提供了基本的列表操作，其的doc中写道：For sequential access data (such as a linked list),AbstractSequentialList should be used in preference to this class. 也就是对于顺序表，需要优先继承于**顺序表抽象类而非直接使用列表抽象类**。 这个是在架构或者说是在思想层面上的解释，也解释了我为什么我这么说。 就`jdk`源码层面来说 LinkedList本身维护了Node<E>类型的 first和last 头尾节点以实现双向链表的存储结构。 Vector 维护了一个 Object[]数组，并实现了对数组的各种操作，Stack只是根据栈的特性，提供了push\pop\peek\empty等方法，并调用父类(Vector)的方法来操作数组。 所以在这个层面上来说，确实将我的说法中"而Vector底层是AbstractList，是一个数组"改为"而Vector底层是Object[]，是一个数组"更加稳妥