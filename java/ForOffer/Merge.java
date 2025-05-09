package ForOffer;
/*
合并区域，字节笔试题
*/
import java.util.*;
public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int []> ans =new ArrayList<int []>();
        int n=intervals.length;
        // Arrays.sort(intervals,(a,b)->{
        //     if(a[0]!=b[0]){
        //         return a[0]-b[0];
        //     }
        //     return a[1]-b[1];
        // });
        quickSort(intervals, 0, n-1);
        for(int i=0;i<n;++i){
            int temp[]=intervals[i];
            while(i<n-1&&temp[1]>=intervals[i+1][0]){
                ++i;
                temp[1]=Math.max(intervals[i][1],temp[1]);
               
            }

            ans.add(temp);
        }
        int [][]res=new int[ans.size()][2];
        for(int i=0;i<ans.size();++i){
            res[i]=ans.get(i);
        }
        return res;
    }
    public void quickSort(int[][] arr, int low, int high) {
        if (low < high) {
            // 找到分区点
            int pivotIndex = partition(arr, low, high);

            // 递归排序左右两部分
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // 分区方法
    private int partition(int[][] arr, int low, int high) {
        // 选择最后一个元素作为基准
        int[] pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            // 比较第一个元素
            if (arr[j][0] < pivot[0]) {
                i++;
                // 交换 arr[i] 和 arr[j]
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 交换 arr[i+1] 和 arr[high]（基准）
        int[] temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // 返回分区点
    }
    public static void main(String[] args) {
        Merge m = new Merge();
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merged = m.merge(intervals);
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
