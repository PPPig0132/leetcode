package String;
/*
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
 */
import java.util.*;
public class ValidParentheses {
    public static boolean isValid(String s) {
        // 创建一个栈，用于存储左括号
        java.util.Stack<Character> stack = new java.util.Stack<>();

        // 遍历字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果是左括号，压入栈中
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 如果是右括号，检查栈顶是否有对应的左括号
                if (stack.isEmpty()) {
                    // 如果栈为空，说明没有对应的左括号
                    return false;
                }

                // 弹出栈顶元素
                char top = stack.pop();

                // 检查是否匹配
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    // 如果不匹配，返回false
                    return false;
                }
            }
        }

        // 如果栈为空，说明所有括号都正确匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([)]";
        String s3 = "{[]}";

        System.out.println("Is valid: " + isValid(s1)); // true
        System.out.println("Is valid: " + isValid(s2)); // false
        System.out.println("Is valid: " + isValid(s3)); // true
    }
}