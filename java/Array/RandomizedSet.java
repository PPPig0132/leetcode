package Array;
import java.util.*;

/*
idea:
hash+list实现
重点在删除操作：
如果存在，将动态数组中该元素所在位置的值替换为动态数组的最后一个元素，更新哈希表中对应索引，并移除动态数组的最后一个元素，返回 true。
*/
public class RandomizedSet {
    private List<Integer>list;
    private Map<Integer,Integer>map;

    public RandomizedSet() {
        list=new ArrayList<Integer>();
        map=new HashMap<Integer,Integer>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        else{
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index=map.get(val);
            if(index==list.size()-1){
                list.remove(index);
                map.remove(val);
            }
            else{
                int end=list.get(list.size()-1);
                list.set(index,end);
                list.remove(list.size()-1);
                map.remove(val);
                map.put(end,index);

            }

            
            return true;
        }
        else{
            
            return false;
        }

        
    }
    
    public int getRandom() {
        Random random=new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Output: true
        System.out.println(randomizedSet.remove(2)); // Output: false
        System.out.println(randomizedSet.insert(2)); // Output: true
        System.out.println(randomizedSet.getRandom()); // Output: 1 or 2 (randomly)
        System.out.println(randomizedSet.remove(1)); // Output: true
        System.out.println(randomizedSet.insert(2)); // Output: false
        System.out.println(randomizedSet.getRandom()); // Output: 2
    }
}
