#### [剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

难度简单

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

**示例:**

```
s = "abaccdeff"
返回 "b"

s = "" 
返回 " "
```

**限制：**

```
0 <= s 的长度 <= 50000
```

方法：哈希

```java
class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map=new LinkedHashMap<>();
        char[] cs=s.toCharArray();
        for(char c:cs){
            map.put(c,!map.containsKey(c));
        }
        for(Map.Entry<Character,Boolean> entry:map.entrySet()){
            if(entry.getValue())return entry.getKey();
        }
        return ' ';
    }
}//时间复杂度O(n),空间复杂度O(n)
```

