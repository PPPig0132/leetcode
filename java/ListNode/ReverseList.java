import ListNode.ListNode;

public class ReverseList {
    public static void main(String []args){
        int []arr={1,2,3,4,5};
        ListNode head=ListNode.generateLinkList(arr);
        ReverseList rl=new ReverseList();
        // ListNode x=head;
        ListNode x=rl.reverseList(head);
        while (x!=null){
            System.out.println(x.val);
            x=x.next;
            
        }

    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=new ListNode();
        pre.next=head;
        head=pre;
        pre=pre.next;
        head.next=null;
        while(pre!=null){
            ListNode temp=pre;
            pre=pre.next;
            temp.next=head.next;
            head.next=temp;
        }
        return head.next;
            
        }
        
    
}
