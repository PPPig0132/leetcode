package ForOffer;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        quickSort(nums,0,nums.length-1);
if(nums[0]==0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<nums.length;i++){
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    void quickSort(int[] nums,int left,int right){
        if(left<right){
            int pos=partition(nums,left,right);
            quickSort(nums,left,pos-1);
            quickSort(nums,pos+1,right);
        }
    }

    int  partition(int[] nums,int left,int right){
        int pivot=nums[left];
        int i=left;

        long multiy=10;
        while(pivot>=multiy){
            multiy*=10;
        }

        for(int j=left+1;j<=right;j++){
            long multix=10;
            while(nums[j]>=multix){
                multix*=10;
            }

            if(pivot*multix+nums[j]<nums[j]*multiy+pivot){
                i++;
                swap(nums,i,j);
            }
        }

        swap(nums,left,i);
        return i;
    }

    void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
