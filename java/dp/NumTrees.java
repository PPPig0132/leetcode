package dp;

public class NumTrees {
     public int numTrees(int n) {
        if (n == 0)  return 0;
        int nums[]=new int[n+1];
        nums[0]=1;
        nums[1]=1;
        dp(nums, n);
        return nums[n];
    }
    public void dp(int nums[],int n){
        for(int i=2;i<=n;++i){
            int res=0,j=1;
            for(;j<=(i)/2;++j){
                int l=j-1;
                int r=i-j;
                res+=nums[l]*nums[r];
            }
            res*=2;
            if((i&1)==1){
                res+=nums[j-1]*nums[i-j];
            }
            nums[i]=res;
        }
    }
    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        int result = numTrees.numTrees(6);
        // 输出结果
        System.out.println(result); // 输出：5
    }
}
