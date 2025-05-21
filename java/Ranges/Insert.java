package Ranges;
/*
在无重叠的按起点升序排列的区间中插入一个区间，保持无重叠
*/
import java.util.*;
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        if (n==0){
            return new int[][] {newInterval};
        }
        List<int[]> ans = new ArrayList<>();

        if(intervals.length==1){
            if(intervals[0][0]>newInterval[1]){
                ans.add(newInterval);
                ans.add(intervals[0]);
            }
            else if(intervals[0][1]<newInterval[0]){
                ans.add(intervals[0]);
                ans.add(newInterval);
            }
            else{
                int start=Math.min(intervals[0][0],newInterval[0]);
                int end=Math.max(intervals[0][1],newInterval[1]);
                ans.add(new int[]{start,end});
            }
            return ans.toArray(new int[ans.size()][]);
        }
        int start=-1;

        for(int i=0;i<n;++i){
            if(intervals[i][0]>=newInterval[0]){
                break;
            }
            start++;
        }

        for(int i=0;i<start;++i){
            ans.add(intervals[i]);
        }
        if(start==-1){
            if(newInterval[1]>=intervals[0][0]){
                newInterval[0]=Math.min(newInterval[0],intervals[0][0]);
            }
        }
        else{
            if(intervals[start][1]<newInterval[0]){
                ans.add(intervals[start]);
            }
            else{
                newInterval[0]=intervals[start][0];
            }
        }

        int end=start>0?start:0;
        for(int i=end;i<n;++i){
            if(intervals[i][1]>=newInterval[1]){
                break;
            }
            end++;
        }
        
        if(start==end ){//插入区间为现有区间的子区间
            return intervals;
        }
        
        if(end==n){
            ans.add(newInterval);
        }
        else{
            if(newInterval[1]<intervals[end][0]){
                ans.add(newInterval);
                ans.add(intervals[end]);
            }
            else{
                newInterval[1]=intervals[end][1];
                ans.add(newInterval);
            }
        }

        for(int i=end+1;i<n;++i){
            ans.add(intervals[i]);
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        Insert solution = new Insert();
        int[][] intervals = {{1,3},{6,9}};
        // int[][] intervals = {{1,5}};
        // int[][] intervals = {{2,3},{4,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {10,11};
        int[][] result = solution.insert(intervals, newInterval);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
