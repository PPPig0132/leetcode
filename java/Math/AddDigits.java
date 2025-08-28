package Math;
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
//core idea: 能被9整数的数各位数字之和为9
public class AddDigits {
    public int addDigits(int num) {
         return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
