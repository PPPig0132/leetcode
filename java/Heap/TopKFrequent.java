package Heap;
import java.util.*;
/*
使用hashmap先统计每个词出现的频率
使用最小堆对频率进行排序
创建一个大小为k的小根堆，将每个新元素与根顶元素比较，比栈顶元素大则替换栈顶元素，最后剩下的栈就是最大的k个元素
*/
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[k];
        Map<Integer,Integer>freq=new HashMap<Integer,Integer>();
        for(int i=0;i<n;++i){
           freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        int []key=new int[freq.size()];
        int index=0;
        for(Map.Entry<Integer,Integer>entry:freq.entrySet()){
            key[index++]=entry.getKey();
        }
        buildMinHeap(key,k,freq);
        for(int i=k;i<key.length;i++){
            if(freq.get(key[i])>freq.get(key[0])){
                swap(key,0,i);
                minMize(key,0,k,freq);
            }
        }
        for(int i=0;i<k;i++){
            ans[i]=key[i];
        }
        return ans;

        
    }
    public void buildMinHeap(int []a,int heapSize,Map<Integer,Integer>map){
        for(int i=heapSize/2-1;i>=0;i--){
            minMize(a,i,heapSize,map);
        }
                
    }
    public void minMize(int[]a,int root,int heapSize,Map<Integer,Integer>map){
        int l=root*2+1,r=root*2+2,largest=root;
        if(l<heapSize&& map.get(a[l])<map.get(a[largest])){
            largest=l;
        }
        if(r<heapSize&& map.get(a[r])<map.get(a[largest])){
            largest=r;
        }
        if(largest!=root){
            swap(a,root,largest);
            minMize(a,largest,heapSize,map);
        }


    }
    public void swap(int[]a,int l,int r){
        int temp=a[l];
        a[l]=a[r];
        a[r]=temp;
    }

    public static void main(String args[]){
        int []nums={1,1,1,2,2,3,3,3,3};
        int k=2;
        TopKFrequent obj=new TopKFrequent();
        int []ans=obj.topKFrequent(nums,k);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    
}
