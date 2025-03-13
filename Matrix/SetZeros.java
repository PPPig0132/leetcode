import java.util.Set;
import java.util.HashSet;

public class SetZeros {
    public static void main(String  args[]){
        int[][] data = {{1,1,1},{1,0,1},{1,1,1}};
        SetZeros setZeros = new SetZeros();
        setZeros.setZeroes(data);
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[i].length;j++){
                System.out.print(data[i][j]);
            }
            System.out.println();
        }

    }
     public void setZeroes(int[][] matrix) {
        Set <Integer> col = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            int j=0;
            while(j<matrix[i].length && matrix[i][j]!=0){
                j++;
            }
            if(j<matrix[i].length){
                col.add(j);
                while(j<matrix[i].length){
                    if(matrix[i][j]!=0){
                        matrix[i][j]=0;
                        j++;
                    }
                    else{
                        col.add(j);
                        j++;
                    }
                }
            }
        }

        for(int i=matrix.length-1;i>-1;i--){
            int j=matrix[i].length-1;
            int head=matrix[i][j];
            if(head==0){
                while(j>-1){
                    matrix[i][j]=0;
                    j--;
                }
            }
            else{
                while(j>-1){
                if(col.contains(j)){
                    matrix[i][j]=0;
                    j--;
                }
                else{
                    j--;
                }
            }
            }
        }
            
    }
}
