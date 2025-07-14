package BitOperation;
/*
给你一个二进制字符串 s 和一个正整数 k 。

请你返回 s 的 最长 子序列的长度，且该子序列对应的 二进制 数字小于等于 k 。

注意：

子序列可以有 前导 0 。
空字符串视为 0 。
子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。


idea:在字符串中从右往左找到一个小于等于K的子串，然后统计前面为0的数量
*/
public class LongestSubsequence {
    public int longestSubsequence(String s, int k) {
         String s1=toBinaryString(k); //将k转换为二进制字符串
        int n=s.length(),n2=s1.length();
       
        if(n<n2) return n; //如果s的二进制数值 小于等于k，则返回s的长度)

        int ans=n2,index=n-n2;
       for(int i=0;i<n2;++i){
            if(s.charAt(index+i)<s1.charAt(i)){
                break; //如果s的二进制数值 大于k，则返回0
            }
            if(s.charAt(index+i)>s1.charAt(i)){
                ans--;
                break; //如果s的二进制数值 大于k，则返回0
            }
        }
        index--;
        while(index>=0){
            if(s.charAt(index)=='0'){
                ans++;
            }
            index--;
        }
        return ans;
    } 
    public String  toBinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n&1);
            n = n>>1;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        LongestSubsequence ls = new LongestSubsequence();
        String s = "00101001"; // 示例二进制字符串
        int k = 1; // 示例整数
        String binaryString = ls.toBinaryString(k);
        //int x=Integer.MAX_VALUE; // 最大整数值
        int result = ls.longestSubsequence(s, k);
        System.out.println("最长子序列的长度: " + result); // 输出结果
    }
}
