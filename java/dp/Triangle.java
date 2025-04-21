package dp;
import java.util.*;
/*
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

 */
public class Triangle {
    public List<List<Integer>> generate(int numRows) {
        int []pos1=new int[numRows];
        int []pos2=new int[numRows];
        int []pre;int []now;
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        //ans.add( Arrays.asList(1))
        int len=1;
        while(len<=numRows){
            List<Integer>temp=new ArrayList<Integer>();
            pre=(len%2==1)?pos1:pos2;
            now=(len%2==0)?pos1:pos2;
            for(int i=0;i<len;i++){
               if(i==0||i==len){
                now[i]=1;
               }
               else{
                now[i]=pre[i-1]+pre[i];
               }
               temp.add(now[i]);
            }
            ans.add(temp);
            len++;
        }
        return ans;
    }
    public static void main(String args[]){
        int numRows=5;
        Triangle obj=new Triangle();
        List<List<Integer>> ans=obj.generate(numRows);
        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
}
