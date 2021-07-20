#### [剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

难度简单360

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 `[3,4,5,1,2]` 为 `[1,2,3,4,5]` 的一个旋转，该数组的最小值为1。 

**示例 1：**

```
输入：[3,4,5,1,2]
输出：1
```

**示例 2：**

```
输入：[2,2,2,0,1]
输出：0
```

注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/

方法：二分，不过要注意二分比较的点的位置，应取右侧的点，左侧的点容易出错

```java
class Solution {
    public int minArray(int[] numbers) {
        int n=numbers.length;
        int l=0,r=n-1;
        while(l<r){
            int mid=l+r>>1;
            if(numbers[mid]>numbers[r]){
                l=mid+1;
            }else if(numbers[mid]<numbers[r]){
                r=mid;
            }else{
                r=r-1;
            }
        }
        return numbers[l];
    }
}//时间复杂度O(logn),空间复杂度O(1)
```

