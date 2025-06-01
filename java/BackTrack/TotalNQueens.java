package BackTrack;

public class TotalNQueens {
    int ans;
    public int totalNQueens(int n) {
        ans=0;
        int rows[]=new int [n];
        backtrack(0,rows);
        return ans;
    }

    public void backtrack(int r,int[]rows){
       
        if(r==rows.length ){
            ans++;
            return;
           
        }
        for(int i=0;i<rows.length;++i){
            rows[r]=i+1;
            if(check(r, rows)){
                backtrack(r+1,rows);
            }
          
        }

    }

    boolean check(int r,int []matric){
        for(int i=0;i<r;++i){//同一列
            if(matric[i]==matric[r]){
                return false;
            }
        }
        for(int i=0;i<r;++i){//正对角线
            if(i-matric[i]==r-matric[r]){
                return false;
            }
        }
        for(int i=0;i<r;++i){//反对角线
            if(i+matric[i]==r+matric[r]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        TotalNQueens obj = new TotalNQueens();
        int n = 4;
        int result = obj.totalNQueens(n);
        System.out.println(result + " solutions found for " + n + " queens.");
    }
}
