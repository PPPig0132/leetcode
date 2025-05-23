/*
请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
*/

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;++i){
            int mark[]=new int[10];
            for(int j=0;j<9;++j){
                if(board[i][j]=='.'){
                    continue;
                }
                mark[board[i][j]-'0']++;
                if(mark[board[i][j]-'0']>1){
                    return false;
                }
            }
            
        }
        for(int i=0;i<9;++i){
            int mark[]=new int[10];
            for(int j=0;j<9;++j){
                if(board[j][i]=='.'){
                    continue;
                }
                mark[board[j][i]-'0']++;
                if(mark[board[j][i]-'0']>1){
                    return false;
                }
            }
            
        }
        int row=0;
        while(row<9){
            int col=0;
            while(col<9){
                int mark[]=new int[10];
                for(int i=row;i<row+3;++i){
                    for(int j=col;j<col+3 ;j++){
                        if(board[i][j]=='.'){
                            continue;
                        }
                        mark[board[i][j]-'0']++;
                        if(mark[board[i][j]-'0']>1){
                            return false;
                        }

                    }
                    
                }
            col+=3;
        }
            row+=3;

        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '2', '.', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        IsValidSudoku sudoku = new IsValidSudoku();
        System.out.println(sudoku.isValidSudoku(board)); // Output: false
    }
}
