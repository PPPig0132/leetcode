
/*
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
*/
import java.util.Arrays;
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        if (n==1) return new int[][]{{1}};
        int l=0,r=n-1,u=0,d=n-1;    
        int ans[][]=new int [n][n]; 
        l2r(ans,l,r,u,0);
        u++;
        while(l<=r && u<=d){

            if(u<=d){
                u2d(ans,u,d,r,ans[u-1][r]);
            }
             r--;
            if(l<=r){
                r2l(ans,r,l,d,ans[r+1][d]);
            }
            d--;
            if(u<=d){
                d2u(ans,d,u,l,ans[d+1][l]);
            }
            l++;
            if(l<=r){
                l2r(ans,l,r,u,ans[u][l-1]);
            }
            u++;
        } 
        return ans;  
    }
    public void l2r(int [][]matrix,int l,int r,int u, int start){
        matrix[u][l]=start+1;
        for(int i=l+1;i<=r;++i){
            matrix[u][i]=matrix[u][i-1]+1;
        }
    }

    public void u2d(int [][]matrix,int u,int d,int r, int start){
        matrix[u][r]=start+1;
        for(int i=u+1;i<=d;++i){
            matrix[i][r]=matrix[i-1][r]+1;
        }
    }

    public void r2l(int [][]matrix,int r,int l,int d, int start){
        matrix[d][r]=start+1;
        for(int i=r-1;i>=l;--i){
            matrix[d][i]=matrix[d][i+1]+1;
        }
    }

    public void d2u(int [][]matrix,int d,int u,int l, int start){
        matrix[d][l]=start+1;
        for(int i=d-1;i>=u;--i){
            matrix[i][l]=matrix[i+1][l]+1;
        }
    }

    public static void main(String[] args) {
        GenerateMatrix gm = new GenerateMatrix();
        int n = 2; // 可以修改为其他值测试
        int[][] result = gm.generateMatrix(n);
        
        // 打印生成的矩阵
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

}
