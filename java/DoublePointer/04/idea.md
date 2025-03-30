# BG (V1.x:自己写的 2.x 看别人的)

给定一个数组 `nums`，编写一个函数将所有 `0` 移动到数组的末尾，同时保持非零元素的相对顺序。

**请注意** ，必须在不复制数组的情况下原地对数组进行操作。

# V1.0

一个指针从前往后扫描，记录0的个数（coun_zero），非0元素往前移动coun_zero个位置。

result: 2ms  44.9MB

[1,0,3,5,4,6,0,4,0,3,0,4,0,6]->[1,3,5,4,6,4,0,0,0,3,0,4,0,6]

```

```

# V2.0

使用前后指针，前指针记录第一个0的位置，后指针遍历非0元素，找到非0元素则与前指针交换位置，同时前指针位置后移。

result: 1ms  45.1MB

```
public void moveZeroes(int[] nums) {
        int n = nums.length; int left = 0; int right = 0;
         while (right < n) {
             if (nums[right]!=0) {
               int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
             }
             right++;
         }
        }

```

J知识点回顾：
