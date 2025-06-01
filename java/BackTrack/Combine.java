package BackTrack;

import java.util.*;

class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        List<Integer>item= new ArrayList<>();
        backtrack(1,n,k,ans,item);
        return ans;
    }
    public void backtrack(int start,int n,int k,List<List<Integer>>ans,List<Integer>cur ){
        if(k==0){
           ans.add(new ArrayList<Integer>(cur));//添加cur的副本 不影响原有的cur
            return;
        }
        for(int i=start;i<=n;++i){
            cur.add(i);
            backtrack(i+1,n,k-1,ans,cur);
            cur.remove(cur.size()-1);
        }

    }
    public static void main(String[] args) {
        Combine obj = new Combine();
        int n = 4, k = 2;
        List<List<Integer>> result = obj.combine(n, k);
        System.out.println(result.size() + " combinations found:");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}