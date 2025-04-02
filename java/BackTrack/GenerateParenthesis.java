package BackTrack;
import java.util.*;
/*
  优化后的代码逻辑
明确递归终止条件：当生成的字符串长度达到 2n 时，检查是否是一个有效的括号组合。如果是，则添加到结果中。
控制括号的添加：
如果左括号的数量小于 n，可以添加一个左括号。
如果右括号的数量小于左括号的数量，可以添加一个右括号。
避免重复：通过上述规则，自然地避免了重复的组合。
 */
public class GenerateParenthesis {
    public static void main(String args[]){
        int n=2;
        GenerateParenthesis obj=new GenerateParenthesis();
        List<String> ans=obj.generateParenthesis(n);
        System.out.println(ans.size());
        for(String str:ans){
            System.out.println(str);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) { // 如果当前字符串长度达到2n
            res.add(cur.toString()); // 添加到结果中
            return;
        }

        if (open < max) { // 如果左括号的数量小于n
            cur.append("("); // 添加左括号
            backtrack(res, cur, open + 1, close, max); // 递归
            cur.deleteCharAt(cur.length() - 1); // 回溯
        }

        if (close < open) { // 如果右括号的数量小于左括号的数量
            cur.append(")"); // 添加右括号
            backtrack(res, cur, open, close + 1, max); // 递归
            cur.deleteCharAt(cur.length() - 1); // 回溯
        }
    }
    
}
