import ListNode.ListNode;
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if(x>100 || x<-100){
            return head;
        }
        ListNode new_head=new ListNode();
        new_head.next=head;
        ListNode  end=head,pre=new_head,pre1;
        while(end!=null && end.val<x){
            pre=end;
            end=end.next;
        }
        pre1=pre;
        while(end!=null){
            if(end.val<x){
                pre1.next=end.next;
                end.next=pre.next;
                pre.next=end;
                pre=pre.next;//插入不应该时头插法，因此pre的位置要后移
                end=pre1.next;
                continue;
            }
            pre1=end;
            end=end.next;
        }
        return new_head.next;
    }
    public static void main(String[] args) {
        int values[] = {1,4,3,0,2,5,2};
        ListNode head = ListNode.generateLinkList(values);
        ListNode.printList(head);
        Partition partition = new Partition();
        ListNode result = partition.partition(head, 3);
        ListNode.printList(result);
    }
}
