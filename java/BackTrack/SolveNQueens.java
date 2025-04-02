package BackTrack;
import java.util.*;
/*
  这个问题是一个经典的回溯问题，要求在 n x n 的棋盘上放置 n 个皇后，使得它们不能互相攻击。
  皇后可以攻击同一行、同一列和同一对角线上的其他皇后。

  回溯：
  在每个位置尝试放置棋子，放置棋子后将该棋子可攻击的位置置为不可放置，同时更新棋盘中的位置
  终止条件：棋盘上已经没有能放棋子的位置了，此时判断（count?n）
*/

public class SolveNQueens {
    public static void main(String args[]){
        int n=4;
        SolveNQueens obj=new SolveNQueens();
        List<List<String>> ans=obj.solveNQueens(n);
        
        for(List<String> list:ans){
            System.out.println(list);
        }
        System.out.println(ans.size());
    }
     public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<List<String>>();
        char[][] pos= new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pos[i][j]='.';
            }
        }
        backtrack(res,pos,0,0);
        return res;
    }

    public void backtrack(List<List<String>> res,char[][] pos,int count,int r){
        int n=pos.length;
        if(r==n){
            if(count==n){
                List<String> temp=new ArrayList<String>();
                    for(char[] str1:pos){
                    temp.add(new String(str1));
                    }
                    res.add(new ArrayList<String>(temp));
                    return;
            }

            return;
        }
        // 遍历每一列，r已经确定了行数，不需要再增加一个for循环，只遍历列就行
            for(int j=0;j<n;j++){
                if(!check(pos,r,j)){
                    pos[r][j]='Q';
                    backtrack(res,pos,count+1,r+1);
                    pos[r][j]='.';
                }
            }

            // for(int i=r; i<n;i++){
            //     for(int j=0;j<n;j++){
            //         if(!check(pos,i,j)){
            //             pos[i][j]='Q';
            //             count++;
            //             backtrack(res,pos,count,r+1);
            //             count--;
            //             pos[i][j]='.';
            //         }
            //     }}
    }
    boolean check(char[][]board, int i, int j){
        int n = board.length;
        for (int k = 0; k < n; k++) {
            if (k != j && board[i][k] == 'Q') {
                return true;
            }
        }
        // 检查同一列
        for (int k = 0; k < n; k++) {
            if (k != i && board[k][j] == 'Q') {
                return true;
            }
        }
        // 检查主对角线方向
        for (int k = 0; k < n; k++) {
            int l = k + (j - i);
            if (l >= 0 && l < n && (k != i || l != j) && board[k][l] == 'Q') {
                return true;
            }
        }

        // 检查副对角线方向
        for (int k = 0; k < n; k++) {
            int l = (i + j) - k;
            if (l >= 0 && l < n && (k != i || l != j) && board[k][l] == 'Q') {
                return true;
            }
        }
        return false;
    }
    
}
