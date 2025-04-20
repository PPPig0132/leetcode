package MultiDP;
/*
给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

idea:
子串分割问题类似于上一题最长回文串
在较长的字串(s1)中找较小的字串(s2)的公共字串
p(i,j)表示长字串中是否存在由s2[i]和s2[j]组成的子串

s[1,2,3]=s[s1,2]&&s[2,3]

 */

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length();
        String s1=m>n?text1:text2;//较长的字符串
        String s2=m>n?text2:text1;//较短的字符串
        boolean ans[][]=new boolean[s1.length()][s1.length()];
        int exist[]=new int[26];
        for(int i=0;i<s1.length();++i){
            exist[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();++i){
            if(exist[s2.charAt(i)-'a']==0){
                continue;
            }
            for(int j=i+1;j<s2.length();++j){
                //  if(exist[s2.charAt(j)-'a']==0){
                //         continue;
                //     }
                   contains(s1,s2.charAt(i),s2.charAt(j),ans);
            }
            //ans[i][i]=true;
        }
        int max=0;
        for(int i=0;i<s1.length();++i){//dfs找路
            int len=0;
            for(int j=0;j<s1.length();++j){ 
                if(ans[j][i]==true){
                    len++;
                }

            }
            max=Math.max(len,max);

        }

        for(int i=0;i<s1.length();++i){//dfs找路
            for(int j=0;j<s1.length();++j){ 
                if(ans[i][j]==true){
                    System.out.print(1+"");
                }
                else{
                    System.out.print(0+"");
                }

            }
            System.out.print("\n");
           

        }
        
        return max;

        
    }
    public void contains(String s,char c1,char c2,boolean[][] ans){
        int flag=0,x=0,y=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)==c1 && flag==0){
                flag=1;
                x=i;
                ans[x][x]=true;
                continue;
            }
            if(s.charAt(i)==c2 && flag==1){
                y=i;
               ans[x][y]=true;
               ans[y][y]=true;
                break;
            }
        }
    }
    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        String text1 = "abcba", text2 = "abcbcba";
        System.out.println(solution.longestCommonSubsequence(text1, text2)); // Output: 3 (The longest common subsequence is "ace" and its length is 3.)
    }
    
}
