import java.util.*;


public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * lfu design
     * @param operators int整型二维数组 ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
     public static class Node{
        private int key;
        int val;
        int w;
        Node pre;
        Node next;
        Node(int k, int v,int wei){
            key=k;
            val=v;
            w=wei;
        }
     }
    private Map<Integer,Node>map;
    private Node head;
    private Node tail;
    public int[] LFU (int[][] operators, int k) {
        // write code here
        map=new HashMap<>();
        head=new Node(0,0,0);
        tail=new Node(0,0,0);
        head.next=tail;
        tail.pre=head;
        List<Integer>ans=new ArrayList<>();
        for(int []oper:operators){
            if(oper[0]==2){
                if(map.containsKey(oper[1])){
                    Node temp=map.get(oper[1]);
                    temp.w=temp.w+1;
                    moveNode(temp);
                    ans.add(temp.val);
                }
                else{
                    ans.add(-1);
                }
                System.out.println(tail.pre.key);
                // System.out.println(head.next.key);
            }
            else{
                if(map.containsKey(oper[1])){
                    Node temp=map.get(oper[1]);
                    temp.val=oper[2];
                    temp.w++;
                    moveNode(temp);
                }
                else{
                    if(map.size()==k){
                        Node toEvict=tail.pre;
                        removeNode(toEvict);
                        map.remove(toEvict.key);
                    }
                    Node toAdd=new Node(oper[1],oper[2],1);
                    map.put(oper[1],toAdd);
                    addNode(toAdd);
                }
                // System.out.println(head.next.key);

            }
        }
        int res[]=new int [ans.size()];
        for(int i=0;i<ans.size();++i){
            res[i]=ans.get(i);
        }


        return res;
    }
    public void moveNode(Node node){
        if(node.pre==head)return;
        Node temp=node;
        // System.out.println(temp.pre.key);
        // System.out.println(temp.pre.w);
        while(temp.pre!=head && temp.w>=temp.pre.w){
            temp=temp.pre;
        }
        removeNode(node);
        node.pre=temp.pre;
        temp.pre.next=node;
        temp.pre=node;
        node.next=temp;

    }
    public void removeNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    public void addNode(Node node){
        Node temp=tail;
        while(temp.pre!=head && temp.pre.w<2){
            temp=temp.pre;
        }
        node.pre=temp.pre;
        temp.pre.next=node;
        temp.pre=node;
        node.next=temp;
    }
    public static void main(String[] args) {
        Solution1 obj = new Solution1();
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 3},{1,4,4}, {2, 4}, {2, 3}, {2, 2}, {2, 1},{1,5,5},{2,4}};
        int k=4;
        int[] result = obj.LFU(operators, k);
        System.out.println(Arrays.toString(result)); // 输出结果
    }
}