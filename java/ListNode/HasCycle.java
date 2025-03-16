import ListNode.ListNode;
public class HasCycle {
    public static void main(String [] args){

    }
    public boolean hasCycle(ListNode head){
        if(head==null || head.next==null){
            return false;
            }
        ListNode pre=head,end=head;
        while(end!=null && end.next!=null){
            pre=pre.next;
            end=end.next;
            end=end.next;
            if(pre==end){
                return true;
            }
        }
        return false;
    
            
            
        }
    
}
