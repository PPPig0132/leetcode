package Math;
/*判断数字是否是回文数，负数不是*/
public class IsPalindrome {
    public boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }
        int l=0,index=0;
        int nums[]=new int[10];
        while(x>0){
            nums[index++]=x%10;
            x/=10;
        }
        index--;
        while(l<index){
            if(nums[l]!=nums[index]){
                return false;
            }
            index--;
            l++;
        }
        return true;
        
    }
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(121)); // true
        System.out.println(isPalindrome.isPalindrome(-121)); // false
        System.out.println(isPalindrome.isPalindrome(0)); // false
        System.out.println(isPalindrome.isPalindrome(12321)); // true
    }
    
}