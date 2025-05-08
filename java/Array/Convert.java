package Array;
/*
每一行之间的内容有固定的和行数的关系,每个元素和该行下一个元素之间的关系为：
2n-2,2n-4,...,4,2,2n-2
*/

public class Convert {
    // public String convert(String s, int numRows) {
    //     StringBuilder ans=new StringBuilder();
    //     char []c=s.toCharArray();
    //     int n=s.length(),distance=2*numRows-2,pos=0;
    //     if(n<numRows || numRows==1){
    //         return s;
    //     }
    //     while(pos<n){
    //         ans.append(c[pos]);
    //         pos+=distance;
    //     }
    //     for(int i=1;i<numRows-1;++i){
    //         pos=i;
    //         int temp=distance-2*i;
    //         while(pos<n){
    //             ans.append(c[pos]);
    //             if(pos+temp<n){
    //                 ans.append(c[pos+temp]);
    //             }
    //             pos+=distance;
    //         }
    //     }
    //     pos=numRows-1;
    //     while(pos<n){
    //         ans.append(c[pos]);
    //         pos+=distance;
    //     }
    //     return ans.toString();
    // }


    //通过max1和max2来控制每一行的元素个数，处理首行和尾行的情况
    public String convert(String s, int numRows) {
        int n=s.length();
        if (numRows >= n||numRows==1) {
            return s;
        }
        char[] res=new char[n];
        int j=0;
        int max1=2*numRows-2;
        int max2=0;
        for(int i=0;i<numRows;i++){
            int now_i=i;
            while (now_i < n) {
                if (max1 != 0) {
                    res[j++]=s.charAt(now_i);
                    now_i+=max1;
                }
                if (now_i < n && max2 != 0) {
                    res[j++]=s.charAt(now_i);
                    now_i+=max2;
                }
            }
            max1-=2;
            max2+=2;
        }
        return new String(res);
    }
    public static void main(String[] args) {
        Convert convert = new Convert();
        String s = "A";
        int numRows = 3;
        String result = convert.convert(s, numRows);
        System.out.println(result+" "+result.equals("PAHNAPLSIIGYIR")); // Output: "PAHNAPLSIIGYIR"
    }
}
