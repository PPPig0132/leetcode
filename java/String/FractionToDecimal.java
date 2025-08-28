package String;
import java.util.*;
/*通过判断余数是否出现过来解决循环小数 */
public class FractionToDecimal {
     public String fractionToDecimal(int numerator, int denominator) {
        // 处理 0
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        // 1. 符号
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append('-');
        }

        // 2. 整数部分（全部转 long 防溢出）
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        sb.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return sb.toString();
        }

        // 3. 小数点
        sb.append('.');

        // 4. 小数部分：余数 -> 下标
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                // 出现循环
                int pos = map.get(remainder);
                sb.insert(pos, '(');
                sb.append(')');
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        FractionToDecimal ftd = new FractionToDecimal();
        int numerator = 10;
        int denominator = 333;
        System.out.println("Fraction to Decimal: " + ftd.fractionToDecimal(numerator, denominator)); // Output: "0.(3)"

        numerator = 1;
        denominator = 7;
        System.out.println("Fraction to Decimal: " + ftd.fractionToDecimal(numerator, denominator)); // Output: "0.(285714)"

        numerator = 1;
        denominator = 6;
        System.out.println("Fraction to Decimal: " + ftd.fractionToDecimal(numerator, denominator)); // Output: "0.1(6)"
    }
}
