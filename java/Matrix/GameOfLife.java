/*
扫描

*/
import java.util.Arrays;
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m=board.length,n=board[0].length;
        int c[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;++j){
                c[i][j]=check(board,i,j,m,n);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;++j){
                if(c[i][j]>3){
                    if(board[i][j]==1){
                        board[i][j]=0;
                    }
                }
                else if(c[i][j]==3){
                    if(board[i][j]==0){
                        board[i][j]=1;
                    }
                }
                else if(c[i][j]<2){
                    if(board[i][j]==1){
                        board[i][j]=0;
                    }
                }
            }
        }

        
    }
    public int check(int [][]board,int r, int c,int m,int n){
        int ans=0;
        for(int i=r-1;i<=r+1;++i){
            for(int j=c-1;j<=c+1;++j){
                if(check(i,j,m,n)&&board[i][j]==1){
                    ans++;
                }

            }
        }
        if(board[r][c]==1){
            return ans-1;
        }
        return ans;
    }
    public boolean check(int i,int j,int m, int n){
        if(i>-1&&i<m&&j>-1&&j<n){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(board);
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    
}
