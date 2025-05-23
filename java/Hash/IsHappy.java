package Hash;
/*
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」 定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 
*/
import java.util.*;
public class IsHappy {
    // public boolean isHappy(int n) {
    //     Set<Integer> set =new HashSet<Integer>();
    //     while(n!=1){
    //         int sum=0;
    //         while(n>0){
    //             sum+=(n%10)*(n%10);
    //             n/=10;
    //         }
    //         if(set.contains(sum)){
    //             return false;
    //         }
    //         set.add(sum);
    //         n=sum;

    //     }
    //     return true;
    // }
    
    //找环用快慢指针
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sqsum(n);
        while(slow != fast){
            slow = sqsum(slow);
            fast = sqsum(sqsum(fast));
        }
        return fast == 1;
    }
    private int sqsum(int n){
        int sum = 0;
        while(n > 0){
            int tmp = n % 10;
            sum += tmp*tmp;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        IsHappy solution = new IsHappy();
        int n=2;
        boolean result = solution.isHappy(n);
        System.out.println(result); // 输出: true
    }
    
}