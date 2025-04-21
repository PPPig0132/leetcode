package MultiDP;

/*
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符

idea:

当word2是word1的子串时，只要删掉多余的非子串部分就行了

找出word1和word2的最长公共子串 

dp(i,j)表示word1[0:i]到word2[0:j]所需要的次数,w2[0:i] 从0开始 长度为i

如果w1[i]==w2[j],dp[i,j]=dp[i-1,j-1]

如果 word1[i-1] 不等于 word2[j-1]，那么 dp[i][j] 就是 dp[i-1][j-1]、dp[i-1][j] 和 dp[i][j-1] 中的最小值加 1，分别对应替换、删除和插入操作。
dp[i,0]=i,dp[0,j]=jb

*/

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int ans[][]=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            ans[i][0] = i; // word2 为空，需要删除 word1 的所有字符
        }
        for (int j = 0; j <= n; j++) {
            ans[0][j] = j; // word1 为空，需要插入 word2 的所有字符
        }
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
               
                
                    if(word1.charAt(i-1)==word2.charAt(j-1)){
                        ans[i][j]=ans[i-1][j-1];
                    }
                    else{
                        ans[i][j]=Math.min(Math.min(ans[i][j-1],ans[i-1][j]),ans[i-1][j-1])+1;
                    }
                }
                
            }
      
        return ans[m][n];
    }
    public static void main(String[] args) {
        MinDistance solution = new MinDistance();
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(solution.minDistance(word1, word2)); // Output: 3 (The operations are [replace 'h' with 'r', delete 'e', and insert 's'].)
    }
    
}
