package RollWindow;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int pos[]=new int[128];
        int n=s.length();
        
        if(n<=1){
            return n;
        }
        char s1[]=s.toCharArray();//将字符串转化为字符数组可以提高效率
        int ans=1,start=0,end=0;
        do{
            while(end<n && pos[s1[end]-'\0']!=1){
                pos[s1[end]-'\0']++;
                end++;
            }
            ans=Math.max(ans,end-start);
             if(end==n){
                return ans;
            }

            while(start<=end &&s1[start]!=s1[end]){
                pos[s1[start]-'\0']--;
                start++;
            }
            start++;
            end++;

        }
        while(end<n);
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring=new LengthOfLongestSubstring();
        String s="au";
        int ans=lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.out.println(ans);
        // System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }
}
