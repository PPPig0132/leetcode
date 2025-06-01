package Heap;
/*IPO

找到 当前资本  可以满足 的项目中的 收益最大的项目

先按照成本排序，排完序以后使用小根堆获得当前成本下可以收益最大的前k个项目
*/
public class FindMaximizedCapital {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int ans=w;
        int heapSize=profits.length,n=profits.length;
        buildHeap(capital,profits,heapSize);
        for(int i=0;i<n;++i){
            swap(capital,profits,0,n-i-1);
            heapSize--;
            minHeapify(capital,profits,0,heapSize);
        }
    
        k=Math.min(k,profits.length);

        int start=0,cur=0;
        heapSize=1;
        while(start<n && cur<k ){
            int end=start;
            while(end<n && capital[end]<=ans){
                end++;
            }
            if(start==end){
                break;
            }
            
            for(int i=start;i<end;i++){
                 if(profits[i]>profits[cur]){
                    swap(profits,capital,i,cur);
                    minHeapify(profits,capital,cur,heapSize);
                    heapSize=Math.min(heapSize+1, k);
                 }
            }
            ans+=profits[cur++];
           
            start=end;
        }
       
        return ans;

        
    }
    public void buildHeap(int nums[],int another[],int heapSize){
        for(int i=heapSize/2-1;i>=0;--i){
            minHeapify(nums,another,i,heapSize);
        }

    }
    public void minHeapify(int nums[],int []another,int i,int heapSize){
        int l=2*i+1,r=2*i+2,min=i;
        if(l<heapSize && nums[min]<nums[l]){
            min=l;
        }
        if(r<heapSize && nums[min]<nums[r]){
            min=r;
        }
        if(min!=i){
            swap(nums,another,min,i);
            minHeapify(nums,another,min,heapSize);
        }
    }
    public void swap(int []a,int []b,int i,int j){
        int temp1=a[i],temp2=b[i];
        a[i]=a[j];b[i]=b[j];
        a[j]=temp1;b[j]=temp2;
    }

    public static void main(String[] args) {
        int k=1;
        int w=0;
        int []profits={3,2,1};
        int []capital={2,1,0};
        FindMaximizedCapital obj=new FindMaximizedCapital();
        System.out.println(obj.findMaximizedCapital(k,w,profits,capital));
    }

}
