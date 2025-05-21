package Hash;

import java.util.*;

public class GroupAnagrams {
     public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,Integer>map=new HashMap<String,Integer>();
        List<List<String>>ans=new ArrayList<List<String>>();
        //int index=0;
        for(String str:strs){
            // String key;
            // if(str==""){
            //     key="0";
            // }
            // else{
            //     int pos[]=new int[26];
            //     for(char c:str.toCharArray()){
            //         pos[c-'a']++;
            //     }
            //     StringBuilder temp=new StringBuilder();
            //     for(int i=0;i<26;++i){
            //         if(pos[i]>0){
            //             temp.append(pos[i]);
            //             temp.append((char)('a'+i));
            //         }
            //     }
            //     key=temp.toString();
            // }
            char key1[]=str.toCharArray();
            Arrays.sort(key1);
            String key=new String(key1);
            if(map.containsKey(key)){
                ans.get(map.get(key)).add(str);
            }
            else{
                List<String>item=new ArrayList<String>();
                item.add(str);
                ans.add(item);
                map.put(key,ans.size()-1);
            }

        }
        return ans;
        
    }
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = ga.groupAnagrams(strs);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
    
}
