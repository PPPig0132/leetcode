package Stack;
/*判断括号是否合法*/
public class IsValid {
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        if(s.length()%2==1){
            return false;
        }
        char s1[]=s.toCharArray();
        char stack[]=new char[s1.length];
        int index=-1;
        for(char c:s1){
            if(c=='(' ||c=='['||c=='{' ){
                stack[++index]=c;
            }
            else{
                if(index==-1){
                    return false;
                }
                if(c-stack[index]<3 && c-stack[index]>0){
                    index--;
                }
                else{
                    return false;
                }
            }
        }
        return index==-1?true:false;
    }
    public static void main(String[] args) {
        IsValid i=new IsValid();
        String s="({{{{}}}))";
        System.out.println(i.isValid(s));
        s="([)]";
        System.out.println(i.isValid(s));
        s="{[]}";
        System.out.println(i.isValid(s));
    }

}
