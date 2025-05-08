package Array;

import java.util.*;

public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>ans=new ArrayList<String>();
        int start=0,n=words.length;

        while(start<n){
            int end=start,len=0;
            StringBuilder item=new StringBuilder();
            while(end<n&&len+words[end].length()<=maxWidth){
                len+=words[end++].length()+1;
            }
           
            int count=maxWidth+1-len;
            if(end==n){
                for(int i=start;i<end-1;++i){
                    item.append(words[i]);
                    item.append(" ");
                }
                item.append(words[end-1]);
                for(int i=0;i<count;++i){
                    item.append(" ");
                }
                ans.add(item.toString());
                break;
            }
            if(end-start!=1){
                int number=end-start-1,avg=count/number+1,remain=count%number;
                int index=0;
                while(index<number){
                    while(index<remain){
                        item.append(words[start+index]);
                        item.append(repeat(avg+1));
                        index++;
                    }
                    item.append(words[start+index]);
                        item.append(repeat(avg));
                        index++;
                }
                item.append(words[end-1]);
                 ans.add(item.toString());
            }
            else{
                
                item.append(words[start]);
                for(int i=0;i<count;++i){
                    item.append(" ");
                }
                 ans.add(item.toString());
            }
            start=end;
        }
        return ans;
        
    }
    public String repeat(int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
        
    public static void main(String[] args) {
        FullJustify fj = new FullJustify();
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int maxWidth = 16;
        List<String> result = fj.fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.println(line); // Output: ["This    is    an", "example  of text", "justification.  "]
        }
    }
    
}
