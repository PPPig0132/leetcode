package BackTrack;
/*将字符串还原为有效ip地址，返回所有可用的ip地址*/
import java.util.*;
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        int n=s.length();
        if(n<4 || n>12) return new ArrayList<>();
        List<String> ans =new ArrayList<>();
        backtrack(s,0,ans,new StringBuilder(),0);
        return ans;
    }
    public void backtrack(String s,int idx, List<String> ans, StringBuilder sb,int count){
        if(count==4){
            ans.add(sb.toString());
            return;
        }
        if(idx>=s.length()) return;
        if(s.length()-idx>(4-count)*3 || s.length()-idx<3-count ) return;
        if(count==3){
            int x=Integer.parseInt(s.substring(idx,s.length()));
            if(x==0 && idx==s.length()-1 || s.charAt(idx)!='0' && x<256 ){
                sb.append(s.substring(idx,s.length()));
                backtrack(s, idx, ans, sb, count+1);
                sb.delete(sb.length()-(s.length()-idx), sb.length());
            }
            return;
        }
        
        sb.append(s.charAt(idx));
        sb.append('.');
        backtrack(s,idx+1,ans,sb,count+1);
        sb.deleteCharAt(sb.length()-1);
        sb.delete(sb.length()-1,sb.length());

        if(s.charAt(idx)=='0') return;//排除前置0

        if(s.length()-idx>2){
            sb.append(s.substring(idx,idx+2));
            sb.append('.');
            backtrack(s,idx+2,ans,sb,count+1);
            sb.deleteCharAt(sb.length()-1);
            sb.delete(sb.length()-2,sb.length());
        }
        
        if(s.length()-idx>3){
             sb.append(s.substring(idx,idx+3));
             sb.append('.');
            if(Integer.parseInt(s.substring(idx,idx+3))<256){
                backtrack(s,idx+3,ans,sb,count+1);
            }
            sb.deleteCharAt(sb.length()-1);
            sb.delete(sb.length()-3,sb.length());
        }
       
       
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        String s = "00000";
        List<String> result = restoreIpAddresses.restoreIpAddresses(s); 
        for (String ip : result) {
            System.out.println(ip);
        }
    }
}
