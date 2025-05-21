/*
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
plus of setZeroes
*/
import java.util.Arrays;
public class SetZerosII {

    public void setZeroes(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        boolean rows[]=new boolean[m],cols[]=new boolean[n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(matrix[i][j]==0){
                    rows[i]=true;
                    cols[j]=true;
                }
            }
        }
        
        
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        SetZerosII setZerosII = new SetZerosII();
        setZerosII.setZeroes(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}
