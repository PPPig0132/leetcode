package Array;
/*
罗马数字转整数
*/
public class RomanToInt {
    public int romanToInt(String s) {
        int n=s.length(),ans=0;
        int index=0;
        while(index<n){
            char c=s.charAt(index);
            char d;
            if(index<n-1){
                d=s.charAt(index+1);
            }
            else{
                d='A';
            }
            switch(c){
            case 'I':
                if(d=='V'){
                    ans+=4;
                    index+=2;
                }
                else if(d=='X'){
                    ans+=9;
                    index+=2;
                }
                else{
                    ans+=1;
                    index++;
                }
                break;
            case 'V':
                ans+=5;
                index++;
                break;
            case 'X':
               if(d=='L'){
                    ans+=40;
                    index+=2;
                }
                else if(d=='C'){
                    ans+=90;
                    index+=2;
                }
                else{
                    ans+=10;
                    index++;
                }
                break;
            case 'L':
                ans+=50;
                index++;
                break;
            case 'C':
                if(d=='D'){
                    ans+=400;
                    index+=2;
                }
                else if(d=='M'){
                    ans+=900;
                    index+=2;
                }
                else{
                    ans+=100;
                    index++;
                }
                break;
            case 'D':
                ans+=500;
                index++;
                break;
            case 'M':
                ans+=1000;
                index++;
                break;
        }
        }
        return ans;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        String s = "MCMXCIV";
        System.out.println(romanToInt.romanToInt(s)); // Output: 1994
    }
    
    
}
