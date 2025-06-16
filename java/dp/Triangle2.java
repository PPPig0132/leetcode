package dp;
/*给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。*/
import java.util.*;

public class Triangle2 {
    public List<Integer> getRow(int rowIndex) {
        int []row=new int[rowIndex+1];
        row[0]=1;
        dp(row,1);
        List<Integer>ans=new ArrayList<>();
        for(int i:row){
            ans.add(i);
        }
        return ans;
        
    }
    public void dp(int []row,int index){
        if(index==row.length) return;
        row[index]=1;
        for(int i=index-1;i>0;--i){
            row[i]=row[i-1]+row[i];
        }
        dp(row,index+1);
    }
    public static void main(String[] args) {
        // Example usage
        int rowIndex = 0; // Change this to test different row indices
        Triangle2 triangle = new Triangle2();
        List<Integer> result = triangle.getRow(rowIndex);
        
        // Print the result
        System.out.println("Row " + rowIndex + ": " + result);
    }
}
