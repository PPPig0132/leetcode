public class Rotate {
    public static void main(String[] args) {
        // 调用 hello 方法
        int nums[] = {1,2,3,4,5,6,7};
        int k=2;
        Rotate rotate = new Rotate();
        rotate.rotate(nums,k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
       
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        swap(nums,0,n-k-1);
        swap(nums,n-k,n-1);
        swap(nums,0,n-1);
        
    }
    public void swap(int []nums,int left,int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
       
    }
    
}
