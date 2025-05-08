package Array;
/*
构建新数组 gas-cos
转换为找数组内连续子串自大和的问题
和最大的连续子串的起点就是求解的答案(循环数组，遍历两遍)
*/

public class CanCompleteCircuit {
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int max=0,sum=0,end=0,n=gas.length,index=0,total=0;
    //     for(int i=0;i<n;++i){
    //         gas[i]=gas[i]-cost[i];
    //         cost[i]=1;
    //         sum+=gas[i];
    //         total+=gas[i];
    //         if(sum<0){
    //             cost[i]=0;
    //             sum=0;
    //         }
    //         if(sum>max){
    //             end=i;
    //         }
    //     }
    //     if(total<0){
    //         return -1;
    //     }   
    //     for(int i=end+n;i>0;--i){
    //         index=i%n;
    //         if(cost[index]==0){
    //             return index+1;
    //         }
    //     }
    //     return 0;
    // }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0,ans=0,n=gas.length,res=0,total=0;
        for(int i=0;i<n;++i){
            res=gas[i]-cost[i];
            sum+=res;
            total+=res;
            if(sum<0){
                ans=i+1;
                sum=0;
            }
        }
        if (total<0){
            return -1;
        }
        return ans;
       
        
    }
    public static void main(String[] args) {
        CanCompleteCircuit solution = new CanCompleteCircuit();
        int[] gas = {3,1,1};
        int[] cost = {1,2,2};
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println("Starting index: " + result); // Output: 4
    }
    
}
