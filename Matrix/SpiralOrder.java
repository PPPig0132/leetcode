
import java.util.*;

public class SpiralOrder {
    public static void main(String []args){
        int [][]data={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> ans=spiralOrder.spiralOrder(data);
        System.out.println(ans.size());
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }

    } 
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans =new ArrayList<Integer>();
        int h=matrix.length;
        int w=matrix[0].length;
        int l,r,d,u;
        l=0;d=0;r=w-1;u=h-1;
        while(r>l && u>d){
            for(int i=l;i<r+1;i++){
                ans.add(matrix[d][i]);
            }
            d+=1;
    
            for(int i=d;i<u+1;i++){
                ans.add(matrix[i][r]);
            }
            r-=1;
    
            for(int i=r;i>l-1;i--){
                ans.add(matrix[u][i]);
            }
            u-=1;
    
            for(int i=u;i>d-1;i--){
                ans.add(matrix[i][l]);
            }
            l+=1;
    
        }
        if(r>l && u==d){
            for(int i=l;i<r+1;i++){
                ans.add(matrix[u][i]);
            }
        }
        if(u>d && l==r){
            for(int i=d;i<u+1;i++){
                ans.add(matrix[i][l]);
            }
        }
        if(u==l && l==r){
            ans.add(matrix[l][u]);
        }
    
        return ans;
    
            
        }
}
