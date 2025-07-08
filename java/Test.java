import java.math.BigDecimal;
import java.util.*;
import ListNode.Node;


class Animal {
    void makeSound() {
        System.out.println("这个动物在发出声音。");
    }
}
 
class Dog extends Animal {
    void makeSound() {
        System.out.println("这个狗在汪汪叫。");
    }
    void makeMove() {
        System.out.println("这个狗在欢快地奔跑。");
    }
}

public class Test {
        
    public static void main(String[] args) {
       
       int nums[]=new int[]{1,2,2};
       StringBuilder sb = new StringBuilder();
       for(int i=0;i<nums.length;i++){
           sb.append(nums[i]);
       }
       System.out.println(sb.toString());
       while(!sb.isEmpty()){
           sb.deleteCharAt(sb.length()-1);
       }
       System.out.println(sb.toString());
    }
         
}
