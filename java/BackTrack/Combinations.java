package BackTrack;
import java.util.*;

public class Combinations {
    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        // 数字到字母的映射
        String[] phoneMap = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, phoneMap, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String digits, int index, String[] phoneMap, StringBuilder current, List<String> result) {
        if (index == digits.length()) { // 如果已经处理完所有数字
            result.add(current.toString()); // 将当前组合添加到结果中
            return;
        }

        // 获取当前数字对应的字母组
        String letters = phoneMap[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter); // 将当前字母添加到组合中
            backtrack(digits, index + 1, phoneMap, current, result); // 递归处理下一个数字
            current.deleteCharAt(current.length() - 1); // 回溯，移除最后一个字母
        }
    }
}