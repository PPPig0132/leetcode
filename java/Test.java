import java.util.*;
import ListNode.Node;

public class Test {
        
    public static void main(String[] args) {
       
        // String []c1=c.split("/");
        // for(int i=0;i<c1.length;++i){
        //     System.out.print(c1[i]+" ");
        // }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(null);
        // int a=queue.poll();
        int b=queue.peek();
        
        System.out.println(queue.isEmpty()); // Output: 4 (The longest valid parentheses substring is "()()".)
    }
}
