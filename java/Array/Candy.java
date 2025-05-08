package Array;

/*
n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

你需要按照以下要求，给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻两个孩子评分更高的孩子会获得更多的糖果。
请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。

idea:
找出谷底，谷底的孩子只给1颗糖果，往两边递推
*/

public class Candy {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int temp;
        int ans[]=new int [n];
        for(int i=0;i<n;++i){
            ans[i]=1;
        }
        for(int i=1;i<n;++i){
            if(ratings[i]>ratings[i-1]){
                ans[i]=ans[i-1]+1;
            }
            // else if(ratings[i]==ratings[i-1]){
            //     ans[i]=ans[i-1];
            // }
        }
        for(int i=n-2;i>=0;--i){
            if(ratings[i]>ratings[i+1]){
                ans[i]=Math.max(ans[i],ans[i+1]+1);
            }
            // else if(ratings[i]==ratings[i+1]){
            //     temp=Math.max(ans[i],ans[i+1]);
            //     ans[i]=temp;
            //     ans[i+1]=temp;
            // }
        }
        temp=0;
        for(int i=0;i<n;++i){
            temp+=ans[i];
        }
        return temp;
        
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = {1, 2,2};
        System.out.println(candy.candy(ratings)); // Output: 5
    }

    
}
