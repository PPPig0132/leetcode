package Math;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int res[]=new int[n+1];
        int mark=1;//进位符
        for(int i=n-1;i>=0;--i){
            if(mark==1){
                res[i+1]=(digits[i]+mark)%10;
                mark=(digits[i]+mark)/10;
            }
            else{
                res[i+1]=digits[i];
            }
        }
        if(mark==1){
            res[0]=1;
            return res;
        }
        System.arraycopy(res,1,digits,0,n);
        return digits;
    }
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {9};
        int[] result = plusOne.plusOne(digits);
        for (int digit : result) {
            System.out.print(digit + " ");
        }
        // Output: 1 2 4
    }
}
