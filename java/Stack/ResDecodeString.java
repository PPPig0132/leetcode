package Stack;

import java.util.Stack;

/*
使用两个栈：
一个栈 countStack 用于存储重复次数。
一个栈 stringStack 用于存储当前解码的字符串。
遍历字符串：
如果当前字符是数字，解析出完整的数字并压入 countStack。
如果当前字符是字母，直接添加到当前解码的字符串中。
如果当前字符是 [，将当前解码的字符串压入 stringStack，并重置当前解码的字符串。
如果当前字符是 ]，从 stringStack 中弹出一个字符串，并从 countStack 中弹出一个重复次数，将当前解码的字符串重复指定次数后拼接到弹出的字符串后面。
最终结果：
遍历结束后，stringStack 中的最后一个字符串即为解码后的结果。
 */
public class ResDecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // 解析完整的数字
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // 将当前解码的字符串和重复次数压入栈
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0; // 重置 k
            } else if (c == ']') {
                // 从栈中弹出一个字符串和重复次数
                int repeatTimes = countStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < repeatTimes; j++) {
                    temp.append(currentString);
                }
                currentString = stringStack.pop().append(temp);
            } else {
                // 如果是字母，直接添加到当前解码的字符串中
                currentString.append(c);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        String s = "3[a2[c]]";
        System.out.println("Decoded string: " + solution.decodeString(s)); // 输出 "accaccacc"
    }
    
}
