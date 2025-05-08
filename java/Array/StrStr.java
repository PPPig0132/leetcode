package Array;

public class StrStr {
    public int strStr(String haystack, String needle) {
            if(haystack.contains(needle)){
                return haystack.indexOf(needle);
            }
            return -1;
    
        }
    public static void main(String[] args) {
        StrStr ss = new StrStr();
        String haystack = "hello", needle = "ll";
        System.out.println(ss.strStr(haystack, needle)); // Output: 2
    }
    
}
