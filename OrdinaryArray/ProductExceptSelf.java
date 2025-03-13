public class ProductExceptSelf {
    public static void main(String []args){
        ProductExceptSelf prod=new ProductExceptSelf();
        int []nums={1,2,3,4};
        int []ans=prod.productExceptSelf(nums);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }

    }
    public int[] productExceptSelf(int[] nums) {
        int []ans=new int [nums.length];
        int prod=1;
        ans[0]=1;
        for(int i=1;i<nums.length;i++){
            prod*=nums[i-1];
            ans[i]=prod;
        }
        int right=1;
        for(int i=nums.length-2;i>=0;i--){
            right*=nums[i+1];
            ans[i]=ans[i]*right;
        }
        return ans;
        }
        
    
}
