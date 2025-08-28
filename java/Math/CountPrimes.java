package Math;
/*给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
idea:用减法
找到最大质数
分别减去非质数的数
*/
public class CountPrimes {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        boolean []mark=new boolean[n];
        mark[0]=true;
        mark[1]=true;
        for(int i=2;i*i<n;++i){
            if(!mark[i] ){
                for(int j=i*i;j<n;j+=i){
                    mark[j]=true;
                }
            }
        }
        int count = 0;
        for (boolean prime: mark) {
            if (!prime) count++;
        }
        return count;
        
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        int n = 10;
        System.out.println("Count of Primes less than " + n + ": " + cp.countPrimes(n)); // Output: 4 (2, 3, 5, 7)

        n = 20;
        System.out.println("Count of Primes less than " + n + ": " + cp.countPrimes(n)); // Output: 8 (2, 3, 5, 7, 11, 13, 17, 19)
    }
}
