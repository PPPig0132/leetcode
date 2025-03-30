# BG (V1.x:自己写的 2.x 看别人的)

给你一个字符串数组，请你将 **字母异位词** 组合在一起。可以按任意顺序返回结果列表。

**字母异位词** 是由重新排列源单词的所有字母得到的一个新单词。

# V1.0

每个单词长度（l）不一样的情况：（区别length）

(1)应该将不同长度的字符串区分开

（2）每个字符串按照相同长度的字符串来处理

第一遍：类似于校验和，每个字母对应一个值，检查hash表中有没有，没有怎在结果列表中新建一个列表（新数据），在hash表中存入(res+length,index)

有的话

 O(n$^2$)

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

题解：

将排序后的作为唯一hash键值（想到了 但是没有实现出来，java可以直接调用库函数sort(),加强基础的数据结果算法的代码实现能力）

或者将每个字母及其出现的次数（a10b1c2）作为唯一hash键（代码实现简单但是没有想到）

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
