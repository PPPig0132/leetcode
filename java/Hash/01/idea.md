# BG (V1.x:自己写的 2.x 看别人的)

给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出 **和为目标值 ***`target`*  的那 **两个** 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。

你可以按任意顺序返回答案。(只会存在一个有效答案)

# V1.0

固定一个值，另外一个值往后遍历，两个for 循环， O(n$^2$)

result: **55**ms  **43.84**MB

```
public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    
    }
```

# V2.0

注意到方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素。如果存在，我们需要找出它的索引。

使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N) 降低到 O(1)。

这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。

```
public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

作者：力扣官方题解
链接：https://leetcode.cn/problems/two-sum/solutions/434597/liang-shu-zhi-he-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

J知识点回顾：

- Map<Integer, Integer> : hash表键值对 `<key:value>`,Map<Integer, Integer>表示创建的hash表键和值的数据类型都为Integer型。
- hash算法可以由 `键`得到 `值`，但是无法由 `值`得到 `键`。(hash算法的不可逆性)
- hash冲突：当存入hash表时不同的键产生了相同的hash值，会产生hash冲突（多个键对应一个值），需要采用固定的算法处理。
- ~本题中默认只有一组答案，因此不会存在出现hash冲突的情况。当 ``target``的值为两个相同的数相加时{6,[3,3]}，遍历到第一个 `3`时hash表中没有 `key`为 `3`的项，因此没有hash冲突，到第二个 `3`时，表中有 `3`的项满足和为 `target`，直接返回，因此第二个 `3`并没有存入hash表，不存在hash冲突。~
- 本题中不会产生hash冲突，因为本题的hash结构为 `<target-nums[i],i>` 每个数在 `nums`数组中对应的 `索引index`是唯一的，因此不会产生键冲突。

hash值重复：

```
 hashMap.put("One", 1);
 hashMap.put("Two", 2);
 hashMap.put("Three", 1); 
```

产生hash冲突，代码正常运行，`HashMap` 会通过链表或红黑树（在 Java 8 及以上版本中）来解决冲突。（库函数自带hash冲突处理算法）。

hash键重复：

```
hashMap.put("One", 1); // {"One" -> 1}
hashMap.put("One", 10); // {"One" -> 10}，之前的值被覆盖
```

`HashMap` 会覆盖之前的值。
