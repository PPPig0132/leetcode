import java.util.*;
import ListNode.Node;

public class Test {
        
    public static void main(String[] args) {
       
        // String []c1=c.split("/");
        // for(int i=0;i<c1.length;++i){
        //     System.out.print(c1[i]+" ");
        // }

       int x=15;
       Long res=289398L*289398L;
       for(int i=1;i<=x;++i){
          
                res*=i;
            }
          
        
        System.out.println(289398*289398);
        System.out.println(res);
    }
        
}
