import ListNode.Node;
import java.util.*;
/*
 * 通过hashset绑定新节点和旧节点
 */
public class CopyRandomList2 {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Map<Node,Node>hashmap=new HashMap<Node,Node>();
        Node new_head=new Node(head.val);
        Node end=head,end1=new_head,random;
        hashmap.put(head,new_head);
        while(end!=null){
            random=end.random;
            if(random!=null){
                if(hashmap.containsKey(random)){
                    end1.random=hashmap.get(random);
                }
                else{
                    end1.random=new Node(random.val);
                    hashmap.put(random,end1.random); 
                }
                
            }
            if(hashmap.containsKey(end.next)){
                    end1.next=hashmap.get(end.next);
                }
            else{
                if(end.next!=null){
                    end1.next=new Node(end.next.val);
                    hashmap.put(end.next,end1.next); 
                }
                else{
                    end1.next=null;
                }
                
            }
            end=end.next;
            end1=end1.next;
        }
        return new_head;

    }
    public static void main(String[] args) {
        //{{7,null},{13,0},{11,4},{10,2},{1,0}};
        Node head=new Node(7);
        Node node1=new Node(13);
        Node node2=new Node(11);
        Node node3=new Node(10);
        Node node4=new Node(1);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        head.random=null;
        node1.random=head;
        node2.random=node4;
        node3.random=node2;
        node4.random=head;
        CopyRandomList2 copyRandomList2=new CopyRandomList2();
        Node new_head=copyRandomList2.copyRandomList(head);
        while(new_head!=null){
            System.out.println(new_head.val+" ");
            new_head=new_head.next;
        }
        
    }
    
}
