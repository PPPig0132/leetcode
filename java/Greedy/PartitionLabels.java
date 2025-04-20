package Greedy;
import java.util.*;
/*
给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。

注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。

返回一个表示每个字符串片段的长度的列表。

idea:
从后往前扫描到当前首字母最后一次出现的位置（end），
再从往前扫，扫到第一个在字符串（start,end）中包含的字母，更新end
，出现则end后移，直到扫到第一个没有出现的为止

idea:Hash表

Idea3：统计每个字母出现的次数（optimal,访问数组速度比hash表快）
统计每个字符的出现次数：使用数组 arr。
遍历字符串并划分分区：使用 cnt 和 num 来跟踪当前分区的剩余字符数和长度。
返回结果：将每个分区的长度加入结果列表 res。
*/
public class PartitionLabels {
    //  public List<Integer> partitionLabels(String s) {
    //     List<Integer> ans=new ArrayList<Integer>();
    //     int start=0,end=1;
    //     while(end<s.length()-1&&end!=start){
    //         //找到首字母最后一次出现
    //         for(int i=s.length()-1;i>=start;i--){
    //             if(s.charAt(i)==s.charAt(start)){
    //                 end=i;
    //                 break;
    //             }
    //         }//找到子字符串中end以后第一个包含的字母，更新end
    //         int flag=1;
    //         while(flag==1){
    //             flag=0;
    //             for(int i=s.length()-1;i>end;i--){
    //                 String temp=s.substring(start,end);
    //                 if(temp.contains(""+s.charAt(i))){
    //                     end=i;
    //                     flag=1;
    //                 }
    //             }
    //         }
    //         ans.add(end+1-start);
    //         start=end+1;
    //     }
    //     return ans;
        
    // }
    // public List<Integer> partitionLabels(String s) {
    //     List<Integer> ans=new ArrayList<Integer>();
    //     Map<Character,Integer> pos=new HashMap<Character,Integer>();
    //     for(int i=0;i<s.length();++i){
    //         char c=s.charAt(i);
    //         pos.put(c,i);
    //     }
    //     int start=0;

    //     while(start<s.length()){
    //         int end=pos.get(s.charAt(start));
    //         for(int i=start+1;i<end;++i){
    //             char c=s.charAt(i);
    //             end=Math.max(end,pos.get(c));
    //         }
    //         ans.add(end+1-start);
    //         start=end+1;
    //     }
       
    //     return ans;
        
    // }

    // public List<Integer> partitionLabels(String s) {
    //     List<Integer> ans=new ArrayList<Integer>();
    //     Map<Character,Integer> pos=new HashMap<Character,Integer>();
    //     for(int i=0;i<s.length();++i){
    //         char c=s.charAt(i);
    //         pos.put(c,i);
    //     }
    //     int max=pos.get(s.charAt(0)),sum=-1;
    //     for(int i=0;i<s.length();++i){
    //         char c=s.charAt(i);
    //         max=Math.max(max,pos.get(c));
    //         if(i==max){
    //             ans.add(max-sum);
    //             sum=max;
                  
    //           }
    //     }
       
    //     return ans;
        
    // }

    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        List<Integer> res = new ArrayList<>();
        char[] ch = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            arr[ch[i] - 'a'] ++;
        }
        int num = 0;
        int cnt = 0;
        for (int i = 0; i < len; i ++) {
            cnt += arr[ch[i] - 'a'] - 1;//当前区间剩余字符数
            arr[ch[i] - 'a'] = 0;//后续每出现一次就-1
            num ++;
            if (cnt == 0) {
                res.add(num);
                num = 0;
            }
        }
        return res;
    }
    public static void main(String args[]){
        String s="eaaaabaaec";
        PartitionLabels obj=new PartitionLabels();
        List<Integer> ans=obj.partitionLabels(s);
        for(int i:ans){
            System.out.println(i);
        }
    }
}
