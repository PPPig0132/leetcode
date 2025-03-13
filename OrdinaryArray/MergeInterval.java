import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        // 调用 hello 方法
        // int[][] intervals = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        int[][] intervals = {{3,3},{0,1},{0,0}};
        MergeInterval mergeInterval = new MergeInterval();
        int[][] sorted=mergeInterval.sorted(intervals);
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i][0] + " " + sorted[i][1]);
        }
        int[][] res = mergeInterval.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
        
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 按照子数组的第一个元素进行比较
                return Integer.compare(a[0], b[0]);
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        // int ans[][]=new int[][];
        int left=0;
        int right=1;
        int max=intervals[left][1];
        while(right<intervals.length){
            if(intervals[right][0]<=max){
                max=(intervals[right][1]>max)?intervals[right][1]:max;
                right++;
            }
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(intervals[left][0]);
                temp.add(max);
                ans.add(temp);
                left=right;
                max=intervals[left][1];
                right++;

            }
        }
        System.out.println(max);
        if(left==intervals.length-1){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[left][0]);
            temp.add(intervals[left][1]);
            ans.add(temp);

        }
        else{
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[left][0]);
            temp.add(max);
            ans.add(temp);
        }

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        return res;

        
    }

    public int[][] sorted(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 按照子数组的第一个元素进行比较
                return Integer.compare(a[0], b[0]);
            }
        });
        return intervals;
    }


}