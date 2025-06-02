package BitOperation;
/*
给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中 设置位 的个数（也被称为汉明重量）。
*/
public class HammingWeight {
    public int hammingWeight(int n) {
        int count=0;
        while(n>0){
            if((n & 1)==1){//位运算符的优先级低于bool运算符
                count++;
            }
            n=n>>1;
        }
        return count;
        
    }
    public static void main(String[] args) {
        HammingWeight solution = new HammingWeight();
        int n = 11; // 二进制形式为 1011
        System.out.println(solution.hammingWeight(n)); // 输出: 3 (二进制中有三个 '1')
    }
    
}
