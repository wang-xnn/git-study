#### [剑指 Offer 40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

难度简单

输入整数数组 `arr` ，找出其中最小的 `k` 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

**示例 1：**

```
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
```

**示例 2：**

```
输入：arr = [0,1,2,1], k = 1
输出：[0]
```

**限制：**

- `0 <= k <= arr.length <= 10000`
- `0 <= arr[i] <= 10000`

方法：堆

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0 || k==0)return new int[0];
        int n=arr.length;
        PriorityQueue<Integer> q=new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        //PriorityQueue<Integer> q=new PriorityQueue<>((v1,v2)->v2-v1);
        for(int i=0;i<k;i++){
            q.offer(arr[i]);
        }
        for(int i=k;i<n;i++){
            if(q.peek()>arr[i]){
                q.poll();
                q.offer(arr[i]);
            }
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=q.poll();
        }
        return res;
    }
}//时间复杂度O（nlogk),空间复杂度O（k)
```

