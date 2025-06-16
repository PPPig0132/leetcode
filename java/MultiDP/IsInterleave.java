package MultiDP;
/*
给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
*/
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if( s3.length()!=s1.length()+s2.length()) return false;
       // if(s1==null || s2==null) return true;
       
       if(s1.length()==0 ) return s2.equals(s3);
       if(s2.length()==0)  return s1.equals(s3);

        char[]s1c=s1.toCharArray(), s2c=s2.toCharArray(),s3c=s3.toCharArray();
        boolean mark[]= new boolean[s2c.length+1];
        int count=0;
        
         if(s1c[0]==s3c[0]){
            mark[0]=true;
            count++;
        }
        if(s2c[0]==s3c[0]){
            mark[1]=true;
            count++;
        }
        if(count==0) return false;
        for(int i=1;i<s2c.length;++i){
            if(mark[i]==false) break;
            if(s2c[i]==s3c[i]){
                mark[i+1]=true;
            }
        }
        
        return check(s3c,s1c,s2c,mark,1);

       
       
       
        
    }
    public boolean check(char [] s3,char []s1,char[]s2, boolean []mark,int index1){
        if(index1==s1.length+1) return mark[mark.length-1];
        if( s1[index1-1]!=s3[index1-1] || mark[0]==false ){
            mark[0]=false;
        }
        for(int i=1;i<=s2.length;++i){
            mark[i]= (mark[i] && s1[index1-1] ==s3[i+index1-1] ) ||  (mark[i-1] && s2[i-1]==s3[i+index1-1]);
           
        }
       return check(s3,s1,s2,mark, index1+1);
        
    }
    public static void main(String[] args) {
        IsInterleave solution = new IsInterleave();
        String s1 = "ab";
        String s2 = "bc";
        String s3 = "bcab";
        System.out.println(solution.isInterleave(s1, s2, s3)); // Output: true
    }
}
