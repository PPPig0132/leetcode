package MultiDP;
/*
给你一个字符串 s，找到 s 中最长的 回文 子串。
idea:
我们用 P(i,j) 表示字符串 s 的第 i 到 j 个字母组成的串（下文表示成 s[i:j]）是否为回文串：
P(i,j) = P(i+ 1,j- 1) ^ (Si == Sj)
*/
public class LongestPalindrome {
    // public String longestPalindrome(String s) {
    //     int len = s.length();
    //     if (len < 2) {
    //         return s;
    //     }

    //     int maxLen = 1;
    //     int begin = 0;
    //     // dp[i][j] 表示 s[i..j] 是否是回文串
    //     boolean[][] dp = new boolean[len][len];
    //     // 初始化：所有长度为 1 的子串都是回文串
    //     for (int i = 0; i < len; i++) {
    //         dp[i][i] = true;
    //     }

    //     char[] charArray = s.toCharArray();
    //     // 递推开始
    //     // 先枚举子串长度
    //     for (int L = 2; L <= len; L++) {
    //         // 枚举左边界，左边界的上限设置可以宽松一些
    //         for (int i = 0; i < len; i++) {
    //             // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
    //             int j = L + i - 1;
    //             // 如果右边界越界，就可以退出当前循环
    //             if (j >= len) {
    //                 break;
    //             }

    //             if (charArray[i] != charArray[j]) {
    //                 dp[i][j] = false;
    //             } else {
    //                 if (j - i < 3) {
    //                     dp[i][j] = true;
    //                 } else {
    //                     dp[i][j] = dp[i + 1][j - 1];
    //                 }
    //             }

    //             // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
    //             if (dp[i][j] && j - i + 1 > maxLen) {
    //                 maxLen = j - i + 1;
    //                 begin = i;
    //             }
    //         }
    //     }
    //     return s.substring(begin, begin + maxLen);
    // }
    public String longestPalindrome(String s) {
        int begin = 0;
        int maxLen = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {//0和1对应回文串长度为奇数和偶数的情况
                int l = i;
                int r = i+j;
                while (l >= 0 && r < n && chars[l] == chars[r]) {
                    l--;
                    r++;
                }
                l++;
                r--;
                int len = r-l+1;
                if (len > maxLen) {
                    maxLen = len;
                    begin = l;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }


   
    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        String s = "xaabacxcabaaxcabaax";
        System.out.println(solution.longestPalindrome(s)); // Output: "bab" or "aba"
    }
}
