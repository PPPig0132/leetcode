package MultiDP;

import java.util.List;
/*给定一个三角形 triangle ，找出自顶向下的最小路径和。*/

public class MinimumTotal {
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int m=triangle.size();
    //     if(m==1){
    //         return triangle.get(0).get(0);
    //     }
    //     int ans[][] = new int [m][m];
    //     ans[0][0]=triangle.get(0).get(0);
    //     for(int i=1;i<m;++i){
    //         ans[i][0]=triangle.get(i).get(0)+ans[i-1][0];
    //     }
    //     for(int i=1;i<m;++i){
    //         ans[i][i]=triangle.get(i).get(i)+ans[i-1][i-1];
    //     }

    //     for(int i=1;i<m;++i){
    //         for(int j=1;j<i;j++){
    //             ans[i][j]=Math.min(triangle.get(i).get(j)+ans[i-1][j-1],triangle.get(i).get(j)+ans[i-1][j]);
                
    //         }

    //     }
    //     int res=ans[m-1][0];
    //     for(int len: ans[m-1]){
    //         if(len<res){
    //             res=len;
    //         }
            
    //     }
    //     return res;
    // }

    //空间复杂度优化为O(n)，使用递归提高时间复杂度
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int n = triangle.size();
        int[] min = new int[n];
        minimumPath(triangle, min, 0);
        int result = min[0];
        for (int pathLength : min) {
            if (pathLength < result) {
                result = pathLength;
            }
        }
        return result;
    }

    public void minimumPath(List<List<Integer>> triangle, int[] min, int i) {
        if (i >= triangle.size()) {
            return;
        }
        List<Integer> nums = triangle.get(i);
        for (int j = nums.size() - 1;j >= 0; j --) {
            if (j == 0) {
                min[0] = min[0] + nums.get(0);
            } else if (j == nums.size() - 1) {
                min[j] = min[j - 1] + nums.get(j);
            }  else {
                min[j] = Math.min(min[j] + nums.get(j), min[j-1] + nums.get(j));
            }
        }
        minimumPath(triangle, min, i + 1);
    }  
    public static void main(String[] args) {
        // Example usage
        MinimumTotal solution = new MinimumTotal();
        List<List<Integer>> triangle = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 3, 8, 1)
        );
        System.out.println(solution.minimumTotal(triangle)); // Output: 11 (2 + 3 + 5 + 1)
    }
}