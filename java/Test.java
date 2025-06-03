import java.util.*;
import ListNode.Node;

public class Test {
        
    public static void main(String[] args) {
       
        // String []c1=c.split("/");
        // for(int i=0;i<c1.length;++i){
        //     System.out.print(c1[i]+" ");
        // }
<<<<<<< HEAD
       int x=15;
       Long res=289398L*289398L;
       for(int i=1;i<=x;++i){
          
                res*=i;
            }
          
        
        System.out.println(289398*289398);
        System.out.println(res);
         System.out.println(46340*46340); // Output: 4 (The longest valid parentheses substring is "()()".)
=======
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(null);
        // int a=queue.poll();
        int b=queue.peek();
        
        System.out.println(queue.isEmpty()); // Output: 4 (The longest valid parentheses substring is "()()".)
>>>>>>> parent of 3893e01 (Merge pull request #17 from PPPig0132/asus)
    }
}
