# BG (V1.x:自己写的 2.x 看别人的)

给定两个字符串 `s` 和 `p`，找到 `s` 中所有 `p` 的 **异位词**的子串，返回这些子串的起始索引。不考虑答案输出的顺序。


<pre><strong>输入: </strong>s = "cbaebabacd", p = "abc"</pre>

<pre><strong>输出: </strong>[0,6]</pre>

# V1.0

参考找异构词的算法，将p进行sort，使用长度为p.length()的滑动窗口从前往后遍历


result: **55**ms  **43.84**MB

```
public List<Integer> findAnagrams(String s, String p) {
        List<Integer>res=new ArrayList<>();
        if(s.length()<p.length()) return res;
        char [] q=p.toCharArray();
        Arrays.sort(q);
        int pre=0;
        for(;pre<s.length()-p.length()+1;pre++){
            int end=pre+p.length();
            String temp=s.substring(pre,end);
            char []temp1=temp.toCharArray();
            Arrays.sort(temp1);
            if(Arrays.equals(q,temp1)){
                res.add(pre);
            }
        }
        return res;

      
    }
```

# V2.0

思路一样，更简洁的实现。

相比于将String转为char数组，再进行sort，通过创建一个长度为26的空数组，统计每个字母出现的次数在本题中速度更快，且空间不变

```
 public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
	//第一个窗口
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
	//后续滑动窗口
        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

作者：力扣官方题解
链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/1123971/zhao-dao-zi-fu-chuan-zhong-suo-you-zi-mu-xzin/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

# V2.1


在方法一的基础上，我们不再分别统计滑动窗口和字符串p中每种字母的数量，而是统计滑动窗口和字符串p中每种字母数量的差；并引入变量differ来记录当前窗口与字符串p中数量不同的字母的个数，并在滑动窗口的过程中维护它。

在判断滑动窗口中每种字母的数量与字符串p中每种字母的数量是否相同时，只需要判断differ是否为零即可

```
int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
	//通过上一个for循环操作后，count数组中非0元素的个数就是两个字符串之间不同字符数
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

	//以上操作移除滑动窗口最后一个元素，如果元素为-1，即本来就少一个字符s[i]，再移除s[i]不影响differ的变化

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];
  
            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

作者：力扣官方题解
链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/1123971/zhao-dao-zi-fu-chuan-zhong-suo-you-zi-mu-xzin/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

知识点总结：

再证明相同与否时，常用differ，即a-b=0。

总结Java各个数据类型及其操作变化：

String
