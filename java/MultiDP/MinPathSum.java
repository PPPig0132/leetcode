package MultiDP;
/*
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

sum(m,n)=min(sum(m-1,n),sum(m,n-1))+grid[m][n]
*/

public class MinPathSum {
    // public int minPathSum(int[][] grid) {
    //     int m=grid.length,n=grid[0].length;
    //     int ans[][]=new int[m][n];
    //     ans[0][0]=grid[0][0];//起点
    //     for(int i=0;i<m;++i){
    //         for(int j=0;j<n;++j){
    //             if(i==0&&j==0){
    //                 continue;
    //             }
    //             else if(i==0){
    //                 ans[i][j]=ans[i][j-1]+grid[i][j];
    //             }
    //             else if(j==0){
    //                 ans[i][j]=ans[i-1][j]+grid[i][j];
    //             }
    //             else{
    //                 ans[i][j]=Math.min(ans[i][j-1],ans[i-1][j])+grid[i][j];
    //             }
    //         }
    //     }
    //     return ans[m-1][n-1];
    // }
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int ans[][]=new int[m+1][n+1];
        // ans[1][1]=grid[0][0];//起点
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(i==1){
                        ans[i][j]=ans[i][j-1]+grid[i-1][j-1];
                        // Math.max(ans[i][j-1],ans[i-1][j])+grid[i-1][j-1];
                }
                else if(j==1){
                    ans[i][j]=ans[i-1][j]+grid[i-1][j-1];
                }
               else{
                    ans[i][j]=Math.min(ans[i][j-1],ans[i-1][j])+grid[i-1][j-1];
               }
                    
            }
        }
        return ans[m][n];
    }
    public static void main(String[] args) {
        MinPathSum solution = new MinPathSum();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(solution.minPathSum(grid)); // Output: 7 (The path is 1→3→1→1→1.)
    }
    
}
