package Array;
/*
给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。
idea:

*/
import java.util.*;
public class Hindex {
    public int hIndex(int[] citations) {
        int n=citations.length,ans=n;
       
        for(int i=0;i<n;++i){
            if(citations[i]<ans){
                ans--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Hindex solution = new Hindex();
        int[] citations = {0,1,3,5,6};
        int hIndex = solution.hIndex(citations);
        System.out.println("H-Index: " + hIndex); // Output: 3
    }
}
