import java.math.BigDecimal;
import java.util.*;
import ListNode.Node;

public class Test {
        
    public static void main(String[] args) {
       
       char []num=new char[3];
       num[0]=0;
       num[1]=1;
       num[2]=2;
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < num.length; i++) {
           num[i]+='0'; // 将数字转换为字符
           sb.append(num[i]);
       }
       String s1=new String("0");
       System.out.println(s1+"    "+sb.toString());

        
    }
         
}
