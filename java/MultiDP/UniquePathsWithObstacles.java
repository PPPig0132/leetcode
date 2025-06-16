package MultiDP;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1) return 0;
        if(m==1&&n==1) return 1;
        int []counts=new int[n];
        counts[0]=1;
        for(int i=1;i<n;++i){
            if(obstacleGrid[0][i]==0){
                counts[i]+=counts[i-1];
            }
        }
        calCounts(obstacleGrid,counts,1);
        return counts[n-1];
    }
    public void calCounts(int[][] matricx, int []cur, int index ){
        if(index==matricx.length){
            return;
        }
        if(matricx[index][0]==1){
            cur[0]=0;
        }
        for(int i=1;i<matricx[0].length;++i){
            if(matricx[index][i]==1){
                cur[i]=0;
            }
            else{
                cur[i]=cur[i]+cur[i-1];
            }
        }
        calCounts(matricx,cur,index+1);
    }
    public static void main(String[] args) {
        UniquePathsWithObstacles solution = new UniquePathsWithObstacles();
        int[][] obstacleGrid = {
            {0,0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid)); // Output: 2
    }
    
}
