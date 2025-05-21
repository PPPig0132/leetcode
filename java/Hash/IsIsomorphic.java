package Hash;
/*
判断两个字符串是否同构
idea：
字符串构型的表示
*/

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int count[]=new int [128],count1[]=new int[128];//统计数量
        int order []=new int[128],order1[]=new int[128];//记录顺序
        int index=0,index1=0;
        char []s1=s.toCharArray();
        char []t1=t.toCharArray();
        for(int i=0;i<s1.length;++i){
            char c=s1[i];
            if(count[c-'\0']==0){
                order[c-'\0']=index++;
            }
            count[c-'\0']++;
        }
        for(int i=0;i<t1.length;++i){
            char c=t1[i];
            if(count1[c-'\0']==0){
                order1[c-'\0']=index1++;
            }
            count1[c-'\0']++;
        }
        if(index!=index1){
            return false;
        }
        for(int i=0;i<s.length();++i){
            if(order[s1[i]-'\0']!=order1[t1[i]-'\0']){
                return false;
            }
        }
        
        return true;
    }
    public static void main(String[] args) {
        String s = "bbbaaaba";
        String t = "aaabbbab";
        IsIsomorphic isIsomorphic = new IsIsomorphic();
        boolean result = isIsomorphic.isIsomorphic(s, t);
        System.out.println(result); // Output: true
    }
}
