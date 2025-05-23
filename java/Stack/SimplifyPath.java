package Stack;
import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {
        String []p=path.split("/");
        String []stack=new String[p.length];
        int index=-1;
        for(String s:p){
            if(s.length()==0){
                continue;
            }
            if(s.equals(".")){
                continue;
            }
            else if(s.equals("..")){
                if(index>-1){
                    index--;
                }
            }
            else{
                stack[++index]=s;
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append('/');
        if(index>-1){
            for(int i=0;i<=index-1;++i){
                sb.append(stack[i]);
                sb.append('/');
            }
            sb.append(stack[index]);
        }
        
        return sb.toString();
    }
    public static void main(String[] args) {
        SimplifyPath s=new SimplifyPath();
        String path="/a/./b/../../c/";
        System.out.println(s.simplifyPath(path));
        path="/../";
        System.out.println(s.simplifyPath(path));
        path="/home//foo/";
        System.out.println(s.simplifyPath(path));
    }
    
}
