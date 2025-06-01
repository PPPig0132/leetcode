package Graph;
/*
被围绕的区域
给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
*/
public class Solve {
    int [][]mark;
    public void solve(char[][] board) {
        int m=board.length,n=board[0].length;
        mark=new int[m][n];

        for(int i=0;i<m;++i){
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }
            if(board[i][n-1]=='O'){
                dfs(i,n-1,board);
            }
        }

        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(0,i,board);
            }
            if(board[m-1][i]=='O') {
                dfs(m-1,i,board);
            }
        }

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(board[i][j]=='O' && mark[i][j]==0 ) board[i][j]='X';
            }
        }
        
    }
    public void dfs(int r,int c,char[][]board){
        if(r<0||r==board.length||c<0||c==board[0].length || mark[r][c]==1 || board[r][c]=='X'){
            return;
        }
        mark[r][c]=1;
        dfs(r+1,c,board);
        dfs(r-1,c,board);
        dfs(r,c+1,board);
        dfs(r,c-1,board);

    }
    public static void main(String[] args) {
        // 测试代码
        char[][] board = {
            {'O', 'X', 'X', 'O', 'X'},
            {'X', 'O', 'O', 'X', 'O'},
            {'X', 'O', 'X', 'O', 'X'},
            {'O', 'X', 'O', 'O', 'O'},
            {'X', 'X', 'O', 'X', 'O'}

        };

        Solve solution = new Solve();
        solution.solve(board);

        // 输出结果
        for (char[] row : board) {
            System.out.println(row);
        }
    }
}
