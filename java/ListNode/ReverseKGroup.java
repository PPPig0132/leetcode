import ListNode.ListNode;

public class ReverseKGroup {
    public static void main(String args[]){
        int []a={1,2};
        ListNode head=ListNode.generateLinkList(a);
        int k=2;
        ReverseKGroup obj=new ReverseKGroup();
        ListNode x=obj.reverKGroup(head,k);
        while(x!=null){
            System.out.print(x.val+" ");
            x=x.next;
        }


    }
    public ListNode reverKGroup(ListNode head, int k){
        if (head == null || k==1){
            return head;
        }
        ListNode pre=new ListNode(),end=head;
        //pre.next=head;
        head=pre;
        int x=k;
        while(end!=null){
             x=k;
            ListNode end1=end,new_head=end;
            while(x>0 && end!=null){
                if(end!=null){
                    end=end.next;
                    x--;
                }
            }
            if(x>0){
                end=new_head;
                break;
            }
            x=k;
            while(x>0 && end1!=null){
                ListNode temp=end1;
                end1=end1.next;
                temp.next=pre.next;
                pre.next=temp;
                x--;
            }
            pre=new_head;
        }
        if(end!=null){
            pre.next=end;
        }
        return head.next;

    }
    
}
