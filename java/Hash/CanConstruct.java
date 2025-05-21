package Hash;
/*
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。
ransomNote 和 magazine 由小写英文字母组成
*/

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int rc[]=new int [26],mc[]=new int [26];
        char []r1=ransomNote.toCharArray(),m1=magazine.toCharArray();
        int m=r1.length,n=m1.length;
        for(int i=0;i<m;++i){
            rc[r1[i]-'a']++;
        }
        for(int i=0;i<n;++i){
            mc[m1[i]-'a']++;
        }
        for(int i=0;i<26;++i){
            if(rc[i]>mc[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        CanConstruct canConstruct = new CanConstruct();
        boolean result = canConstruct.canConstruct(ransomNote, magazine);
        System.out.println(result); // Output: false
    }
    
}
