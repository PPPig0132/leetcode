
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class solution12 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        String s1 = "a", t1 = "a";
        String s2 = "aaaaaaaaaaaabbbbbcdd", t2 = "abcdd";
        solution12 solution = new solution12();
        System.out.println(solution.minWindow(s2, t2));
        
    }

  
    // public String minWindow(String s, String t) {
    //     int m=s.length();
    //     int n=t.length();
    //     int min=m;
    //     String minans="";
    //     int [] arr1=new int[52];
    //     Map<Character, Queue<Integer>> queues = new HashMap<>();

    //     // 创建 26 个队列，分别以字母 a-z 命名
    //     for (char c = 'a'; c <= 'z'; c++) {
    //         queues.put(c, new LinkedList<>()); // 使用 LinkedList 实现队列
    //     }
    //     for (char c = 'A'; c <= 'Z'; c++) {
    //         queues.put(c, new LinkedList<>()); // 使用 LinkedList 实现队列
    //     }
    //     Queue<Integer> ans=new LinkedList<>();
    //     for(int i=0;i<n;i++){
    //         char x= t.charAt(i);
    //         if(x>='A'&&x<='Z'){
    //             arr1[x-'a'+58]++;
    //         }
    //         else if(x>='a'&&x<='z'){
    //             arr1[x-'a']++;
    //         }
    //         // arr1[x-'a']++;
    //     }
    //     for(int i=0;i<52;i++){
    //         if(arr1[i]==0){
    //             arr1[i]=-2;
    //         }
    //     }
    //     for(int i=0;i<m;i++){
    //         char x=s.charAt(i);
    //         if(x>='A'&&x<='Z'){
    //             if(arr1[x-'a'+58]>0){
    //                 arr1[x-'a'+58]--;
    //                 ans.offer(i);
    //                 queues.get(x).add(i);
    //                 if(ans.size()==n&&(i-ans.get(0))<min){
    //                     minans=s.substring(ans.get(0),i+1);
    //                     min=i-ans.get(0);
    
    //                     }
    //             }
    //             else if(arr1[x-'a'+58]==0){
    //                 int index_pre=queues.get(x).peek();//找到第一个该元素
    //                 //弹出旧的
    //                 while(!ans.isEmpty()&&index_pre>=ans.get(0)){
    //                     arr1[s.charAt(ans.get(0))-'a'+58]++;
    //                     queues.get(s.charAt(ans.get(0))).poll();
    //                     ans.poll();
                        
    //                 }
    //                 //加入当前的
    //                 ans.offer(i);
    //                 queues.get(x).add(i);
    //                 arr1[x-'a'+58]--;
    //                 if(ans.size()==n&&(i-ans.get(0))<min){
    //                     minans=s.substring(ans.get(0),i+1);
    //                     min=i-ans.get(0);
    //                     }

    //             }
            
    //         }
    //         else{
    //             if(arr1[x-'a']>0){
    //                 arr1[x-'a']--;
    //                 ans.offer(i);
    //                 queues.get(x).add(i);
    //                 if(ans.size()==n&&(i-ans.get(0))<min){
    //                     minans=s.substring(ans.get(0),i+1);
    //                     min=i-ans.get(0);
    
    //                     }
    //             }
    //             else if(arr1[x-'a']==0){
    //                 int index_pre=queues.get(x).peek();//找到第一个该元素
    //                 while(!ans.isEmpty()&&index_pre>=ans.get(0)){
    //                     arr1[s.charAt(ans.get(0))-'a']++;
    //                     queues.get(s.charAt(ans.get(0))).poll();
    //                     ans.poll();
    //                 }
    //                 ans.offer(i);
    //                 queues.get(x).add(i);
    //                 arr1[x-'a']--;
    //                 if(ans.size()==n&&(i-ans.get(0))<min){
    //                     minans=s.substring(ans.get(0),i+1);
    //                     min=i-ans.get(0);
    //                 }
                        
    //             }
            
    //         }
            
    //     }
    //     if(ans.size()<n && minans==""){
    //         return "";
    //     }
    //     else {
    //         return minans;
    //     }


        
    // }
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        int min=m;
        String minans="";
        int [] arr1=new int[52];
        Map<Character, Queue<Integer>> queues = new HashMap<>();

        // 创建 26 个队列，分别以字母 a-z 命名
        for (char c = 'a'; c <= 'z'; c++) {
            queues.put(c, new LinkedList<>()); // 使用 LinkedList 实现队列
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            queues.put(c, new LinkedList<>()); // 使用 LinkedList 实现队列
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            char x= t.charAt(i);
            if(x>='A'&&x<='Z'){
                arr1[x-'a'+58]++;
            }
            else if(x>='a'&&x<='z'){
                arr1[x-'a']++;
            }
            // arr1[x-'a']++;
        }
        for(int i=0;i<52;i++){
            if(arr1[i]==0){
                arr1[i]=-2;
            }
        }
        for(int i=0;i<m;i++){
            char x=s.charAt(i);
            if(x>='A'&&x<='Z'){
                if(arr1[x-'a'+58]>0){
                    arr1[x-'a'+58]--;
                    ans.add(i);
                    queues.get(x).add(i);
                    if(ans.size()==n&&(i-ans.get(0))<min){
                        minans=s.substring(ans.get(0),i+1);
                        min=i-ans.get(0);
    
                        }
                }
                else if(arr1[x-'a'+58]==0){
                    int index_pre=queues.get(x).peek();//找到第一个该元素
                    //弹出旧的
                   ans.removeIf(index->index==index_pre);

                    queues.get(x).poll();
                    //加入当前的
                    ans.add(i);
                    queues.get(x).add(i);
                    // arr1[x-'a'+58]--;
                    if(ans.size()==n&&(i-ans.get(0))<min){
                        minans=s.substring(ans.get(0),i+1);
                        min=i-ans.get(0);
                        }

                }
            
            }
            else{
                if(arr1[x-'a']>0){
                    arr1[x-'a']--;
                    ans.add(i);
                    queues.get(x).add(i);
                    if(ans.size()==n&&(i-ans.get(0))<min){
                        minans=s.substring(ans.get(0),i+1);
                        min=i-ans.get(0);
    
                        }
                }
                else if(arr1[x-'a']==0){
                    int index_pre=queues.get(x).peek();//找到第一个该元素
                    
                    ans.removeIf(index->index==index_pre);

                    queues.get(x).poll();
                    ans.add(i);
                    queues.get(x).add(i);
                    // arr1[x-'a']--;
                    if(ans.size()==n&&(i-ans.get(0))<min){
                        minans=s.substring(ans.get(0),i+1);
                        min=i-ans.get(0);
                    }
                        
                }
            
            }
            
        }
        if(ans.size()<n && minans==""){
            return "";
        }
        else {
            return minans;
        }


        
    }
}