package dp;

public class AtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int res = 0;
        
        // Numbers with less digits
        for (int i = 1; i < len; i++) {
            res += Math.pow(digits.length, i);
        }
        
        // Numbers with same digits
        for (int i = 0; i < len; i++) {
            boolean prefix = false;
            for (String d : digits) {
                if (d.charAt(0) < s.charAt(i)) {
                    res += Math.pow(digits.length, len - 1 - i);
                } else if (d.charAt(0) == s.charAt(i)) {
                    prefix = true;
                    break;
                }
            }
            if (!prefix) return res;
        }
        
        return res + 1;
    }
    public static void main(String[] args) {
        AtMostNGivenDigitSet solver = new AtMostNGivenDigitSet();
        String[] digits = {"1", "3", "5", "7"};
        int n = 100;
        int result = solver.atMostNGivenDigitSet(digits, n);
        System.out.println("Count of numbers: " + result);
    }
}
