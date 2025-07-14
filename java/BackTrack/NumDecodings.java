package BackTrack;
/*
给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。如果没有合法的方式解码整个字符串，返回 0
注：06不是合法解码方式（6才是合法解码方式）
回溯超时
*/
public class NumDecodings {
    private int ans;
    public int numDecodings(String s) {
        ans=0;
        backtrack(s,0,new StringBuilder());
        return ans;
    }
    public void backtrack(String s,int idx,StringBuilder sb){
        if(idx>=s.length()){
            this.ans+=1;
            System.out.println(sb.toString());
            return;
        }
            if(s.charAt(idx)=='0') return;
            sb.append(1);
            backtrack(s,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
            if(idx<s.length()-1 && (s.charAt(idx)-'0'<3)){
                sb.append(2);
                if(s.charAt(idx)=='1' || s.charAt(idx+1)-'0'<7) backtrack(s,idx+2,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        
        
    }
    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        String s = "2611055971756562";
        int result = numDecodings.numDecodings(s);
        System.out.println("解码方法的总数: " + result); // 输出: 3
    }
}
