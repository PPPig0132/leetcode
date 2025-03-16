import ListNode.ListNode;
public class DetectCycle {
    public static void main(String []args){
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=b;

        DetectCycle dc=new DetectCycle();
        ListNode result=dc.detectCycle(a);
        System.out.println(result.val);

    }

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
       return null;
        }
   ListNode pre=head, end=head;
   pre=head.next;
   end=end.next.next;
 
   while(end!=null){
        if(pre==end){
            break;
        }
       pre=pre.next;
       end=end.next;
       if(end!=null){
           end=end.next;
       }
   }
   if(end==null){
       return null;
   }
   end=head;
   while(pre!=end){
       pre=pre.next;
       end=end.next;
   }

   return end;
   }
    
}
