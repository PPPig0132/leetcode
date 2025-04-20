package MultiDP;


/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。机器人每次只能向下或者向右移动一步。
finish=(m,n)
f(m,n)=f(m-1,n)+f(n-1,m)
*/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int ans[][]=new int[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(i==0|| j==0){//左上边界上的点可达路径只有一条
                    ans[i][j]=1;
                }
                else{
                    ans[i][j]=ans[i-1][j]+ans[i][j-1];
                }
               
            }
        }
        return ans[m-1][n-1];
        
    }
    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int m = 3, n = 2;
        System.out.println(solution.uniquePaths(m, n)); // Output: 28 (There are 28 unique paths from the top-left to the bottom-right corner.)
    }
    
}
