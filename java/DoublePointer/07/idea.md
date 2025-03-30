# BG (V1.x:自己写的 2.x 看别人的)

给定 `n` 个非负整数表示每个宽度为 `1` 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

# V1.0 会忽略右端小于左端的容器（423）

以每一个元素为容器的左端，遍历数组中所有的容器，当找到存在的容器时，左端点移动到右端点，继续向后遍历（O（$N^2$）

双指针，pre指向容器的左端，end指向容器的右端

定义容器：~数组的元素都比容器左端小，容器右端的值为第一个大于容器左端的值(只考虑了右端高于左端的情况)~

    ~数组的元素都比容器左端小，容器右端的值为~~第一个大于容器左端的值~ ~第一个峰顶（需要考虑有边界特殊情况） (也不对 无法找到最大容器)~

计算容量：（end-pre-1）*h-（height[pre+1]+height[pre+2]+...+height[end-1])  //总容量-内置物体

result: **55**ms  **43.84**MB

```
 public int trap(int[] height) {
        int sum_rain=0;
        int j=1;
        int pre=0;
        int end;
     
        for(;pre<height.length-1;){
            end=pre+1;
            int sum1=0;
            while(end<height.length&&height[pre]>height[end]){
            sum1+=height[end];
            end++;
            }
            if(end==height.length){
                pre++;
            }
            else{//找到符合条件的右端
            int h= (height[pre]>height[end])?height[end]:height[pre];
            sum_rain+=((end-pre-1)*h-sum1);
            pre=end;
            }
          
        }
        return sum_rain;
          
        }
```

# V1.1 无法找到最大容器

```
public int trap(int[] height) {
        int sum_rain=0;
        int pre=0;
        int end;
     
        for(;pre<height.length-1;){
            end=pre+1;
            int sum1=0;
            if(height[pre]==0){
                pre++;
                continue;
            }
            while(end<height.length&&height[end-1]>height[end]){
            sum1+=height[end];
            end++;
            }
            if(end==height.length){
                pre++;
            }
            else{//找到符合条件的右端
             
            while(end<height.length&&height[end-1]<height[end]){
                sum1+=height[end];
                end++;
            }
            end--;
            // if(end==height.length){
            //     end--;
            // }
          
            int h= (height[pre]>height[end])?height[end]:height[pre];
            sum_rain+=((end-pre-1)*h-sum1+height[end]);
            System.out.println("left: "+pre+" right: "+end+" sum "+((end-pre-1)*h-sum1));
            pre=end;
            }
          
        }
        return sum_rain;
          
        }
```

# V1.3

其实按照V.0的算法，只会忽略已经找到的最大容器之外的左端高于右端的容器，其余最大容器应该都被找到了

修改：对于每个左端点先按照V1.0算法找最大容器，未找到则找最大的峰（即左端大于右端的最大容器）

# V2.0

对于下标**i**，下雨后水能到达的最大高度等于下标**i**两边的最大高度的最小值，下标**i**处能接的雨水量等于下标**i**处的水能到达的最大高度减去**height**[**i**]。

每个元素分别向左向右扫描最大值，即为最大容器 O($N^2$)

# V2.1 动态规划

使用动态规划在O(N)时间内获得letfmax和rightmax

显然，**leftMax**[**0**]**=**height**[**0**]**，**rightMax**[**n**−**1**]**=**height**[**n**−**1**]**

当1≤i≤n−1时，leftMax[i]=max(leftMax[i−1],height[i])；

当0≤i≤n−2时，rightMax[i]=max(rightMax[i+1],height[i])

作者：力扣官方题解
链接：https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

```
  public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

作者：力扣官方题解
链接：https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

# V2.2 双指针plus

前后指针往中间扫描，移动比较低的最大容器边（防止出现漏水）

```
 public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int leftMax=0;
        int rightMax=0;
        int res=0;
        while(left<right){//可以不加等号，因为在「谁小移动谁」的规则下，相遇的位置一定是最高的柱子，这个柱子是无法接水的。
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            if(leftMax<rightMax){
                res+=leftMax-height[left++];
            }else{
                res+=rightMax-height[right--];
            }
        }
        return res;
    }
```

J知识点回顾：
