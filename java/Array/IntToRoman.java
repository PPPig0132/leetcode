package Array;
/*
罗马数字转阿拉伯数字
10的次方最多出现3次，出现四次的用减法
*/

public class IntToRoman {
    public String intToRoman(int num) {
        int a,c;
        String []map={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};//(1,4,5,9,10,40,50,90,100,400,500,900,1000)
        int count[]=new int[map.length];
        int index=0;
        StringBuilder sb=new StringBuilder();
        while(num>0){
            a=num%10;
            if(a>0){
                switch(a){
                    case 9:
                        count[index+3]++;
                        break;
                    case 4:
                        count[index+1]++;
                        break;
                    default:
                        if(a>=5){
                            count[index+2]++;
                            count[index]=a-5;
                        }
                        else{
                            count[index]=a;
                        }
                }
            }
            num=num/10;
            index+=4;
        }
        for(int i=12;i>=0;--i){
            c=count[i];
            while(c>0){
                sb.append(map[i]);
                c--;
            }
        }
        return sb.toString();
        
    }
    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        int num = 58;
        System.out.println(intToRoman.intToRoman(num)); // Output: "MCMXCIV"
    }
}
