import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> temp, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                backtrack(result, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        List<List<String>> result = solution.partition(s);
        System.out.println(result); // 输出：[["a","a","b"],["aa","b"]]
    }
}