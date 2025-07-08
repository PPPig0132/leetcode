package dp;

/*
给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。如果没有合法的方式解码整个字符串，返回 0
注：06不是合法解码方式（6才是合法解码方式）
回溯超时
*/
public class NumDecodings {
   public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        // dp[i] 表示字符串 s 的前 i 个字符的解码方法数
        dp[0] = 1; // 空字符串有一种解码方法
        dp[1] = 1; // 单个字符的解码方法数

        for (int i = 2; i <= n; i++) {
            // 检查单个字符是否有效
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // 检查两个字符是否有效
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        String s = "2611055971756562";
        int result = numDecodings.numDecodings(s);
        System.out.println("解码方法的总数: " + result); // 输出: 3
    }
}