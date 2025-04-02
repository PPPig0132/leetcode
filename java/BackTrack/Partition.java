package BackTrack;
import java.util.*;
/*
回溯终止条件：遍历完字符串（start==end）
            当前字串不是回文串

 check():检查当前子串是不是回文，如果是回文则将当前字串添加到结果中,字串长度+1，如果不是则返回，index+1
 */

public class Partition {
    public static void main(String args[]){
        String s="aab";
        Partition obj=new Partition();
        List<List<String>> ans=obj.partition(s);
        for(List<String> list:ans){
            System.out.println(list);
        }
    }
     public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<List<String>>();
        backtrack(res,new ArrayList<String>(),s,0);
        return res;
    }

    public void backtrack(List<List<String>> res,List<String> temp, String s, int index){
        if(index==s.length()){
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int i=index;i<s.length();++i){
            if(check(s,index,i)){
                temp.add(s.substring(index,i+1));
                backtrack(res,temp,s,i+1);
                temp.remove(temp.size()-1);
            }
        }

    }

    public boolean check(String s,int start,int end){
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
