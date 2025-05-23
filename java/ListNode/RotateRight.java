import ListNode.ListNode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        //计算长度
        int len=0;
        ListNode end=head,pre=head,new_head;
        while(end!=null){
            end=end.next;
            len++;
        }
        //计算偏移量
        k=k%len;
        if(k==0){
            return head;
        }
        end=head;
        while(k>0){
            end=end.next;
            k--;
        }
        while(end.next!=null){
            pre=pre.next;
            end=end.next;
        }
        new_head=pre.next;
        pre.next=null;
        end.next=head;
        return new_head;
    }
    public static void main(String[] args) {
        int values[] = {1, 2, 3, 4, 5};
        ListNode head = ListNode.generateLinkList(values);
        ListNode.printList(head);
        int k = 2;
        RotateRight rr = new RotateRight();
        ListNode result = rr.rotateRight(head, k);
        ListNode.printList(result);
    }
}
