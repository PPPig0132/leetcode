package Ranges;
import java.util.*;
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if(points.length==1){
            return 1;
        }
        Arrays.sort(points,(a,b)->{
            if(a[0]!=b[0]){
                 return Integer.compare(a[0], b[0]);
            }
             return Integer.compare(a[1], b[1]);
        });
        int ans=1,l=points[0][0],r=points[0][1];
        for(int i=1;i<points.length;++i){
            if(points[i][0]>r){
                ans++;
                // now=i;
                l=points[i][0];
                r=points[i][1];
                continue;
            }
            l=points[i][0];
            r=r>points[i][1]?points[i][1]:r;
        }
        return ans;
    }
    public static void main(String[] args) {
        FindMinArrowShots f=new FindMinArrowShots();
        // int[][] points={{-2147483646,-2147483645},{2147483646,2147483647}};
        int[][] points={{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};//子区间67切不掉
        // int[][] points={{1,2},{3,4},{5,6},{7,8}};//子区间23切不掉
        System.out.println(f.findMinArrowShots(points));
    }
    
}
