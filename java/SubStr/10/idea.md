# BG (V1.x:自己写的 2.x 看别人的)

给你一个整数数组 `nums` 和一个整数 `k` ，请你统计并返回  *该数组中和为 `k` 的子数组的个数 * 。

子数组是数组中元素的**连续**非空序列。

# V1.0

类似于滑动窗口，后指针往后移，

放入新元素，

当滑动窗口中的和小于target，则后指针往后移

滑动窗口中的元素的和为target时，count++，并且前指针后移一个

滑动窗口中元素之和大于target时，前指针后移，直至和小于等于target

~v1.0没考虑到元素可能有负数~

# V1.1

result: **55**ms  **43.84**MB

```

```

# V2.0

使用前缀和解法

我们定义pre[i]为[0..i]里所有数的和，则pre[i]可以由pre[i−1]递推而来，即：

pre[i]=pre[i−1]+nums[i]
那么「[j..i]这个子数组和为k」这个条件我们可以转化为

pre[i]−pre[j−1]==k
简单移项可得符合条件的下标j需要满足

pre[j−1]==pre[i]−k

所以我们考虑以i结尾的和为k的连续子数组个数时只要统计有多少个前缀和为pre[i]−k的pre[j]即可。我们建立哈希表mp，以和为键，出现次数为对应的值，记录pre[i]出现的次数，从左往右边更新mp边计算答案，那么以i结尾的答案mp[pre[i]−k]即可在O(1)时间内得到。最后的答案即为所有下标结尾的和为k的子数组个数之和。

总结：

记录每个数组的前缀和，如果pre[i]-pre[j]=k，则说明他们之间的字串和刚好为k

```
public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
```


知识点总结：
