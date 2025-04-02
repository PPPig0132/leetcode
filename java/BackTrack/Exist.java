package BackTrack;
import java.util.*;
public class Exist {
    public static void main(String args[]){
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board1={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        String word1="SEE";
        String word2="ABCB";
        Exist obj=new Exist();
        boolean ans=obj.exist(board1,word1);
        System.out.println(ans);
    }

    public boolean exist(char[][] board, String word) {
        int R=board.length,C=board[0].length;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j]==word.charAt(0)){
                    if(backtrack(board,word,i,j,0)){
                        return true;
                    }
                }
                continue;
            }
        }
       return false;
        
    }
    public boolean backtrack(char[][] board,String word,int r,int c,int index){

        if(index==word.length()){
            return true;
            }
        if(!inarea(board, r, c) || board[r][c]!=word.charAt(index)){
            return false;
        }
        char temp=board[r][c];
        board[r][c]='*'; // mark as visited
       boolean ans= backtrack(board,word,r+1,c,index+1)||backtrack(board,word,r-1,c,index+1)||backtrack(board,word,r,c+1,index+1)||backtrack(board,word,r,c-1,index+1);
       board[r][c]=temp;

       return ans;
    }

    public boolean inarea(char[][] board,int r,int c){
        int nr=board.length,nc=board[0].length;
        if(0<=r&&r<nr&&0<=c&&c<nc){
            return true;
        }
        return false;
    }
    
}
