package Hash;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
         if(s.length() != t.length()) return false;
        int pos[]=new int [26];
        for(char c:s.toCharArray()){
            pos[c-'a']++;
        }
        for(char c:t.toCharArray()){
           if(pos[c-'a']==0){
                return false;
            }
            pos[c-'a']--;
        }
       
        return true;
    }
    
}
