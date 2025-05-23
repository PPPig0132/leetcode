/*
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
*/
import ListNode.ListNode;
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        ListNode pre=new ListNode();
        pre.next=head;
        int now=0,count=right+1-left;
        ListNode end=pre,temp,temp1;
        while(end!=null && now<left-1){
            end=end.next;
            now++;
        }
        pre=end;end=end.next;temp=end;
        pre.next=null;
        while(count>0){
            temp1=temp.next;
            temp.next=pre.next;
            pre.next=temp;
            temp=temp1;
            count--;
        }
        end.next=temp;

        if(left==1){
            return pre.next;
        }
        
        return head;
    }
    public static void main(String[] args) {
        int values[] = {1, 2, 3, 4, 5};
        ListNode head = ListNode.generateLinkList(values);
        ListNode.printList(head);
        int left = 1;
        int right = 4;
        ReverseBetween rb = new ReverseBetween();
        ListNode result = rb.reverseBetween(head, left, right);
        ListNode.printList(result);
        
    }
    
}
