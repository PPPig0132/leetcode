package String;
/*字符串转换为数字*/

public class TitleToNumber {
    public int titleToNumber(String columnTitle) {
        //char []c1=columnTitle.toCharArray();
        int res=0,c=1;
        for(int i=columnTitle.length()-1;i>=0;--i){
            int now=(columnTitle.charAt(i)-'A'+1)*c;
            c*=26;
            res+=now;
        }
        return res;
    }
    public static void main(String[] args) {
        TitleToNumber ttn = new TitleToNumber();
        System.out.println(ttn.titleToNumber("A")); // Output: 1
        System.out.println(ttn.titleToNumber("Z")); // Output: 26
        System.out.println(ttn.titleToNumber("AA")); // Output: 27
        System.out.println(ttn.titleToNumber("AB")); // Output: 28
        System.out.println(ttn.titleToNumber("ZY")); // Output: 701
    }
}
