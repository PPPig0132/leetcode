package Array;

public class ReverseWords {
    public String reverseWords(String s) {
        s=s.trim();
        char s1[]=s.toCharArray();
        StringBuilder ans=new StringBuilder();
        StringBuilder word=new StringBuilder();
        for(int i=s1.length-1;i>-1;--i){
            while(i>-1 && s1[i]!=' '){
                word.append(s1[i]);
                --i;
            }
            if(word.length()>0){
                ans.append(word.reverse());
                ans.append(" ");
                word.setLength(0);
            }
        }
       
        return ans.toString().trim();
    }
    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String s = "a good  example";
        System.out.println(rw.reverseWords(s)); // Output: "blue is sky the"
    }
}
