package RollWindow;
/*
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
有解则该解唯一
*/
public class MinWindow {
    public String minWindow(String s, String t) {
        int m=s.length(),n=t.length();
        char s1[]=s.toCharArray(),t1[]=t.toCharArray();
        if(n>m){
            return new String();
        }
        int pos[]=new int[52];
        int count=0,start=0,end=0,l=0,r=0,min=m+1;
        for(int i=0;i<n;++i){
            char c=t1[i];
            if(c>='a'&&c<='z'){
                if(pos[c-'a']==0){
                    count++;
                }
                pos[c-'a']++;
            }
            else{
                if(pos[26+c-'A']==0){
                    count++;
                }
                pos[26+c-'A']++;
            }
        }
        //统计一共有多少种字母
        
        do{
            while(count>0&& end<m){
                char c=s1[end];
                if(c>='a'&&c<='z'){
                        pos[c-'a']--;
                        if( pos[c-'a']==0){
                            count--;
                        }
                    }
                    else{
                        pos[26+c-'A']--;
                        if( pos[26+c-'A']==0){
                            count--;
                        }
                    }
                    end++;
            }
            if(end==m && start==0&&count>0){
                return new String();
            }
            while(count<1){
                char c=s1[start];
                if(c>='a'&&c<='z'){
                        pos[c-'a']++;
                        if( pos[c-'a']>0){
                            count++;
                        }
                    }
                    else{
                        pos[26+c-'A']++;
                        if( pos[26+c-'A']>0){
                            count++;
                        }
                    }
                    start++;
                    if(end-start<min){
                        min=end-start;
                        l=start;
                        r=end;
                    }
            }
            
        }while(end<m);
       
       return s.substring(l-1,r);
    }
    public static void main(String[] args) {
        MinWindow minWindow=new MinWindow();
        String s="ab",t="a";
        String ans=minWindow.minWindow(s,t);
        System.out.println(ans);
    }
}
