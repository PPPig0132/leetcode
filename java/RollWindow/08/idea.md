# BG (V1.x:自己写的 2.x 看别人的)

给定一个字符串 `s` ，请你找出其中不含有重复字符的 **最长 子串** 的长度。

# V1.0

对每个元素都去计算其最长字串的长度 O($N^2$)

# V1.1

创建一个n空数组，用作滑动窗口

使用hash表 `<s[i],index>`来确定滑动窗口中有没有待加入的元素O(1)，没有则加入滑动窗口中，如果有，则先计算当前滑动窗口中字串的长度，~不用计算加入待加入元素后的字串非重复部分，因为长度总是小于等于原有的无重复长度~然后移除滑动窗口中重复字符串及其之前的部分，hash表中也要相应移除

result: **55**ms  **43.84**MB

```
 public int lengthOfLongestSubstring(String s) {
        int max_len=0;
        List<Character> window=new ArrayList<Character>();
        Map<Character,Integer>hashtable=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(hashtable.containsKey(s.charAt(i))){
                max_len=(max_len>window.size())?max_len:window.size();
                int index=hashtable.get(s.charAt(i));

                for(int j=0;j<=index;j++){
                    hashtable.remove(window.get(0));
                    window.remove(0);
                }
                for (Character key : hashtable.keySet()) {
                     hashtable.put(key, hashtable.get(key) -index-1);
                    }
                window.add(s.charAt(i));
                hashtable.put(s.charAt(i),window.size()-1);
          
          
            }
            else{
                window.add(s.charAt(i));
                hashtable.put(s.charAt(i),window.size()-1);
            }
        }
        return (max_len>window.size())?max_len:window.size();
  
      
        }

```

# V2.0

在每一步的操作中，我们会将左指针向右移动一格，表示我们开始枚举下一个字符作为起始位置，然后我们可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。在移动结束后，这个子串就对应着以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度

```
public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

```

知识点回顾：

引入新的数据结构 hash集合 hashset，将V1.0中使用hash表进行的操作进行极大的简化
