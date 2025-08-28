package String;

import java.util.*;

public class FindRepeatedDnaSequences {
   public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n <= 10) return res;

        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            freq.put(sub, freq.getOrDefault(sub, 0) + 1);
            if (freq.get(sub) == 2) {  // 第二次出现才加入结果
                res.add(sub);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        FindRepeatedDnaSequences frds = new FindRepeatedDnaSequences();
        String s = "AAAAAAAAAAA";
        List<String> result = frds.findRepeatedDnaSequences(s);
        System.out.println("Repeated DNA Sequences: " + result); // Output: ["AAAAACCCCC", "CCCCCAAAAA"]
    }
}
