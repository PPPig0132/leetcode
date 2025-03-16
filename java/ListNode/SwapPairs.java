import ListNode.ListNode;   
public class SwapPairs {
    public static void main(String []args){

    }
    public ListNode swapPairs(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre=new ListNode();
        pre.next=head;
        head=pre;
        ListNode end=head.next;
        while(pre!=null){
            if(end!=null && end.next!=null){//每次同时处理两个节点
                ListNode temp=end;
                end=end.next;
                temp.next=end.next;
                pre.next=end;
                end.next=temp;
                end=end.next.next;
            }
            pre=pre.next;
            if(pre!=null){
                pre=pre.next;
            }
        }
        return head.next;
    }
    
}
